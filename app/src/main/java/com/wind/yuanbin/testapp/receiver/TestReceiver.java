package com.wind.yuanbin.testapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.wind.yuanbin.testapp.utils.L;

public class TestReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TO DO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");

        String action = intent.getAction();
        String s = intent.getStringExtra("string");

        L.o(action + " xx " + s);
        if (action.equals(Intent.ACTION_PACKAGE_ADDED)){
            String packageName = intent.getData().getSchemeSpecificPart();
            L.o("packageName" + packageName);

        }
    }
}
