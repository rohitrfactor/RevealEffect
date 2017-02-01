package com.pinnacle.garorasu.revealeffect;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        return true;
    }
    public void startReveal(View view){
        // previously invisible view
                View myView = findViewById(R.id.my_view);

        // get the center for the clipping circle
                int cx = myView.getWidth()/2 ;
                int cy = myView.getHeight() ;

        // get the final radius for the clipping circle
                float finalRadius = (float) Math.hypot(cx, cy);

        // create the animator for this view (the start radius is zero)
                Animator anim =
                        ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, cy);

        // make the view visible and start the animation
                myView.setVisibility(View.VISIBLE);
                anim.start();
    }
    public void hideReveal(View view){
        // previously visible view
                final View myView = findViewById(R.id.my_view);

        // get the center for the clipping circle
                int cx = myView.getWidth()/2;
                int cy = myView.getHeight();

        // get the initial radius for the clipping circle
                float initialRadius = (float) Math.hypot(cx, cy);

        // create the animation (the final radius is zero)
                Animator anim =
                        ViewAnimationUtils.createCircularReveal(myView, cx, cy, cy, 0);

        // make the view invisible when the animation is done
                anim.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        myView.setVisibility(View.INVISIBLE);
                    }
                });

        // start the animation
                anim.start();

    }
}
