package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.util.ComponentUtil;


//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Animation splashAnim = AnimationUtils.loadAnimation(this, R.anim.transition);
        Animation textAnim = AnimationUtils.loadAnimation(this, R.anim.to_left);

        LinearLayout layout;
        TextView appName;

        layout = (LinearLayout) findViewById(R.id.lytSplashBG);
        appName = (TextView) findViewById(R.id.txtSplashMain);

        appName.startAnimation(textAnim);
        appName.startAnimation(splashAnim);
        layout.startAnimation(splashAnim);

        ComponentUtil.redirectAfterSleep(SplashScreen.this, WelcomeActivity.class, SplashScreen.class.getName());
    }
}