package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class OnTree extends AppCompatActivity {

    FrameLayout show;
    ImageView confirm;

    int count = 0;
    String[] say1 = {
            "看到果實了!!" ,
            "但是為甚麼有這麼多傲骨燕?",
            "(傲骨燕使出翅膀攻擊)",
            "必須躲開他們的攻擊才行"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_tree);

        show = (FrameLayout) findViewById(R.id.showRule);
        confirm = (ImageView) findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnTree.this , OnTree1.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                finish();
            }
        });

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
                    show.setVisibility(View.VISIBLE);
                }
                else{
                    tMessage.setText(say1[say1.length - (count --)]);
                }
            }
        });
    }
}