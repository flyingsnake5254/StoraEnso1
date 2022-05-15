package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FightPresident extends AppCompatActivity {

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
    ImageView a1 , a2 , a3;

    // obj
    RelativeLayout president;
    String order = "";
    RelativeLayout b1 , b2 , b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_president);

        init();
        clickBag();
        listener();
        //132
    }

    public void init(){
        // obj
        president = (RelativeLayout) findViewById(R.id.FightPresident);
        b1 = (RelativeLayout) findViewById(R.id.blood1);
        b2 = (RelativeLayout) findViewById(R.id.blood2);
        b3 = (RelativeLayout) findViewById(R.id.blood3);

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
        a1 = (ImageView) findViewById(R.id.amulet1);
        a2 = (ImageView) findViewById(R.id.amulet2);
        a3 = (ImageView) findViewById(R.id.amulet3);
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
                    Toast.makeText(FightPresident.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "knife";
                    a1.setBackgroundColor(Color.parseColor("#00000000"));
                    a2.setBackgroundColor(Color.parseColor("#00000000"));
                    a3.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    knife.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(FightPresident.this , "持有" ,Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(FightPresident.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "key";
                    a1.setBackgroundColor(Color.parseColor("#00000000"));
                    a2.setBackgroundColor(Color.parseColor("#00000000"));
                    a3.setBackgroundColor(Color.parseColor("#00000000"));
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(FightPresident.this , "持有" ,Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(FightPresident.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "chairLeg";
                    a1.setBackgroundColor(Color.parseColor("#00000000"));
                    a2.setBackgroundColor(Color.parseColor("#00000000"));
                    a3.setBackgroundColor(Color.parseColor("#00000000"));
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(FightPresident.this , "持有" ,Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(FightPresident.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "screwDriver";
                    a1.setBackgroundColor(Color.parseColor("#00000000"));
                    a2.setBackgroundColor(Color.parseColor("#00000000"));
                    a3.setBackgroundColor(Color.parseColor("#00000000"));
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(FightPresident.this , "持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(R.drawable.screwdriver);
                }
                return true;
            }
        });

        a1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(holdItem.equals("a1")){
                    holdItem = "";
                    a1.setBackgroundColor(Color.parseColor("#00000000"));
                    Toast.makeText(FightPresident.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "a1";

                    a2.setBackgroundColor(Color.parseColor("#00000000"));
                    a3.setBackgroundColor(Color.parseColor("#00000000"));
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    a1.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(FightPresident.this , "持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(R.drawable.amulet1);
                }
                return true;
            }
        });

        a2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(holdItem.equals("a2")){
                    holdItem = "";
                    a2.setBackgroundColor(Color.parseColor("#00000000"));
                    Toast.makeText(FightPresident.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "a2";
                    a1.setBackgroundColor(Color.parseColor("#00000000"));
                    a3.setBackgroundColor(Color.parseColor("#00000000"));
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    a2.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(FightPresident.this , "持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(R.drawable.amulet2);
                }
                return true;
            }
        });

        a3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(holdItem.equals("a3")){
                    holdItem = "";
                    a3.setBackgroundColor(Color.parseColor("#00000000"));
                    Toast.makeText(FightPresident.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "a3";
                    a1.setBackgroundColor(Color.parseColor("#00000000"));
                    a2.setBackgroundColor(Color.parseColor("#00000000"));

                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    a3.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(FightPresident.this , "持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(R.drawable.amulet3);
                }
                return true;
            }
        });

    }

    public void listener(){
        president.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    if(holdItem.equals("a1")){
                        order = "1";
                        b1.setVisibility(View.INVISIBLE);
                        b2.setVisibility(View.VISIBLE);
                        b3.setVisibility(View.VISIBLE);
                    }
                    else if(holdItem.equals("a2")){
                        order += "2";
                        if(order.equals("132")){
                            b1.setVisibility(View.INVISIBLE);
                            b2.setVisibility(View.INVISIBLE);
                            b3.setVisibility(View.INVISIBLE);
                            Intent intent = new Intent(FightPresident.this , WinPresident.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                            finish();
                        }
                        else{
                            b1.setVisibility(View.VISIBLE);
                            b2.setVisibility(View.VISIBLE);
                            b3.setVisibility(View.VISIBLE);
                        }
                    }
                    else if(holdItem.equals("a3")){
                        order += "3";
                        if(order.equals("13")){
                            b2.setVisibility(View.INVISIBLE);
                        }
                        else{
                            b1.setVisibility(View.VISIBLE);
                            b2.setVisibility(View.VISIBLE);
                            b3.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });
    }
}