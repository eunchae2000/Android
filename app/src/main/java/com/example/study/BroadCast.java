package com.example.study;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadCast extends BroadcastReceiver {

    public final static String MyAction = "Hello, World. broadcastreceiverexam.ACTION_MY_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())){
            Toast.makeText(context, "전원연결", Toast.LENGTH_SHORT).show();
        }else if(MyAction.equals(intent.getAction())){
            Toast.makeText(context, "방송", Toast.LENGTH_SHORT).show();
        }

    }
}
