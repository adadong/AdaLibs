package com.ada.adalibs.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.RelativeLayout;

import com.ada.adalibs.R;
import com.ada.adalibs.controls.MyAutoCompleteTextView;
import com.ada.adalibs.controls.PwdAutoCompleteTextView;

/**
 * Ada 添加带图片的输入框
 */
public class LoginActivity extends AppCompatActivity {
    /**
     * 用户名输入框
     */
    private MyAutoCompleteTextView userName;
    /**
     * 密码输入框
     */
    private PwdAutoCompleteTextView password;
    public static int screenHight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    public void initView(){
        screenHight = ((WindowManager) this
                .getSystemService(this.WINDOW_SERVICE)).getDefaultDisplay()
                .getHeight();
        userName = (MyAutoCompleteTextView) findViewById(R.id.username);
        password = (PwdAutoCompleteTextView) findViewById(R.id.password);
        setAutoTextStyle(userName,
                "账号",
                InputType.TYPE_CLASS_TEXT, EditorInfo.IME_ACTION_NEXT,
                R.mipmap.ic_account);
        setAutoTextStylePwd(password,
                "密码",
                InputType.TYPE_CLASS_TEXT
                        | InputType.TYPE_TEXT_VARIATION_PASSWORD,
                EditorInfo.IME_ACTION_GO, R.mipmap.ic_pwd);
    }

    public static void setAutoTextStyle(MyAutoCompleteTextView textView,
                                        String hint, int inputType, int imeOptions, int leftDrawable) {
        //定义宽高
        RelativeLayout.LayoutParams layoutParam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                screenHight / 12);
//        设置宽高
        textView.setLayoutParams(layoutParam);
        textView.setText("");
        textView.setClearIconVisible(false);
        textView.setPaddings(22, 0, 12, 0);
        textView.setDefaultHint(hint);
//        修改这里可以设置自定义输入框的背景
        textView.setbackgroundImg(R.drawable.border_gray_t1_b);
        textView.setLeftDrawable(leftDrawable, 10);
        textView.setRightDrawable(R.drawable.input_clear);
        textView.setHintTextColor(0xffbec3c6);
        textView.setTextColor(0xff5a6378);
        textView.setTextSize(18);
        if (inputType != -1) {
            textView.setInputType(inputType);
        }
        textView.setImeOptions(imeOptions);
    }

    public static void setAutoTextStylePwd(PwdAutoCompleteTextView textView,
                                           String hint, int inputType, int imeOptions, int leftDrawable) {
        RelativeLayout.LayoutParams layoutParam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                screenHight / 12);
        textView.setLayoutParams(layoutParam);
        textView.setText("");
//        textView.setClearIconVisible(true);
        textView.setPaddings(22, 0, 12, 0);
        textView.setDefaultHint(hint);
//        textView.setbackgroundImg(R.drawable.border_gray_t1_b);
        textView.setRightDrawable(R.mipmap.ic_hide_pwd);
        textView.setLeftDrawable(leftDrawable, 10);
        textView.setHintTextColor(0xffbec3c6);
        textView.setTextColor(0xff5a6378);
        textView.setTextSize(18);
        if (inputType != -1) {
            textView.setInputType(inputType);
        }
        textView.setImeOptions(imeOptions);
    }
}
