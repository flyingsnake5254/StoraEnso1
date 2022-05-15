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

public class WinPresident extends AppCompatActivity {

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

    // obj
    RelativeLayout post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_president);

        init();
        clickBag();
        listener();
    }

    public void init(){
        // obj
        post = (RelativeLayout) findViewById(R.id.winRoomPost);

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
                    Toast.makeText(WinPresident.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "knife";
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    knife.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(WinPresident.this , "持有" ,Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(WinPresident.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "key";
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(WinPresident.this , "持有" ,Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(WinPresident.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "chairLeg";
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(WinPresident.this , "持有" ,Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(WinPresident.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "screwDriver";
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(WinPresident.this , "持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(R.drawable.screwdriver);
                }
                return true;
            }
        });

    }

    int count = 1;
    public void listener(){
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    if(holdItem.equals("screwDriver")){
                        itemCanClick = false;
                        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.HallWayConversation);
                        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                        TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                        tMessage.setText("找到一把鑰匙!");

                        relativeLayout.addView(layout);
                        ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(count == 0){
                                    itemCanClick = true;
                                    relativeLayout.removeAllViews();
                                    Intent intent = new Intent(WinPresident.this , OpenLockDoor.class);
                                    startActivity(intent);
                                    overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                                    finish();

                                }
                                else{
                                    tMessage.setText("去剛剛那間被鎖住的房間吧!");
                                    count --;
                                }


                            }
                        });
                    }
                }
            }
        });
    }
}