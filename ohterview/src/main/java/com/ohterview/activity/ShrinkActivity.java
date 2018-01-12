package com.ohterview.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ohterview.R;
import com.ohterview.view.GratuityView;

public class ShrinkActivity extends AppCompatActivity {

    private GratuityView gview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_shrink);
        gview= (GratuityView) findViewById(R.id.gratuity_view);

        gview.setBaseText("标题","内容");
        gview.setChildText("x1",1);
        gview.setChildText("x10",2);
        gview.setChildText("Android",0);
        gview.setChildText("x100",3);
//        gview.setChildText("x1000",4);
        gview.setAnimDuration(300);
        gview.setAutoCollapse(true);
        gview.setChildCount(4);

        gview.setChildgroundColor(0xFFEE6E50,0);
        gview.setChildgroundColor(0xFFEEB422,1);
        gview.setChildgroundColor(0xFFEEEE00,2);
        gview.setChildgroundColor(0xFF7CCD7C,3);
//        gview.setChildgroundColor(0xFF1C86EE,4);

        gview.setOnItemClickListener(new GratuityView.OnItemClickListener() {
            @Override
            public void onItemClick(int index) {
                if(index==0){
                    gview.setChildText("哎哟",0);
                    gview.setChildTextColor(Color.parseColor("#FF69B4"),0);
                    gview.setChildTextSize(18,0);

                }
                Toast.makeText(ShrinkActivity.this,"我是第"+index+"个", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
