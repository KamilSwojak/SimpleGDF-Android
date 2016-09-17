package kamilswojak.simpleandroidgdf.state;

import android.view.MotionEvent;

import kamilswojak.simpleandroidgdf.Assets;
import kamilswojak.simpleandroidgdf.Painter;

public class MenuState extends State {
    @Override
    public void init() {

    }

    @Override
    public void update(float deltaMillis) {

    }

    @Override
    public void render(Painter p) {
        p.drawBitmap(Assets.welcome, 0, 0);
    }

    @Override
    public boolean onTouch(MotionEvent event, int scaledX, int scaledY) {
        return false;
    }
}
