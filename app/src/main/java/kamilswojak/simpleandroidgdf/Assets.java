package kamilswojak.simpleandroidgdf;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;
import java.io.InputStream;

public class Assets {
    private static SoundPool soundPool;
    public static Bitmap welcome;

    public static void load() {
        welcome = loadBitmap("welcome.png", false);
    }

    private static Bitmap loadBitmap(String path, boolean transparency) {
        InputStream inputStream = null;

        try {
            inputStream = GameMainActivity.assetManager.open(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BitmapFactory.Options options = new BitmapFactory.Options();

        if (transparency) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        } else {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, options);

        return bitmap;
    }

    private static int loadSound(String path) {
        int soundId = 0;
        if (soundPool == null) {
            new SoundPool(25, AudioManager.STREAM_MUSIC, 0);
        }

        try {
            soundId = soundPool.load(GameMainActivity.assetManager.openFd(path), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return soundId;
    }

    public static void playSound(int soundId) {
        soundPool.play(soundId, 1, 1, 1, 0, 1);
    }


}
