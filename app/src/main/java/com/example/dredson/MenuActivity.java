package com.example.dredson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {
    LinearLayout game1Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        game1Layout = (LinearLayout) findViewById(R.id.game1Box);
        game1Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchingMenu();
            }
        });
    }


    public void switchingMenu()
    {
        Intent intent = new Intent(MenuActivity.this,GameActivity.class);
        //transitionName must be named on both activities layout
        Pair<View,String> pair = Pair.create(findViewById(R.id.game1Image),"mygame1");
        //enable transitions in style
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MenuActivity.this,findViewById(R.id.game1Image),"mygame1");
        startActivity(intent,optionsCompat.toBundle());

    }
}
