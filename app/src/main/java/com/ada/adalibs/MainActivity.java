package com.ada.adalibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Intent mIntemt;
    private Button btnTxtStyle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTxtStyle=(Button) findViewById(R.id.btn_txt_styles);
        btnTxtStyle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_txt_styles:
                mIntemt =new Intent();
                mIntemt.setClass(MainActivity.this,CustomTextShapeActivity.class);
                startActivity(mIntemt);
                break;
        }
    }
}
