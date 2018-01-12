package com.loadingview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.loadingview.R;
import com.loadingview.dialog.SpotsDialog;
import com.loadingview.view.overwatchprogress.HiveProgressView;

/**
 * Created by Maxim Dybarsky | maxim.dybarskyy@gmail.com
 * on 13.01.15 at 14:32
 */
public class DialogLoadingActivity extends AppCompatActivity implements View.OnClickListener {

    HiveProgressView progressView;
    TextView tv_bd_loading, tv_hungry_loading;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_loading_main);

        findViewById(android.R.id.button1).setOnClickListener(this);
        findViewById(android.R.id.button2).setOnClickListener(this);
        findViewById(android.R.id.button3).setOnClickListener(this);
        findViewById(android.R.id.closeButton).setOnClickListener(this);
        tv_bd_loading = findViewById(R.id.tv_bd_loading);
        tv_hungry_loading = findViewById(R.id.tv_hungry_loading);
        progressView = (HiveProgressView) findViewById(R.id.tv_over_progress);
        progressView.setOnClickListener(this);
        tv_bd_loading.setOnClickListener(this);
        tv_hungry_loading.setOnClickListener(this);

    }

    ///错误: 需要常量表达式: 解决方案：将 switch中的case 改成 if 判断就可以了；注意：一般都会有提示的直接Alt+Enter就可以了；
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == android.R.id.button1) {
            new SpotsDialog.Builder()
                    .setContext(this)
                    .build()
                    .show();

        } else if (i == android.R.id.button2) {
            new SpotsDialog.Builder()
                    .setContext(this)
                    .setTheme(R.style.Custom)
                    .build()
                    .show();

        } else if (i == android.R.id.button3) {
            new SpotsDialog.Builder()
                    .setContext(this)
                    .setMessage("Custom message")
                    .build()
                    .show();

        } else if (i == android.R.id.closeButton) {
            new SpotsDialog.Builder()
                    .setContext(this)
                    .setTheme(R.style.Custom)
//                        .setMessage("标题内容")
                    .build()
                    .show();

        } else if (i == R.id.tv_over_progress) {
            progressView.setRainbow(false);
            progressView.setColor(0x000000);

        } else if (i == R.id.tv_bd_loading) {
            startActivity(new Intent(DialogLoadingActivity.this, BaiduLoadingActivity.class));
        } else if (i == R.id.tv_hungry_loading) {
            startActivity(new Intent(DialogLoadingActivity.this, HungRyActivity.class));
        }
    }
}
