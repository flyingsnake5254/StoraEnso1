package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BirdGameFinish extends AppCompatActivity {


    boolean itemCanClick;
    int count = 0;
    String[] say1 = {
            "終於成功擊退傲骨燕了ㄎㄎ" ,
            "去拿果實吧!"
    };
    RelativeLayout fruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_game_finish);
        fruit = (RelativeLayout) findViewById(R.id.fruit);
        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    fruit.setVisibility(View.INVISIBLE);
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.HallWayConversation);
                    LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                    TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                    count = say1.length;
                    tMessage.setText("獲得果實");
                    relativeLayout.addView(layout);
                    ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            relativeLayout.removeAllViews();
                            Intent intent = new Intent(BirdGameFinish.this , GetFruit.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                            overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });

        itemCanClick = false;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.HallWayConversation);
        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
        TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
        count = say1.length;
        tMessage.setText(say1[say1.length - (count --)]);
        relativeLayout.addView(layout);
        ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 0){
                    itemCanClick = true;
                    relativeLayout.removeAllViews();

                }
                else{
                    tMessage.setText(say1[say1.length - (count --)]);
                }
            }
        });
    }
}