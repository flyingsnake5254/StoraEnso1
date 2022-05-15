package com.example.storaenso1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FloatDown extends AppCompatActivity {

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                Intent intent = new Intent(FloatDown.this , AfterFloat.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float_down);

//        Intent intent = new Intent(FloatDown.this , AfterFloat.class);
////                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//        overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
//        startActivity(intent);
//        finish();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}