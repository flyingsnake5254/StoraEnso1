package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class InnerHouse2 extends AppCompatActivity {

    RelativeLayout upArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_house2);

        upArrow = (RelativeLayout) findViewById(R.id.InnerHouse2UpArrow);
        upArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(" up ");
            }
        });
    }
}