package com.toasts.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.toasts.R;
import com.toasts.view.TastyToast;

/**
 * Created by Administrator on 2018/1/8.
 */

public class ToastActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.toast_main);
    }

    public void showSuccessToast(View view) {
        TastyToast.makeText(getApplicationContext(), "Download Successful !", TastyToast.LENGTH_LONG,
                TastyToast.SUCCESS);
    }

    public void showWarningToast(View view) {
        TastyToast.makeText(getApplicationContext(), "Are you sure ?", TastyToast.LENGTH_LONG,
                TastyToast.WARNING);
    }

    public void showErrorToast(View view) {
        TastyToast.makeText(getApplicationContext(), "Downloading failed ! Try again later ", TastyToast.LENGTH_LONG,
                TastyToast.ERROR);
    }
    public void showInfoToast(View view) {
        TastyToast.makeText(getApplicationContext(), "Searching for username : 'Rahul' ", TastyToast.LENGTH_LONG,
                TastyToast.INFO);
    }

    public void showDefaultToast(View view) {
        TastyToast.makeText(getApplicationContext(), "This is Default Toast", TastyToast.LENGTH_LONG,
                TastyToast.DEFAULT);
    }


    public void showConfusingToast(View view) {
        TastyToast.makeText(getApplicationContext(), "I don't Know !", TastyToast.LENGTH_LONG,
                TastyToast.CONFUSING);
    }
}
