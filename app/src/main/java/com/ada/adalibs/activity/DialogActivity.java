package com.ada.adalibs.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ada.adalibs.R;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnDialog1;
    private Button btnDialog2;
    private Button btnDialog3;
    private Button btnDialog4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        initView();
    }

    private void initView(){
        btnDialog1=(Button)findViewById(R.id.btn_dialog_1);
        btnDialog2=(Button)findViewById(R.id.btn_dialog_2);
        btnDialog3=(Button)findViewById(R.id.btn_dialog_3);
        btnDialog4=(Button)findViewById(R.id.btn_dialog_4);

        //添加OnCLick事件
        btnDialog1.setOnClickListener(this);
        btnDialog2.setOnClickListener(this);
        btnDialog3.setOnClickListener(this);
        btnDialog4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dialog_1:
                showAlertDialog();
                break;
            default:
                break;
        }
    }


    /**
     * Ada 使用与提示框，添加一个确定按钮
     */
    public void showAlertDialog( ){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("提示").setMessage("提示内容").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();
    }

    /**
     * Ada 使用与提示框，添加确定、取消按钮
     */
    public void showAlertDialogWithTwo( ){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("提示").setMessage("提示内容").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setNegativeButton("取消",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();

    }

    public void gradViewDialog(){

    }

}
