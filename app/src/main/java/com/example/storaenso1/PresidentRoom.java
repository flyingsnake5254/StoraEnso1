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

public class PresidentRoom extends AppCompatActivity {

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
//        螺絲起子
    RelativeLayout screwdriver;
    boolean hasScrewDriver;

//    海報
    RelativeLayout post;
    LinearLayout showPost;
    ImageView exitZoomPost;

//    總統
    RelativeLayout president;
    boolean hasWin;

//    總統對話
    int count = 0;
    String[] say1 = {
            "咦…那是總統嗎？他怎麼會在阿嬤開壇的房間？",
            "(鬼魂)\n" + "經濟才是社會進步的基礎，沒有我砍這麼多的森林，國家不會有這一番成就！",
            "…他看起來好像不會妨礙我們，先找鑰匙吧。"
    };
    String[] say2 = {
            "(鬼魂)\n" + "你是不是不認同我的理念！你也是那些激進的環保主義者嗎？",
            "他怎麼突然變暴躁了？難道是不能撕海報嗎？",
            "這樣不行，我得想想辦法…記得阿嬤有告訴過我鎮壓怨靈的方法",
            "來看看房間裡有沒有東西可以派上用場。"
    };

//    背景
    FrameLayout bg;

    ImageView goToGrandma;

    /*

咦…那是總統嗎？他怎麼會在阿嬤開壇的房間？」
總統？：「經濟才是社會進步的基礎，沒有我砍這麼多的森林，國家不會有這一番成就！」
「…他看起來好像不會妨礙我們，先找鑰匙吧。」
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president_room);

        init();
        clickBag();
        listener();
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
        screwDriver = (ImageView) findViewById(R.id.ScrewDriver);


        // obj
        screwdriver = (RelativeLayout) findViewById(R.id.screwdriver);
        post = (RelativeLayout) findViewById(R.id.post);
        showPost = (LinearLayout) findViewById(R.id.showPost);
        exitZoomPost = (ImageView) findViewById(R.id.PresidentRightArrow);
        president = (RelativeLayout) findViewById(R.id.president);
        bg = (FrameLayout) findViewById(R.id.PresidentRoomBg);
        goToGrandma = (ImageView) findViewById(R.id.goToAma);
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
                    Toast.makeText(PresidentRoom.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "knife";
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    knife.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(PresidentRoom.this , "持有" ,Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(PresidentRoom.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "key";
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(PresidentRoom.this , "持有" ,Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(PresidentRoom.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "chairLeg";
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(PresidentRoom.this , "持有" ,Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(PresidentRoom.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "screwDriver";
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    screwDriver.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(PresidentRoom.this , "持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(R.drawable.screwdriver);
                }
                return true;
            }
        });

    }

    public void listener(){
        screwdriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    if(!hasScrewDriver){
                        hasScrewDriver = true;
                        screwDriver.setVisibility(View.VISIBLE);
                        screwdriver.setBackgroundResource(0);
                        itemCanClick = false;
                        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.HallWayConversation);
                        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                        TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                        tMessage.setText("找到一把螺絲起子");
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
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    if(holdItem.equals("screwDriver")){
                        if(hasWin){
                            // 獲得鑰匙
                        }
                        else{
                            bg.setBackgroundResource(R.drawable.president2);
                            itemCanClick = false;
                            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.HallWayConversation);
                            LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                            TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                            count = say2.length;
                            tMessage.setText(say2[say2.length - (count --)]);
                            relativeLayout.addView(layout);
                            ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
                            button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if(count == 0){
                                        itemCanClick = true;
                                        relativeLayout.removeAllViews();
                                        goToGrandma.setVisibility(View.VISIBLE);
                                        bg.setBackgroundResource(R.drawable.president1);
                                    }
                                    else{
                                        tMessage.setText(say2[say2.length - (count --)]);
                                    }
                                }
                            });
                        }
                    }
                    else{
                        itemCanClick = false;
                        showPost.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        exitZoomPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPost.setVisibility(View.INVISIBLE);
                itemCanClick = true;
            }
        });

        president.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    if(holdItem.equals("amulet1")){

                    }
                    else{
                        itemCanClick = false;
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
                                    itemCanClick = true;
                                    relativeLayout.removeAllViews();
                                }
                                else{
                                    tMessage.setText(say1[say1.length - (count --)]);
                                }
                            }
                        });
                    }
                }
            }
        });

        goToGrandma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PresidentRoom.this , GrandmaRoom.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                finish();
            }
        });


    }
}