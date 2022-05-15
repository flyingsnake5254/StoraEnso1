package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                Intent intent = new Intent(InnerHouse2.this , HallWay.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                finish();
            }
        });
    }
}