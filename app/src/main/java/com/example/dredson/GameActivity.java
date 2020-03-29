package com.example.dredson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.gesture.Gesture;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnTouchListener,GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{
    private ImageView game1Image;
    private GestureDetector mygestures;
    private TextView game1Title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        game1Image = (ImageView) findViewById(R.id.game1Main);
        game1Title = (TextView) findViewById(R.id.game1Title);
        game1Image.setOnTouchListener(this);
        game1Title.setOnTouchListener(this);
        mygestures = new GestureDetector(this,this);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(v.getId() == R.id.game1Main) {
            mygestures.onTouchEvent(event);
            return true;
        }

        return true;
    }

    //Gestures
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
                Intent flingIntent = new Intent(this, FlingActivity.class);
                startActivity(flingIntent);

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Intent intent = new Intent(this, GameAction.class);
        startActivity(intent);
        return false;
    }

    //DoubleTapGestures
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Intent intent = new Intent(this, ShakerActivity.class);
        startActivity(intent);
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }
    @Override
    public void onBackPressed() {
    }
}
