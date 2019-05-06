package com.wind.yuanbin.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wind.yuanbin.testapp.utils.ToastUtils;

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
                ToastUtils.b("i " + i);
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
    }
    int i;

}
