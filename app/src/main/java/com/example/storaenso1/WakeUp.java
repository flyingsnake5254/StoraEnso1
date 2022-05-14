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

public class WakeUp extends AppCompatActivity {

    ImageView bag , bag2;
    boolean isConversation = true;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wake_up);

        init();
        conversation();

    }

    public void init(){
        bag = (ImageView) findViewById(R.id.wakeUpBag);
        bag2 = (ImageView) findViewById(R.id.wakeUpBagIcon);
        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isConversation){
                    bag.setVisibility(View.INVISIBLE);
                    bag2.setVisibility(View.VISIBLE);
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.wakeUpConversation);
                    LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                    TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                    tMessage.setText("獲得背包");
                    relativeLayout.addView(layout);
                    ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(count == 0){
                                tMessage.setText("出門吧");
                                count ++;
                            }
                            else{
                                relativeLayout.removeAllViews();
                                Intent intent = new Intent(WakeUp.this , WaitBus.class);
                                startActivity(intent);
                                overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                                finish();
                            }

                        }
                    });
                }
            }
        });
    }

    public void conversation(){

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.wakeUpConversation);
        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
        TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
        tMessage.setText("還是去一下好了，冥冥之中好像有什麼在牽引著我。" +
                "\n帶著背包出門吧。");
        relativeLayout.addView(layout);
        ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeLayout.removeAllViews();
                isConversation = false;
            }
        });
    }
}