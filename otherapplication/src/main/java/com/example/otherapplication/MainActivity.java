package com.example.otherapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        send(this,"testString");

        findViewById(R.id.tv_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.wind.action");
                intent.addCategory("android.intent.category.wind.action");
                startActivity(intent);
            }
        });

    }

    public static final String ACTION = "wind.action";
    public static void send(Context context, String msg){
        Intent intent = new Intent();
        intent.putExtra("string",msg);
        intent.setAction(ACTION);
//        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        context.sendBroadcast(intent);
    }
}
