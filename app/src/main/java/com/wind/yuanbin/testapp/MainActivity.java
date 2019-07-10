package com.wind.yuanbin.testapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wind.yuanbin.testapp.receiver.ReceiverActivity;
import com.wind.yuanbin.testapp.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
//                ToastUtils.a(" xxx " + i);
//                ToastUtils.b("i " + i);
                toOtherAct();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ToastUtils.bb();
                ToastUtils utils = new ToastUtils();
                utils.init();
                utils.show();
            }
        });
        a(list.get(0));
    }

    private void toOtherAct() {
        Intent intent = new Intent();
        intent.setAction("com.wind.action");
        startActivity(intent);
    }

    int i;

    static List<A> list = new ArrayList<>();
    static {
        list.add(new A("广播",ReceiverActivity.class));
    }
    static class A{
        String name;
        Class activityClass;
        public A(String name, Class activityClass){
            this.name = name;
            this.activityClass = activityClass;
        }
    }
    private void a(A a){
        Intent intent = new Intent(this, a.activityClass);
        startActivity(intent);
    }
}
