package com.wind.yuanbin.testapp;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();
    }

    static Context mContext;
    public static Context getContext(){
        return mContext;
    }
}
