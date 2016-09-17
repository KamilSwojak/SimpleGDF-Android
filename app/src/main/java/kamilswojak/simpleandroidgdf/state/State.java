package kamilswojak.simpleandroidgdf.state;

import android.graphics.Canvas;
import android.view.MotionEvent;

import kamilswojak.simpleandroidgdf.GameMainActivity;
import kamilswojak.simpleandroidgdf.Painter;


public abstract class State {

    public abstract void init();

    public abstract void update(float deltaMillis);

    public abstract void render(Painter p);

    public abstract boolean onTouch(MotionEvent event, int scaledX, int scaledY);

    public void setCurrentState(State state) {
        GameMainActivity.sGame.setCurrentState(state);
    }

}
