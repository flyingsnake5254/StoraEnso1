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

public class WaitBus extends AppCompatActivity {

    Object obj , obj2;
    boolean haswait;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.busConversation);
                LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                tMessage.setText("到站了，下車吧");
                relativeLayout.addView(layout);
                ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        relativeLayout.removeAllViews();
                        Intent intent = new Intent(WaitBus.this , LongGrassChapter.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                        finish();
                    }
                });
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait_bus);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
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