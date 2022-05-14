package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LongGrassChapter extends AppCompatActivity {

    ImageView bag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_grass_chapter);

        init();
    }

    public void init(){
        bag = (ImageView) findViewById(R.id.LongGrassBag);
        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}