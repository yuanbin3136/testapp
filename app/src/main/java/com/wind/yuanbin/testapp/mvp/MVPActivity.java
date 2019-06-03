package com.wind.yuanbin.testapp.mvp;

public class MVPActivity extends BaseActivity<MVPPresenter> implements Contract.UIView{
    @Override
    public int initLayoutResId() {
        return 0;
    }

    @Override
    public MVPPresenter initPresenter() {
        return new MVPPresenter(this);
    }

    @Override
    public void getToday() {

    }

    @Override
    public void show(String msg) {

    }

    @Override
    public void showErr(String msg) {

    }
}
