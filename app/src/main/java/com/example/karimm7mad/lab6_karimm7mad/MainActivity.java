package com.example.karimm7mad.lab6_karimm7mad;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    MyBroadCastReciever br;
    FragmentA fa;
    FragmentB fb;
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft;
    IntentFilter iff;
    boolean b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=false;
        fa = new FragmentA();
        fb = new FragmentB();

        ft = fm.beginTransaction();
        ft.add(R.id.container, fa, "A");
        ft.commit();



        br = new MyBroadCastReciever();
        br.setMain(this);
        iff = new IntentFilter();
        iff.addAction(Intent.ACTION_TIME_TICK);


    }

    public void toggleFragment() {
        ft = fm.beginTransaction();
        if (this.b) {
            ft.replace(R.id.container, fa, "A");
        }
        else {
            ft.replace(R.id.container, fb, "B");
        }
        this.b = !this.b;
        ft.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(br, iff);
    }


    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(br);
    }
}
