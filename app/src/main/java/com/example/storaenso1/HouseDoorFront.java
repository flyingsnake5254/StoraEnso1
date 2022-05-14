package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HouseDoorFront extends AppCompatActivity {

    ImageView bag , bagArrow , hold , leftArrow , exitPassword;
    FrameLayout bagBack;
    boolean itemCanClick = true;
    ImageView table1;
    boolean mailBoxHasOpen = false;
    LinearLayout passwordPadel;
    // hold state
    String holdItem = "";
    RelativeLayout mailBox;
    Button confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_door_front);

        init();
        clickBag();

        mailBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    if(mailBoxHasOpen){
                        itemCanClick = false;
                        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.HouseDoorConversation);
                        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                        TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                        tMessage.setText("已經打開了");
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
                    else{
                        itemCanClick = false;
                        passwordPadel.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }
    ImageView key;
    public void init(){
        key = (ImageView) findViewById(R.id.HouseDoorKey);
        confirmPassword = (Button) findViewById(R.id.confirmPassword);
        passwordPadel = (LinearLayout) findViewById(R.id.passwordPadel);
        exitPassword = (ImageView) findViewById(R.id.exitPassword);
        mailBox = (RelativeLayout) findViewById(R.id.MailBox);
        bag = (ImageView) findViewById(R.id.HouseDoorBag);
        bagBack = (FrameLayout) findViewById(R.id.HouseDoorBagBack);
        bagArrow = (ImageView) findViewById(R.id.HouseDoorArrow);
        hold = (ImageView)findViewById(R.id.HouseDoorHold);
        leftArrow = (ImageView) findViewById(R.id.HouseDoorLeft);

        confirmPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText e1 , e2 , e3 ,e4;
                e1 = (EditText) findViewById(R.id.password1);
                e2 = (EditText) findViewById(R.id.password2);
                e3 = (EditText) findViewById(R.id.password3);
                e4 = (EditText) findViewById(R.id.password4);
                if(e1.getText().toString().equals("0")
                        && e2.getText().toString().equals("3")
                        && e3.getText().toString().equals("1")
                        && e4.getText().toString().equals("2")){
                    mailBoxHasOpen = true;
                    itemCanClick = false;
                    passwordPadel.setVisibility(View.INVISIBLE);
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.HouseDoorConversation);
                    LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                    TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                    tMessage.setText("信箱打開了!\n獲得一把鑰匙");
                    relativeLayout.addView(layout);
                    ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            key.setVisibility(View.VISIBLE);
                            itemCanClick = true;
                            relativeLayout.removeAllViews();
                        }
                    });
                }

            }
        });

        leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    Intent intent = new Intent(HouseDoorFront.this , OutdoorBeam.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                    finish();
                }
            }
        });

        exitPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordPadel.setVisibility(View.INVISIBLE);
                itemCanClick = true;
            }
        });
        // bag item
        table1 = (ImageView) findViewById(R.id.HouseDoorKnife);
        table1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(holdItem.equals("knife")){
                    holdItem = "";
                    table1.setBackgroundColor(Color.parseColor("#00000000"));
                    Toast.makeText(HouseDoorFront.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "knife";
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    table1.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(HouseDoorFront.this , "持有" ,Toast.LENGTH_SHORT).show();
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
                    table1.setBackgroundColor(Color.parseColor("#00000000"));
                    Toast.makeText(HouseDoorFront.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "key";
                    table1.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(HouseDoorFront.this , "持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(R.drawable.key);
                }
                return true;
            }
        });

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

    }

    public void tableListener(){

    }


}