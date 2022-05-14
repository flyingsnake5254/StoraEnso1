package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class OutdoorBeam extends AppCompatActivity {

    ImageView rightArrow;
    boolean itemCanClick = true;
    LinearLayout zoomBeam;
    RelativeLayout showPassword;
    ImageView exitZoomBeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor_beam);
        exitZoomBeam = (ImageView) findViewById(R.id.exitZoomBeam);

        rightArrow = (ImageView) findViewById(R.id.BeamRightArrow);
        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    Intent intent = new Intent(OutdoorBeam.this , HouseDoorFront.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                    finish();
                }
            }
        });

        showPassword = (RelativeLayout) findViewById(R.id.showPassword);
        zoomBeam = (LinearLayout) findViewById(R.id.zoomBeam);
        zoomBeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    itemCanClick = false;
                    showPassword.setVisibility(View.VISIBLE);
                }
            }
        });

        exitZoomBeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPassword.setVisibility(View.INVISIBLE);
                itemCanClick = true;
            }
        });
    }
}