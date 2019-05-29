package com.example.otherapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        send(this,"testString");
    }

    public static final String ACTION = "wind.action";
    public static void send(Context context, String msg){
        Intent intent = new Intent();
        intent.putExtra("string",msg);
        intent.setAction(ACTION);
        context.sendBroadcast(intent);
    }
}
