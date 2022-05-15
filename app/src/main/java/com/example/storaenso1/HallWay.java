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

public class HallWay extends AppCompatActivity {

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

    // 物件
    RelativeLayout room1 , room2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_way);

        init();
        clickBag();
        linstener();
    }

    public void init(){
        // bag
        bag = (ImageView) findViewById(R.id.InnerHouse1Bag);
        bagBack = (FrameLayout) findViewById(R.id.InnerHouse1BagBack);
        bagArrow = (ImageView) findViewById(R.id.InnerHouse1BagArrow);
        knife = (ImageView) findViewById(R.id.InnerHouse1Knife);
        holdItem = "";
        key = (ImageView) findViewById(R.id.InnerHouse1Key);
        hold = (ImageView) findViewById(R.id.InnerHouse1Hold);
        childLeg = (ImageView) findViewById(R.id.InnerHouseLeg);

        // obj
        room1 = (RelativeLayout) findViewById(R.id.HallWayRoom1);
        room2 = (RelativeLayout) findViewById(R.id.HallWayRoom2);

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
                    Toast.makeText(HallWay.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "knife";
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    knife.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(HallWay.this , "持有" ,Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(HallWay.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "key";
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(HallWay.this , "持有" ,Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(HallWay.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "chairLeg";
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(HallWay.this , "持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(R.drawable.broken_chair2);
                }
                return true;
            }
        });

    }

    public void linstener(){
        room1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    itemCanClick = false;
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.HallWayConversation);
                    LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                    TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                    tMessage.setText("門鎖住了...");
                    relativeLayout.addView(layout);
                    ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            itemCanClick = true;
                            relativeLayout.removeAllViews();
                        }
                    });
                }
            }
        });

        room2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    Intent intent = new Intent(HallWay.this , PresidentRoom.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                    finish();
                }
            }
        });
    }
}