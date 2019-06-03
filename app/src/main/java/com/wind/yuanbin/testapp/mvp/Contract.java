package com.wind.yuanbin.testapp.mvp;

public class Contract {
    public final static String BaseUrl = "https://news-at.zhihu.com/api/4/news/";
    public final static String URL_daily = "latest";
    public final static String URL_daily_content = "9669715";//3892357

    public interface IPersenter_Home {
        void getToday();
        void show(String msg);
//        void showList(DailyModel model);
        void showErr(String msg);
    }
    public interface UIView{
        void getToday();
        void show(String msg);
//        void showList(DailyModel model);
        void showErr(String msg);
    }
}
