package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DreamGrandma extends AppCompatActivity {
    String[] messages = {
            "message1" ,
    "message2",
    "message3",
    "message4"};
    int count = messages.length;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream_grandma);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.dreamGrandmaRelative);
        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
        TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
        tMessage.setText(messages[messages.length - (count--)]);

        relativeLayout.addView(layout);

        ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 0){
                    relativeLayout.removeAllViews();
                    Intent intent = new Intent(DreamGrandma.this , DreamGrandma.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                    finish();
                }
                else{
                    tMessage.setText(messages[messages.length - (count--)]);
                }
            }
        });

    }
}