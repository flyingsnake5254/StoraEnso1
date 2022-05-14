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

public class InnerHouse1 extends AppCompatActivity {

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

    // 場景物件
        // 椅子
    RelativeLayout chair;
    boolean hasRepair = false;
    boolean hasLeg = false;

        // 報紙
    RelativeLayout news;
    boolean hasFoundLeg = false;
    ImageView exitNewsPaper;
    LinearLayout zoomNews;

        // IKEA Boss
    RelativeLayout ikeaBoss;
    String[] bossSay = {
            "(鬼魂)\n" + "為每個人做優質的木製傢俱，是IKAA的使命！",
            "(鬼魂)\n" + "木頭…拼裝…IKAA…傢俱…",
            "他擋住上去的樓梯了…我得想辦法讓他離開。",
    };
    int count = bossSay.length;

    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_house1);

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

        //場景物件
        chair = (RelativeLayout) findViewById(R.id.InnerHouseChair);
        news = (RelativeLayout) findViewById(R.id.InnerHouse1News);
        exitNewsPaper = (ImageView) findViewById(R.id.InnerHouse1ExitNews);
        zoomNews = (LinearLayout) findViewById(R.id.InnerHouse1ZoomNews);
        frameLayout = (FrameLayout) findViewById(R.id.InnerHouse1Framelayout);
        ikeaBoss = (RelativeLayout) findViewById(R.id.InnerHouse1IkeaBoss);
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
                    Toast.makeText(InnerHouse1.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "knife";
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    knife.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(InnerHouse1.this , "持有" ,Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(InnerHouse1.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "key";
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(InnerHouse1.this , "持有" ,Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(InnerHouse1.this , "取消持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(0);
                }
                else{
                    holdItem = "chairLeg";
                    knife.setBackgroundColor(Color.parseColor("#00000000"));
                    key.setBackgroundColor(Color.parseColor("#00000000"));
                    childLeg.setBackgroundColor(Color.parseColor("#DDDDDD"));
                    Toast.makeText(InnerHouse1.this , "持有" ,Toast.LENGTH_SHORT).show();
                    hold.setImageResource(R.drawable.broken_chair2);
                }
                return true;
            }
        });

    }


    // 場景物件監聽
    public void listener(){
        chair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    if(!hasRepair){
                        if(!hasLeg){
                            itemCanClick = false;
                            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.InnerHouse1Conversation);
                            LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                            TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                            tMessage.setText("一張壞掉的椅子");
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
                        else if(holdItem.equals("chairLeg")){
                            Intent intent = new Intent(InnerHouse1.this , InnerHouse2.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                            finish();

                        }
                    }
                }
            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    if(!hasFoundLeg){
                        hasFoundLeg = true;
                        itemCanClick = false;
                        hasLeg = true;
                        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.InnerHouse1Conversation);
                        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                        TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                        tMessage.setText("翻開報紙，發現被壓在底下的椅子零件");
                        relativeLayout.addView(layout);
                        ImageButton button = (ImageButton) layout.findViewById(R.id.bTap);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                childLeg.setVisibility(View.VISIBLE);
                                relativeLayout.removeAllViews();
                                zoomNews.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                    else{
                        itemCanClick = false;
                        zoomNews.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        exitNewsPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCanClick = true;
                zoomNews.setVisibility(View.INVISIBLE);
            }
        });

        ikeaBoss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCanClick){
                    count = bossSay.length;
                    itemCanClick = false;
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.InnerHouse1Conversation);
                    LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                    TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                    tMessage.setText(bossSay[bossSay.length - (count--)]);
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
                                tMessage.setText(bossSay[bossSay.length - (count--)]);
                            }
                        }
                    });
                }
            }
        });
    }
}