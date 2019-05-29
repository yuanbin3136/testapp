package com.wind.yuanbin.testapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wind.yuanbin.testapp.R;
import com.wind.yuanbin.testapp.utils.L;

public class ReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);


        tempReceiver = new TempReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TempReceiver.ACTION);
        this.registerReceiver(tempReceiver,intentFilter);

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TempReceiver.send(ReceiverActivity.this,"msg");
            }
        });

    }
    TempReceiver tempReceiver;
    @Override
    protected void onDestroy() {
        unregisterReceiver(tempReceiver);
        super.onDestroy();
    }

    static class TempReceiver extends BroadcastReceiver{
        public static final String ACTION = "wind.action";
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String s = intent.getStringExtra("string");

            L.o(action + " xx " + s);
        }
        public static void send(Context context,String msg){
            Intent intent = new Intent();
            intent.putExtra("string",msg);
            intent.setAction(ACTION);
            context.sendBroadcast(intent);
        }

    }
}
