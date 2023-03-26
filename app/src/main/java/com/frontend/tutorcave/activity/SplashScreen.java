package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.frontend.tutorcave.R;

import java.util.logging.Level;
import java.util.logging.Logger;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class SplashScreen extends AppCompatActivity { // TODO: check the warning

    private LinearLayout layout;
    private TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        // assign components
        CompModel components = findComponent(layout, appName);
        layout = components.getLinearLayout();
        appName = components.getTextView();

        Animation splashAnim = AnimationUtils.loadAnimation(this, R.anim.transition);
        Animation textAnim = AnimationUtils.loadAnimation(this, R.anim.to_left);

        // TODO: load text anim first
        appName.startAnimation(textAnim);
        appName.startAnimation(splashAnim);
        layout.startAnimation(splashAnim);

        final Intent intent = new Intent(this, WelcomeActivity.class);

        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException exception) {
                    Logger.getLogger(SplashScreen.class.getName()).log(Level.WARNING, "Interrupted!: ", exception);
                    Thread.currentThread().interrupt();
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }

    // UTIL
    private CompModel findComponent(LinearLayout layout, TextView textView) {
        layout = (LinearLayout) findViewById(R.id.lytSplashBG);
        textView = (TextView) findViewById(R.id.txtSplashMain);
        CompModel components = new CompModel();
        components.setLinearLayout(layout);
        components.setTextView(textView);
        return components;
    }
}

class CompModel {
    private LinearLayout linearLayout;
    private TextView textView;

    public LinearLayout getLinearLayout() {
        return linearLayout;
    }

    public void setLinearLayout(LinearLayout linearLayout) {
        this.linearLayout = linearLayout;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}