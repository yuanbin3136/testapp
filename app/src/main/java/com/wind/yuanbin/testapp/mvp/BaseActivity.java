package com.wind.yuanbin.testapp.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

abstract public class BaseActivity<P extends BasePresenter> extends AppCompatActivity{
    protected P mPersenter;

    public abstract int initLayoutResId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPersenter != null){
            mPersenter.onDestroy();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutResId());
        mPersenter = initPresenter();
    }

    public abstract P initPresenter();
}
