package com.example.storaenso1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SonGame extends AppCompatActivity {

    FrameLayout bg;
    int countBlood = 4;

    MediaRecorder mediaRecorder;
    boolean hasPermission;
    boolean record;
    Thread t;
    boolean haswin ;
    double db;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    if(mediaRecorder != null){
                        db = mediaRecorder.getMaxAmplitude();

                        if(db > 20000){

                            haswin = true;
                            mediaRecorder.stop();
                            win();
                        }

                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son_game);


        bg = (FrameLayout) findViewById(R.id.fightSonBg);
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!haswin){
                    while(record){
                        Message message = new Message();
                        message.what = 1;
                        handler.sendMessage(message);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t.start();




        check();
        if(hasPermission && mediaRecorder == null){
            start();
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        stop();
    }
    public void stop(){
        if(mediaRecorder != null){
            try{
                mediaRecorder.stop();
            }catch (Exception e){

            }
            try{
                mediaRecorder.release();
            }catch (Exception e){

            }

            mediaRecorder = null;
            record = false;
        }
    }

    public void start(){
        if(mediaRecorder == null){
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.OGG);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.OPUS);
            mediaRecorder.setOutputFile("/dev/null");
            try
            {
                mediaRecorder.prepare();
            }catch (java.io.IOException ioe) {


            }catch (java.lang.SecurityException e) {

            }
            try
            {
                mediaRecorder.start();
                record = true;
            }catch (java.lang.SecurityException e) {

            }
        }
    }

    public void check(){
        if(ActivityCompat.checkSelfPermission(this , Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED){
            // has
            hasPermission = true;
        }
        else{
            hasPermission = false;
            ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.RECORD_AUDIO} , 1);
        }
    }

    public void win(){
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.HallWayConversation);
        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
        TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);

        tMessage.setText("兒子停止黑化了");
        relativeLayout.addView(layout);
        ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeLayout.removeAllViews();
                Intent intent = new Intent(SonGame.this , WinSon.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                finish();
            }
        });
    }



}