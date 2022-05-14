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

public class FirstChapter extends AppCompatActivity {

    ImageView oldPhoto , imgNews;
    boolean isConversation = false;
    boolean hasReadPhoto , hasWatchTV;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_chapter);

        init();
    }

    public void init(){
        oldPhoto = (ImageView) findViewById(R.id.imgOldPhoto);
        oldPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isConversation){
                    isConversation = true;
                    hasReadPhoto = true;
                    LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                    LinearLayout relativeLayout = (LinearLayout) findViewById(R.id.conversationRelative);
                    TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                    tMessage.setText("一張老舊的照片，我不想看...");
                    relativeLayout.addView(layout);
                    ImageButton bTap = (ImageButton) layout.findViewById(R.id.bTap);
                    bTap.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(hasReadPhoto && hasWatchTV){
                                relativeLayout.removeAllViews();
                                tMessage.setText("時間很晚，我該去睡了.");
                                relativeLayout.addView(layout);
                                ImageButton b = (ImageButton) layout.findViewById(R.id.bTap);
                                b.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        relativeLayout.removeAllViews();
                                        Intent intent = new Intent(FirstChapter.this , DreamGrandma.class);
                                        startActivity(intent);
                                        overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                                        finish();
                                    }
                                });
                            }
                            else{
                                relativeLayout.removeAllViews();
                                isConversation = false;
                            }
                        }
                    });
                    System.out.println("photo");
                }
            }
        });

        imgNews = (ImageView) findViewById(R.id.imgNews);
        imgNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isConversation){
                    isConversation = true;

                    LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.conversation , null);
                    LinearLayout relativeLayout = (LinearLayout) findViewById(R.id.conversationRelative);
                    TextView tMessage = (TextView) layout.findViewById(R.id.tConversation);
                    String[] messages = {
                        "主播：\n" + "長滿繽紛果實的青翠大樹，",
                            "主播：\n" + "卻是眾人眼中奪命的象徵。",
                            "主播：\n" + "近幾個月內，",
                            "主播：\n" + "已有數名政要因不明原因在這棵樹上吊自殺，",
                            "主播：\n" + "導致各國經濟崩盤、局勢動盪，",
                            "主播：\n" + "無數人因此無家可歸…",
                            "主播：\n" + "今日，又有一條無辜的生命面臨相同的命運。",
                            "主播：\n" + "知名木材製造商之子OOO於今日下午…",
                    };

                    relativeLayout.addView(layout);
                    ImageButton bTap = (ImageButton) layout.findViewById(R.id.bTap);
                    count = 0;
                    tMessage.setText(messages[count++]);
                    bTap.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(count > 7){
                                hasWatchTV = true;
                                if(hasReadPhoto && hasWatchTV){
                                    relativeLayout.removeAllViews();
                                    tMessage.setText("時間很晚，我該去睡了.");
                                    relativeLayout.addView(layout);
                                    ImageButton b = (ImageButton) layout.findViewById(R.id.bTap);
                                    b.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            relativeLayout.removeAllViews();
                                            Intent intent = new Intent(FirstChapter.this , DreamGrandma.class);
                                            startActivity(intent);
                                            overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                                            finish();
                                        }
                                    });
                                }
                                else{
                                    relativeLayout.removeAllViews();
                                    isConversation = false;
                                }
                            }
                            else{
                                if(count == 7){

                                }
                                tMessage.setText(messages[count++]);

                            }
                        }
                    });
                    System.out.println("news");
                }
            }
        });
    }
}