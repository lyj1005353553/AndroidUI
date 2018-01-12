package com.ohterview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ohterview.R;
import com.ohterview.adapter.CombinationCAAdapter;
import com.ohterview.model.AmimateCheckBoxModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/9.
 */

public class CombinationCBoxActivity extends AppCompatActivity {
    //组合
    RelativeLayout ll_zh_layout;
    TextView tv_content, tv_close, tv_open, tv_minus;

    //长按
    LinearLayout ll_ca_layout;
    RadioGroup rg_single1, rg_single2;
    RecyclerView rcyle;
    CombinationCAAdapter adapter;

    RadioButton rbox_zh, rbox_ca, rbox_close, rbox_open;
    EditText et_input_name;
    TextView tv_sure;//确定

    //组合：数据
    List<String> strs = new ArrayList<>();

    //长按：内的关锁，开锁和选中秒数
    String rbtnText = "", seconds = "";
    List<AmimateCheckBoxModel> items = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_combination);
        findViews();
        setCheckListeners();

    }

    void findViews() {
        et_input_name = findViewById(R.id.et_input_name);
        rg_single1 = findViewById(R.id.rg_single1);
        rbox_zh = findViewById(R.id.rbox_zh);
        rbox_ca = findViewById(R.id.rbox_ca);

        rg_single2 = findViewById(R.id.rg_single2);
        rbox_close = findViewById(R.id.rbox_close);
        rbox_open = findViewById(R.id.rbox_open);

        //组合
        ll_zh_layout = findViewById(R.id.ll_zh_layout);
        tv_content = findViewById(R.id.tv_content);
        tv_close = findViewById(R.id.tv_close);
        tv_open = findViewById(R.id.tv_open);
        tv_minus = findViewById(R.id.tv_minus);
        tv_sure = findViewById(R.id.tv_sure);
        //长按
        ll_ca_layout = findViewById(R.id.ll_ca_layout);
        rcyle = findViewById(R.id.rcyle);
        if (adapter == null) {
            adapter = new CombinationCAAdapter(null);
        }
        adapter.setLists(getCaItems());
        //默认显示关锁选中1秒
        seconds = items.get(0).getContent();
        rcyle.setAdapter(adapter);

    }

    void setCheckListeners() {
        rg_single1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbox_zh) {
                    rbox_zh.setChecked(true);
                    ll_zh_layout.setVisibility(View.VISIBLE);
                    ll_ca_layout.setVisibility(View.GONE);
                } else if (checkedId == R.id.rbox_ca) {
                    rbox_ca.setChecked(true);
                    ll_zh_layout.setVisibility(View.GONE);
                    ll_ca_layout.setVisibility(View.VISIBLE);
                }
            }
        });

        rg_single2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbox_close) {
                    rbox_close.setChecked(true);
                } else if (checkedId == R.id.rbox_open) {
                    rbox_open.setChecked(true);
                }
            }
        });

        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strs.size() > 7) {
                    Snackbar.make(v, "最多只能八个", Snackbar.LENGTH_LONG)
                            .show();
                    return;
                }
                if (tv_content.getText().length() > 0) {
                    strs.add("-关");
                } else {
                    strs.add("关");
                }
                tv_content.setText(fromStrListToString(strs));
            }
        });
        tv_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strs.size() > 7) {
                    Snackbar.make(v, "最多只能添加八个", Snackbar.LENGTH_LONG)
                            .show();
                    return;
                }
                if (tv_content.getText().length() > 0) {
                    strs.add("-开");
                } else {
                    strs.add("开");
                }
                tv_content.setText(fromStrListToString(strs));
            }
        });
        tv_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strs.size() > 0) {
                    strs.remove(strs.size() - 1);
                    tv_content.setText(fromStrListToString(strs));
                } else {
                    Snackbar.make(v, "" + "已经删完数据啦，赶快添加吧~", Snackbar.LENGTH_LONG)
                            .show();
                }
            }
        });

        adapter.setOnItemClickListener(new CombinationCAAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                for (AmimateCheckBoxModel mode : items) {//全部设为未选中
                    mode.setChecked(false);
                }
                items.get(position).setChecked(true);//点击的设为选中
                seconds = items.get(position).getContent();
                adapter.notifyDataSetChanged();
            }
        });

        tv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rbox_ca.isChecked()) {
                    if (rbox_close.isChecked()) {
                        rbtnText = rbox_close.getText() + "选中";
                    } else {
                        rbtnText = rbox_open.getText() + "选中";
                    }
                    Snackbar.make(v, "" + rbtnText + seconds, Snackbar.LENGTH_LONG)
                            .show();
                } else {
                    if (TextUtils.isEmpty(tv_content.getText())) {
                        Snackbar.make(v, "" + "已经没有数据可看啦，赶快添加吧~", Snackbar.LENGTH_LONG)
                                .show();
                    } else {
                        Snackbar.make(v, "" + tv_content.getText(), Snackbar.LENGTH_LONG)
                                .show();
                    }
                }
            }
        });
    }


    String fromStrListToString(List<String> strs) {
        if (strs != null) {
            return strs.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "");
        }
        return null;
    }

    List<AmimateCheckBoxModel> getCaItems() {
        items.clear();
        for (int i = 1; i <= 10; i++) {
            if (i == 1) {
                items.add(new AmimateCheckBoxModel(i + "秒", true));
                continue;
            }
            items.add(new AmimateCheckBoxModel(i + "秒", false));
        }
        return items;
    }
}
