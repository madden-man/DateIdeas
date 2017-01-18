package com.example.tommy.dateideas.activities;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tommy.dateideas.R;

public class LoadingActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        textView = (TextView) findViewById(R.id.tv_loading);

        for (int i = 0; i < 3; ++i) {
            timer();
        }

        finish();

    }

    public void timer() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                textView.setText(textView.getText().toString() + ".");
            }
        }, 150);
    }
}
