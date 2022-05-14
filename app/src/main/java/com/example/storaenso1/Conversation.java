package com.example.storaenso1;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class Conversation extends LinearLayout {
    public Conversation(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.conversation , this);
    }
}
