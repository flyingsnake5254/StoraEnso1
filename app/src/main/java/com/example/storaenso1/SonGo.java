package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SonGo extends AppCompatActivity {

    String[] say1 = {
            "只要用這個壺去澆那棵樹，那就不會再有犧牲者了吧!XD",
            "(OS:耶~~~程式快寫完了xddddd)"
    };
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son_go);

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

                    Intent intent = new Intent(SonGo.this , GoTree.class);
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