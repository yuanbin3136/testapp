package com.wind.yuanbin.testapp.mvp;

abstract public class BasePresenter<V> {
    protected V view;
    public BasePresenter(V view){
        this.view = view;
    }
    abstract public void onDestroy();
}
