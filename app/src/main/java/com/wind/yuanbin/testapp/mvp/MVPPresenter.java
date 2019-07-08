package com.wind.yuanbin.testapp.mvp;

public class MVPPresenter extends BasePresenter<Contract.UIView> implements Contract.IPersenter_Home {
    public MVPPresenter(Contract.UIView view) {
        super(view);
    }

    @Override
    public void onDestroy() {
        // TODO clearData
    }

    @Override
    public void getToday() {

    }

    @Override
    public void show(String msg) {
        view.show(msg);
    }

    @Override
    public void showErr(String msg) {
        view.showErr(msg);
    }
}
