package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class UnderTree2 extends AppCompatActivity {

    String[] messages = {
            "原來是要用樹的果實!!" ,
            "看來必須爬上樹去摘果實了.." ,};
    int count = messages.length;

    RelativeLayout show;
    ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_tree2);


        show = (RelativeLayout) findViewById(R.id.showClimbTree);
        arrow = (ImageView) findViewById(R.id.climbTreeArrow);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnderTree2.this , OnTree.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                finish();
            }
        });

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
                    show.setVisibility(View.VISIBLE);
                }
                else{
                    tMessage.setText(messages[messages.length - (count--)]);
                }
            }
        });
    }
}