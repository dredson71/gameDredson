package com.example.dredson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;

public class FlingActivity extends AppCompatActivity implements  GestureDetector.OnGestureListener{
        private GestureDetector gestureDetector;
        private float x1,x2,y1,y2;
        private static int MIN_DISANCE = 150;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fling);
        this.gestureDetector = new GestureDetector(FlingActivity.this,this  );
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break ;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();
                float valueX = x2 - x1;
                float valueY = y2 - y1;
                if(Math.abs(valueX) > MIN_DISANCE)
                {
                    if(!(x2>x1))
                    {
                        Intent intent = new Intent(FlingActivity.this,GameActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_left2,R.anim.slide_left);
                    }
                }

        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
    @Override
    public void onBackPressed() {
    }
}
