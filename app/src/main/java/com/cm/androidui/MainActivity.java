package com.cm.androidui;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cm.utils.ComUtils;
import com.loadingview.activity.DialogLoadingActivity;
import com.magicindicator.num2.activity.TwoIndicatorActivity;
import com.ohterview.activity.CheckBoxActivity;
import com.ohterview.activity.CreditActivity;
import com.ohterview.activity.PrainseActivity;
import com.ohterview.activity.ShrinkActivity;
import com.sweetalertdialog.SweetAlertActivity;
import com.toasts.activity.ToastActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import caimao.com.marqueenview.MarqueenActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // 虚拟机检测策略
        StrictMode.setVmPolicy(new StrictMode.VmPolicy
                .Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());
    }

    @OnClick(value = {R.id.tv_dialog, R.id.tv_toast, R.id.tv_marqueen, R.id.tv_supports, R.id.tv_about_shrink,
            R.id.tv_credit, R.id.tv_loading, R.id.tv_indicator, R.id.tv_checkbox,R.id.tv_selfview})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_dialog:
                ComUtils.goAct(MainActivity.this, SweetAlertActivity.class, false, null);
                break;
            case R.id.tv_toast:
                ComUtils.goAct(MainActivity.this, ToastActivity.class, false, null);
                break;
            case R.id.tv_marqueen:
                ComUtils.goAct(MainActivity.this, MarqueenActivity.class, false, null);
                break;
            case R.id.tv_supports:
                ComUtils.goAct(MainActivity.this, PrainseActivity.class, false, null);
                break;
            case R.id.tv_about_shrink:
                ComUtils.goAct(MainActivity.this, ShrinkActivity.class, false, null);
                break;
            case R.id.tv_credit:
                ComUtils.goAct(MainActivity.this, CreditActivity.class, false, null);
                break;
            case R.id.tv_loading:
                ComUtils.goAct(MainActivity.this, DialogLoadingActivity.class, false, null);
                break;
            case R.id.tv_indicator:
                ComUtils.goAct(MainActivity.this, TwoIndicatorActivity.class, false, null);
                break;
            case R.id.tv_checkbox:
                ComUtils.goAct(MainActivity.this, CheckBoxActivity.class, false, null);
                break;

            case R.id.tv_selfview:
                ComUtils.goAct(MainActivity.this, TestActivity.class, false, null);
                break;

        }
    }
}
