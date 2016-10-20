package com.ada.adalibs.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ada.adalibs.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent mIntemt;
    private Button btnTxtStyle;
    private Button btnDIalog;
    private Button btnRadioButton;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTxtStyle = (Button) findViewById(R.id.btn_txt_styles);
        btnTxtStyle.setOnClickListener(this);
        btnDIalog = (Button) findViewById(R.id.btn_dialog);
        btnDIalog.setOnClickListener(this);
        btnRadioButton = (Button) findViewById(R.id.btn_radio_button_shapes);
        btnRadioButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_txt_styles:
                mIntemt = new Intent();
                mIntemt.setClass(MainActivity.this, CustomTextShapeActivity.class);
                startActivity(mIntemt);
                break;
            case R.id.btn_dialog:
                mIntemt = new Intent();
                mIntemt.setClass(MainActivity.this, DialogActivity.class);
                startActivity(mIntemt);
                break;
            case R.id.btn_radio_button_shapes:
                mIntemt = new Intent();
                mIntemt.setClass(MainActivity.this, ShapeRadioButtonActivity.class);
                startActivity(mIntemt);
                break;

        }
    }
}
