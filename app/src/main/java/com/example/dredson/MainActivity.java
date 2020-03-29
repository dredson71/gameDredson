package com.example.dredson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startSpringAnimation();
        buttonAnimation();
    }

    public void startSpringAnimation()
    {
        ImageView image = findViewById(R.id.titleHome);
        SpringAnimation spring = new SpringAnimation(image , DynamicAnimation.Y);
        SpringForce force = new SpringForce();
        force.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        force.setStiffness(SpringForce.STIFFNESS_LOW);
        force.setFinalPosition(700f);

        spring.setSpring(force);

        spring.start();;
    }

    public void iniciarMenu(View view)
    {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
    public void buttonAnimation()
    {
        Button playButton = findViewById(R.id.playButton);
        Button infoButton = findViewById(R.id.infoButton);
        Animation fromBottom = AnimationUtils .loadAnimation(this,R.anim.frombottom);

        playButton.setAnimation(fromBottom);
        infoButton.setAnimation(fromBottom);
    }
}
