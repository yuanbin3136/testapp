package com.wind.yuanbin.testapp.utils;

import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.wind.yuanbin.testapp.App;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ToastUtils {


    public static void a(String text){
        Toast.makeText(App.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    static Toast toast;
    public static void b(String text){
        if (toast == null){
            toast = Toast.makeText(App.getContext(),text,Toast.LENGTH_LONG);
        }
//        toast.setGravity(Gravity.CENTER,0,0);
        toast.setText(text);
//        toast.cancel();
        toast.show();
    }

    public static void bb(){
        if (toast != null){
            toast.show();
        }
    }
    /**
     * 反射过程中是否出现异常的标志
     */
    boolean hasReflectException = false;
    Handler mHandler;
    /* 以下为反射相关内容 */
    Toast mToast;
    Field mTN;
    Object mObj;
    Method showMethod, hideMethod;
    View view;
    public void init(){
        initTN();
    }
    /**
     * 通过反射获得mTN下的show和hide方法
     */
    private void initTN() {
//        mToast = new Toast(App.getContext());
        mToast = Toast.makeText(App.getContext(),"1111",Toast.LENGTH_LONG);
//        mToast.setText("llll");
        view = mToast.getView();
//        mToast.setView(mTopView);
        Class<Toast> clazz = Toast.class;
        try {
            mTN = clazz.getDeclaredField("mTN");
            mTN.setAccessible(true);
            mObj = mTN.get(mToast);
            showMethod = mObj.getClass().getDeclaredMethod("show", new Class<?>[0]);
            hideMethod = mObj.getClass().getDeclaredMethod("hide", new Class<?>[0]);
            hasReflectException = false;
        } catch (NoSuchFieldException e) {
            hasReflectException = true;
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            hasReflectException = true;
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            hasReflectException = true;
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            hasReflectException = true;
            e.printStackTrace();
        }
    }
    static int currentapiVersion = android.os.Build.VERSION.SDK_INT;

    public void show(){
        showToast();
    }
    /**
     * 通过反射获得的show方法显示指定View
     */
    private void showToast() {
        try {
            //高版本需要再次手动设置mNextView属性，2系列版本不需要
            if (currentapiVersion > 10) {
                Field mNextView = mObj.getClass().getDeclaredField("mNextView");
                mNextView.setAccessible(true);
                mNextView.set(mObj, view);
            }
            if (showMethod != null) {
                showMethod.invoke(mObj, new Object[0]);
            } else {
                mToast.setDuration(Toast.LENGTH_LONG);
                mToast.show();
            }

            hasReflectException = false;
        } catch (Exception e) {
            hasReflectException = true;
            e.printStackTrace();
        }
    }

    /**
     * 通过反射获得的hide方法隐藏指定View
     */
    public void hideToast() {
        try {
            if (mToast != null) {
                mToast.cancel();
            }
            hasReflectException = false;
        } catch (Exception e) {
            hasReflectException = true;
            e.printStackTrace();
        }
    }

    public void removeAll() {
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
    }
}
