package caimao.com.marqueenview;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/1/8.
 */

public class SimpleMF<E extends CharSequence> extends MarqueeFactory<TextView, E> {
    public SimpleMF(Context mContext) {
        super(mContext);
    }

    @Override
    public TextView generateMarqueeItemView(E data) {
        TextView mView = new TextView(mContext);
        mView.setText(data);
        return mView;
    }
}
