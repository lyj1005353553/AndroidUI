package com.ohterview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ohterview.R;
import com.ohterview.view.RoundIndicatorView;

public class CreditActivity extends AppCompatActivity {
    private RoundIndicatorView roundIndicatorView;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_credit);
        roundIndicatorView = (RoundIndicatorView) findViewById(R.id.my_view);
        editText = (EditText) findViewById(R.id.edit);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.valueOf(editText.getText().toString());
                if(a>500){
                    return;
                }
                roundIndicatorView.setCurrentNumAnim(a);
            }
        });
    }
}
