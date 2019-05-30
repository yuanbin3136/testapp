package com.wind.yuanbin.testapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.wind.yuanbin.testapp.utils.L;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TO DO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        L.o(intent.getAction());
    }
}
