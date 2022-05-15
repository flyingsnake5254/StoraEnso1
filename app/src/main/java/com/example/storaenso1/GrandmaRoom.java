package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GrandmaRoom extends AppCompatActivity {

    boolean itemCanClick = true;
    // bag
    ImageView bag;
    FrameLayout bagBack;
    ImageView bagArrow ;
    ImageView knife;
    String holdItem = "";
    ImageView key;
    ImageView hold ;
    ImageView childLeg;
    ImageView screwDriver;

    //obj
//        驅鬼方法

    RelativeLayout ghostAway;
    ImageView exitGhostAway;
    LinearLayout showGhostAway;
    boolean hasRead;
    boolean hasA1 , hasA2 , hasA3;

    // 護身符
    RelativeLayout amulet1 , amulet2 , amulet3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grandma_room);

        init();
        clickBag();
        linstener();
    }

    public void init() {
        //obj
        showGhostAway = (LinearLayout) findViewById(R.id.showGhostAway);
        ghostAway = (RelativeLayout) findViewById(R.id.ghostAway);
        exitGhostAway = (ImageView) findViewById(R.id.exitGhostAway);
        amulet1 = (RelativeLayout) findViewById(R.id.GrandmaRoomAmulet1);
        amulet2 = (RelativeLayout) findViewById(R.id.GrandmaRoomAmulet2);
        amulet3 = (RelativeLayout) findViewById(R.id.GrandmaRoomAmulet3);

        // bag
        bag = (ImageView) findViewById(R.id.InnerHouse1Bag);
        bagBack = (FrameLayout) findViewById(R.id.InnerHouse1BagBack);
        bagArrow = (ImageView) findViewById(R.id.InnerHouse1BagArrow);
        knife = (ImageView) findViewById(R.id.InnerHouse1Knife);
        holdItem = "";
        key = (ImageView) findViewById(R.id.InnerHouse1Key);
        hold = (ImageView) findViewById(R.id.InnerHouse1Hold);
        childLeg = (ImageView) findViewById(R.id.InnerHouseLeg);
        screwDriver = (ImageView) findViewById(R.id.ScrewDriver);
    }

    public void clickBag(){
        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    itemCanClick = false;
                    bag.setVisibility(View.INVISIBLE);
                    bagBack.setVisibility(View.VISIBLE);

                    bagArrow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bag.setVisibility(View.VISIBLE);
                            bagBack.setVisibility(View.INVISIBLE);
                            itemCanClick = true;
                        }
                    });
                }
            }
        });


        knife.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(holdItem.equals("knife")){
                    holdItem = "";
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    Toast.makeText(GrandmaRoom.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "knife";
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    knife.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(GrandmaRoom.this , "持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(R.drawable.knife);
                }
                return true;
            }
        });

        key.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(holdItem.equals("key")){
                    holdItem = "";
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    Toast.makeText(GrandmaRoom.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "key";
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(GrandmaRoom.this , "持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(R.drawable.key);
                }
                return true;
            }
        });

        childLeg.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(holdItem.equals("chairLeg")){
                    holdItem = "";
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    Toast.makeText(GrandmaRoom.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "chairLeg";
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(GrandmaRoom.this , "持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(R.drawable.broken_chair2);
                }
                return true;
            }
        });

        screwDriver.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(holdItem.equals("screwDriver")){
                    holdItem = "";
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    Toast.makeText(GrandmaRoom.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "screwDriver";
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(GrandmaRoom.this , "持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(R.drawable.screwdriver);
                }
                return true;
            }
        });

    }

    public void linstener(){

        amulet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    hasA2 = true;
                    amulet2.setVisibility(View.INVISIBLE);
                    itemCanClick = false;
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.HallWayConversation);
                    LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                    TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                    tMessage.setText("找到一張符咒");
                    relativeLayout.addView(layout);
                    ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            itemCanClick = true;
                            relativeLayout.removeAllViews();
                            goToFight();
                        }
                    });
                }
            }
        });
        amulet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    hasA3 = true;
                    amulet3.setVisibility(View.INVISIBLE);
                    itemCanClick = false;
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.HallWayConversation);
                    LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                    TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                    tMessage.setText("找到一張符咒");
                    relativeLayout.addView(layout);
                    ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            itemCanClick = true;
                            relativeLayout.removeAllViews();
                            goToFight();
                        }
                    });
                }
            }
        });

        amulet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    hasA1 = true;
                    amulet1.setVisibility(View.INVISIBLE);
                    itemCanClick = false;
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.HallWayConversation);
                    LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                    TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                    tMessage.setText("找到一個護身符");
                    relativeLayout.addView(layout);
                    ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            itemCanClick = true;
                            relativeLayout.removeAllViews();
                            goToFight();
                        }
                    });
                }
            }
        });

        ghostAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    hasRead = true;
                    showGhostAway.setVisibility(View.VISIBLE);
                    itemCanClick = false;
                    goToFight();
                }
            }
        });

        exitGhostAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCanClick = true;
                showGhostAway.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void goToFight(){
        if(hasRead && hasA1 && hasA2 && hasA3){
            Intent intent = new Intent(GrandmaRoom.this , FightPresident.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
            finish();
        }
    }
}