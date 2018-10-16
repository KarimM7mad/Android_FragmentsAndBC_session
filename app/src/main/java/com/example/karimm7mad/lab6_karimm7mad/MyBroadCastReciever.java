package com.example.karimm7mad.lab6_karimm7mad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadCastReciever extends BroadcastReceiver {

    private MainActivity main;

    public void setMain(MainActivity main) {
        this.main = main;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        this.main.toggleFragment();
        Toast.makeText(context,"Fragment Toggled",Toast.LENGTH_SHORT).show();
    }
}
