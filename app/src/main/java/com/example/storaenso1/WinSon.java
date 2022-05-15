package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WinSon extends AppCompatActivity {

    String[] say1 = {
            "兒子：\n" + "爸，你還記得這個壺嗎？這是你和曾祖母的回憶，也是我們之間的回憶",
            "兒子：\n" + "你知道該怎麼做的，植物要『用心灌溉才會成長茁壯』，不是嗎？",
            "(獲得木製的壺)"
    };
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_son);

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
                    relativeLayout.removeAllViews();

                    Intent intent = new Intent(WinSon.this , SonGo.class);
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