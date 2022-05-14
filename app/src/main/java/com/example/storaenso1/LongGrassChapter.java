package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LongGrassChapter extends AppCompatActivity {

    ImageView bag , bagArrow , knife , upArrow;
    FrameLayout bagBack;
    boolean isConversation , hasKnife;
    boolean inBag;
    ImageView table1 , cutGrass , longGrass;
    public boolean holdKnife = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_grass_chapter);

        init();
    }

    public void init(){
        cutGrass = (ImageView) findViewById(R.id.shortGrass);
        longGrass = (ImageView) findViewById(R.id.longGrass);
        upArrow = (ImageView) findViewById(R.id.longGrassUp);

        upArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LongGrassChapter.this , HouseDoorFront.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                finish();
            }
        });
        longGrass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holdKnife){
                    longGrass.setVisibility(View.INVISIBLE);
                    cutGrass.setVisibility(View.VISIBLE);
                    upArrow.setVisibility(View.VISIBLE);
                }
                else if(!hasKnife && !isConversation && !inBag){
                    isConversation = true;
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.treeHouseConversation);
                    LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                    TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                    tMessage.setText("草太長了，過不去");
                    relativeLayout.addView(layout);
                    ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            isConversation = false;
                            relativeLayout.removeAllViews();
                        }
                    });
                }

            }
        });

        bag = (ImageView) findViewById(R.id.LongGrassBag);
        bagBack = (FrameLayout) findViewById(R.id.LongGrassBagBack);
        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isConversation){
                    inBag = true;
                    bag.setVisibility(View.INVISIBLE);
                    bagBack.setVisibility(View.VISIBLE);
                }
            }
        });

        bagArrow = (ImageView) findViewById(R.id.LongGrassArrow);
        bagArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isConversation){
                    inBag = false;
                    bag.setVisibility(View.VISIBLE);
                    bagBack.setVisibility(View.INVISIBLE);
                }
            }
        });

        table1 = (ImageView) findViewById(R.id.LongGrassBag1);
        knife = (ImageView) findViewById(R.id.knife);
        knife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isConversation){
                    isConversation = true;
                    knife.setVisibility(View.INVISIBLE);
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.treeHouseConversation);
                    LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                    TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                    tMessage.setText("找到一把鐮刀");
                    relativeLayout.addView(layout);
                    ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            table1.setVisibility(View.VISIBLE);
                            isConversation = false;
                            relativeLayout.removeAllViews();
                        }
                    });
                }
            }
        });

        table1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ImageView hold = (ImageView) findViewById(R.id.LongGrassHold);

                if(holdKnife){
                    Toast.makeText(LongGrassChapter.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    table1.setBackgroundColor(Color.parseColor("#00000000"));
                    hold.setImageResource(0);
                }
                else{
                    Toast.makeText(LongGrassChapter.this , "持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(R.drawable.knife);
                    table1.setBackgroundColor(Color.parseColor("#DDDDDD"));
                }

                holdKnife = (!holdKnife);
                return true;
            }
        });
    }
}