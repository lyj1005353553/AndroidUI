package com.cm.androidui;

import android.animation.TimeInterpolator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018/1/11.
 */

public class TestActivity extends AppCompatActivity {

    Canvas canvas=new Canvas();
    Paint paint=new Paint();

    ImageView iv_red;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_self);
        iv_red=(ImageView) findViewById(R.id.iv_red);
        Animation operatingAnim = AnimationUtils.loadAnimation(this, R.anim.hb_anim);
        LinearInterpolator lin=new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        iv_red.startAnimation(operatingAnim);
        TimeInterpolator interpolator;


        Resources resources = getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();



//        ComposeShader  s;//混合两个Shader
//        canvas.saveLayer(null,null,Canvas.ALL_SAVE_FLAG);
//        paint.setColor(Color.BLUE);
//        paint.setStyle(Paint.Style.STROKE);//画线
//        paint.setStrokeWidth(10);
//        paint.setDither(true);
//        canvas.drawCircle(150,125,100,paint);

    }
}
