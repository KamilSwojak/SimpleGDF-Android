package kamilswojak.simpleandroidgdf.animation;

import kamilswojak.simpleandroidgdf.Painter;

public class Animation {

    private Frame[] frames;
    private double[] frameEndTimes;
    private int currentFrameIndex = 0;

    private double totalDuration = 0;
    private double currentTime = 0;

    public Animation(Frame... frames) {
        this.frames = frames;
        frameEndTimes = new double[frames.length];

        for (int i = 0; i < frames.length; i++) {
            Frame f = frames[i];
            totalDuration += f.getDuration();
            frameEndTimes[i] = totalDuration;
        }
    }

    public synchronized void update(float increment) {
        currentTime += increment;

        if (currentTime > totalDuration) {
            wrapAnimation();
        }

        if (currentTime > frameEndTimes[currentFrameIndex]) {
            currentFrameIndex++;
        }
    }

    private void wrapAnimation() {
        currentFrameIndex = 0;
        currentTime %= totalDuration;
    }

    public synchronized void render(Painter p, int x, int y) {
        p.drawBitmap(frames[currentFrameIndex].getImage(), x, y);
    }

    public synchronized void render(Painter p, int x, int y, int width, int height) {
        p.drawBitmap(frames[currentFrameIndex].getImage(),x,y,width,height);
    }

}
