package com.sweetalertdialog;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sweetalertdialog.alert.SweetAlertDialog;


/**
 * Created by Administrator on 2018/1/5.
 */

public class SweetAlertActivity extends AppCompatActivity {
    private Button showNormal;
    private Button showError;
    private Button showWarning;
    private Button showSuccess;
    private Button showCustomImage;
    private Button showProgress;
    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.showNormal) {
                showSweetAlertDialog(0);
            } else if (id == R.id.showError) {
                showSweetAlertDialog(1);
            } else if (id == R.id.showWarning) {
                showSweetAlertDialog(2);
            } else if (id == R.id.showSuccess) {
                showSweetAlertDialog(3);
            } else if (id == R.id.showCustomImage) {
                showSweetAlertDialog(4);
            } else if (id == R.id.showProgress) {
                showSweetAlertDialog(5);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sweet_alert_dialog_activity_main);
        this.showProgress = (Button) findViewById(R.id.showProgress);
        this.showCustomImage = (Button) findViewById(R.id.showCustomImage);
        this.showSuccess = (Button) findViewById(R.id.showSuccess);
        this.showWarning = (Button) findViewById(R.id.showWarning);
        this.showError = (Button) findViewById(R.id.showError);
        this.showNormal = (Button) findViewById(R.id.showNormal);
        this.showProgress.setOnClickListener(onClickListener);
        this.showCustomImage.setOnClickListener(onClickListener);
        this.showSuccess.setOnClickListener(onClickListener);
        this.showWarning.setOnClickListener(onClickListener);
        this.showError.setOnClickListener(onClickListener);
        this.showNormal.setOnClickListener(onClickListener);
    }

    public void showSweetAlertDialog(int type) {
        if (type == 0) {
            new SweetAlertDialog(SweetAlertActivity.this)
                    .setTitleText("对话框标题")
                    .setContentText("对话框内容")
                    .setConfirmText("确定")
                    .show();
        } else if (type == 1) {
            new SweetAlertDialog(SweetAlertActivity.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("对话框标题")
                    .setContentText("对话框内容")
                    .setConfirmText("确定")
                    .show();
        } else if (type == 2) {
            new SweetAlertDialog(SweetAlertActivity.this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("对话框标题")
                    .setContentText("对话框内容")
                    .setConfirmText("确定")
                    .show();
        } else if (type == 3) {
            new SweetAlertDialog(SweetAlertActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("对话框标题")
                    .setContentText("对话框内容")
                    .setConfirmText("确定")
                    .show();
        } else if (type == 4) {
            new SweetAlertDialog(SweetAlertActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                    .setTitleText("对话框标题")
                    .setContentText("对话框内容")
                    .setConfirmText("确定")
                    .setCustomImage(R.drawable.image)
                    .show();
        } else if (type == 5) {
            final SweetAlertDialog pDialog = new SweetAlertDialog(SweetAlertActivity.this, SweetAlertDialog.PROGRESS_TYPE);
            pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog.setTitleText("对话框标题")
                    .setContentText("对话框内容");
            pDialog.setCancelable(false);
            pDialog.show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        pDialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }

    }
}

