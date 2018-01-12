package com.cm.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2018/1/5.
 */

public class ComUtils {
     public static void goAct(Context context, Class<?> cls, boolean finishSelf, Bundle bundle) {
        try {
            Intent it = new Intent();
            it.setClass(context, cls);
            if(bundle != null) {
                it.putExtras(bundle);
            }

            context.startActivity(it);
            if(finishSelf) {
                Activity activity = (Activity)context;
                activity.finish();
            }
        } catch (Exception var6) {
            ;
        }

    }
}
