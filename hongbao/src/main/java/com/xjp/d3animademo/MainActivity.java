package com.xjp.d3animademo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;


public class MainActivity extends Activity implements
        android.view.View.OnClickListener {

    private ImageView img1;
//    private ImageView img2;
    private ImageView img3, img4;
    private ViewGroup mContainer;
    private final static int ROTATE_X = 0;
    private final static int ROTATE_Y = 1;

    private My3dAnimation my3dAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }

    /**
     * TODO<请描述这个方法是干什么的>
     *
     * @param
     * @return void
     * @throw
     */
    private void findViews() {
        // TODO Auto-generated method stub
        mContainer = (ViewGroup) findViewById(R.id.container);
        mContainer
                .setPersistentDrawingCache(ViewGroup.PERSISTENT_ANIMATION_CACHE);

        img1 = (ImageView) findViewById(R.id.img_left);
//        img1.setOnClickListener(this);
//        img2 = (ImageView) findViewById(R.id.img_right);
//        img2.setOnClickListener(this);

        img3 = (ImageView) findViewById(R.id.img_3);
//        img3.setOnClickListener(this);
        img4 = (ImageView) findViewById(R.id.img_4);
        img4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        float centerX = v.getWidth() / 2.0f;
        float centerY = v.getHeight() / 2.0f;
        if (v.getId() == R.id.img_left) {
            my3dAnimation = new My3dAnimation(ROTATE_X, 0, 180, centerX,
                    centerY, 310f);

        }
//        if (v.getId() == R.id.img_right) {
//            // Y轴 向右旋转
//            my3dAnimation = new My3dAnimation(ROTATE_Y, 0, 360, centerX,
//                    centerY, 0f);
//        }
        if (v.getId() == R.id.img_4) {
        // Y轴 向左旋转
            my3dAnimation = new My3dAnimation(ROTATE_Y, 360, 0, centerX,
                    centerY, 0f);
        }

        if (v.getId() == R.id.img_3) {
            centerX = 0;
            my3dAnimation = new My3dAnimation(ROTATE_Y, 0, 20, centerX,
                    centerY, 310f);
        }
        my3dAnimation.setDuration(800);
        my3dAnimation.setInterpolator(new LinearInterpolator());
        my3dAnimation.setFillAfter(true);
        // 动画不停止
        my3dAnimation.setRepeatCount(Animation.RESTART);
        v.startAnimation(my3dAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                img1.clearAnimation();
//                img2.clearAnimation();
//                img4.clearAnimation();
                my3dAnimation.cancel();

            }
        },1000*3);

    }
}
