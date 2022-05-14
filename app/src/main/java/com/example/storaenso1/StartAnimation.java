package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class StartAnimation extends AppCompatActivity implements Animation.AnimationListener{

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_animation);

        init();

        Animation animation = AnimationUtils.loadAnimation(this , R.anim.start_animation);
        animation.setFillEnabled(true);
        animation.setFillAfter(true);
        animation.setAnimationListener(this);
        imageView.setAnimation(animation);
    }

    public void init(){
        imageView = (ImageView) findViewById(R.id.startLogo);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent intent = new Intent(StartAnimation.this , MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}