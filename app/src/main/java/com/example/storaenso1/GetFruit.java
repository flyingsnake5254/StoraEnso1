package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GetFruit extends AppCompatActivity {

    boolean itemCanClick;
    int count = 0;
    String[] say1 = {
            "(獲得裝著樹果實的壺)" ,
            "(OS:好繽紛的壺 XD)",
            "現在只要澆這棵樹就行了吧...",
            "(腳滑)\n糟糕!"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_fruit);

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
                    Intent intent = new Intent(GetFruit.this , FloatDown.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                    finish();

                }
                else{
                    tMessage.setText(say1[say1.length - (count --)]);
                }
            }
        });
    }
}