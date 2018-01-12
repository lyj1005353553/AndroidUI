package com.ohterview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ohterview.R;
import com.ohterview.model.AmimateCheckBoxModel;
import com.ohterview.view.AnimateCheckBox;
import com.ohterview.view.CheckBoxSample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBoxSample checkBoxSample1;
    private CheckBoxSample checkBoxSample2;
    private CheckBoxSample checkBoxSample3;
    private CheckBoxSample checkBoxSample4;
    TextView tv_yk;


    private List<AmimateCheckBoxModel> dataList = new ArrayList<>();

    private Set<AmimateCheckBoxModel> checkedSet = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_checkbox);
        checkBoxSample1 = (CheckBoxSample) findViewById(R.id.check1);
        checkBoxSample2 = (CheckBoxSample) findViewById(R.id.check2);
        checkBoxSample3 = (CheckBoxSample) findViewById(R.id.check3);
        checkBoxSample4 = (CheckBoxSample) findViewById(R.id.check4);
        checkBoxSample1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBoxSample1.toggle();
            }
        });
        checkBoxSample2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBoxSample2.toggle();
            }
        });
        checkBoxSample3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBoxSample3.toggle();
            }
        });
        checkBoxSample4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBoxSample4.toggle();
            }
        });

        bindDatas();
        bindViews();
    }


    private void bindDatas() {
        for (int i = 0; i < 10; i++) {
            AmimateCheckBoxModel demo = new AmimateCheckBoxModel();
            demo.setContent("this is a simple item : " + i);
            dataList.add(demo);
        }

    }

    private void bindViews() {
        ListView listView = (ListView) findViewById(R.id.listView);
        tv_yk = findViewById(R.id.tv_yk);
        tv_yk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckBoxActivity.this,CombinationCBoxActivity.class));
            }
        });
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return dataList.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.animator_checkbox_item, parent, false);
                }

                TextView text = (TextView) convertView.findViewById(R.id.text);
                final AnimateCheckBox checkBox = (AnimateCheckBox) convertView.findViewById(R.id.checkbox);
                RelativeLayout rl_checkitem = convertView.findViewById(R.id.rl_checkitem);

                final AmimateCheckBoxModel item = dataList.get(position);

                rl_checkitem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (checkedSet.contains(item)) {
                            checkBox.setChecked(true);
                        } else {
                            //checkBox.setChecked(false); //has animation
                            checkBox.setUncheckStatus();
                        }
                    }
                });


                text.setText(item.getContent());
                if (checkedSet.contains(item)) {
                    checkBox.setChecked(true);
                } else {
                    //checkBox.setChecked(false); //has animation
                    checkBox.setUncheckStatus();
                }
                checkBox.setOnCheckedChangeListener(new AnimateCheckBox.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(View buttonView, boolean isChecked) {
                        if (isChecked) {
                            checkedSet.add(item);
                        } else {
                            checkedSet.remove(item);
                        }
                    }
                });

                return convertView;
            }
        });
    }
}
