package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DreamGrandma2 extends AppCompatActivity {

    String[] messages = {
            "(回憶)\n阿嬤：\n" + "還記得你之前種的那棵樹嗎？它已經長得夠大了，可以用來當做木工的材料了。" ,
            "(回憶)\n阿嬤：\n" + "你不是一直想要一個木製的壺嗎？還說要用自己做的壺替樹木澆水，這樣樹也會收到你的心意。" ,
            "(回憶)\n阿嬤：\n" + "記得，植物都是從種子開始，用心灌溉才會成長茁壯…"};
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
                    Intent intent = new Intent(DreamGrandma2.this , UnderTree2.class);
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