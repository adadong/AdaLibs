package com.ada.adalibs.controls;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.TextView.OnEditorActionListener;

import com.ada.adalibs.R;


/**
 * Created by Ada on 2016/10/8.
 */
public class PwdAutoCompleteTextView extends RelativeLayout implements
        OnFocusChangeListener, TextWatcher {
    /**
     * 删除按钮的引用
     */
//    private Drawable mClearDrawable;
    private Drawable leftDrawable;
    private Drawable mRightDrawable=null;
    /**
     * 控件是否有焦点
     */
    private boolean hasFoucs;

    private Context context;
    private AutoCompleteTextView tv;

    public PwdAutoCompleteTextView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    /**
     * 设置光标位置
     */
    public void setSelection(int index) {
        tv.setSelection(index);
    }

    /**
     * 设置输入框提示文本
     *
     * @param
     */
    public void setDefaultHint(String hint) {
        System.out.println("hint====================="+hint);
        tv.setHint(hint);
    }

    public PwdAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initViews();
    }

    /**
     * 设置背景图片
     */
    public void setbackgroundImg() {
//		tv.setBackgroundResource(R.drawable.login_text_bg);
    }

    /**
     * 设置背景图片
     *
     * @param
     */
    public void setbackgroundImg(int drawable) {
        tv.setBackgroundResource(drawable);
    }

    /**
     * 设置左边图标
     *
     * @param drawable
     *            图片
     * @param padding
     *            图片与文本的距离
     */
    public void setLeftDrawable(int drawable, int padding) {
        System.out.println("dskjjdsksdkj======="+drawable);
        leftDrawable = getResources().getDrawable(drawable);
//        leftDrawable.setBounds(0, 0, leftDrawable.getIntrinsicWidth()-20,
//                leftDrawable.getIntrinsicHeight()-20);
        leftDrawable.setBounds(0, 0, 48, 48);
        tv.setCompoundDrawables(leftDrawable, null, mRightDrawable, null);
        tv.setCompoundDrawablePadding(padding);
    }


    /**
     * 设置右侧图标
     *
     * @param drawable
     *            图片
     */
    public void setRightDrawable(int drawable) {
        mRightDrawable = getResources().getDrawable(drawable);
//        mRightDrawable.setBounds(0, 0, mRightDrawable.getIntrinsicWidth()-20,
//                mRightDrawable.getIntrinsicHeight()-20);
        mRightDrawable.setBounds(0, 0, 32, 32);
        // tv.setCompoundDrawablePadding(padding);
    }


    /**
     * 设置内边距
     *
     * @param
     * @param
     * @param
     * @param
     */

    public void setPaddings(int left, int top, int right, int bottom) {
        tv.setPadding(left, top, right, bottom);
    }

    /**
     * 设置提示文本的颜色
     *
     * @param
     */
    public void setHintTextColor(int color) {
        tv.setHintTextColor(color);
    }

    /**
     * 设置输入框文字的颜色
     *
     * @param
     */
    public void setTextColor(int color) {
        tv.setTextColor(color);
    }

    /**
     * 设置输入框文字的大小
     *
     * @param
     */
    public void setTextSize(float size) {
        tv.setTextSize(size);
    }

    /**
     * 设置输入键盘
     */
    public void setInputType(int type) {
        tv.setInputType(type);
    }

    /**
     * 设置宽高
     */
    public void setLayoutParams(LayoutParams params) {
        tv.setLayoutParams(params);
    }

    private void initViews() {
        LayoutParams params = new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 0);
        tv = new AutoCompleteTextView(context);
        tv.setLayoutParams(params);
        // tv.setHint("请键入...");

        // 默认设置隐藏图标
//        setClearIconVisible(true);
        // 设置焦点改变的监听
        tv.setOnFocusChangeListener(this);
        tv.setTextColor(0xFF000000); // 设置文字为不透明

        // tv.setTextAppearance(context, R.style.myautocompletetextview);
        tv.setOnTouchListener(imageButtonTouchListener);
        // 设置输入框里面内容发生改变的监听
        tv.addTextChangedListener(this);
        this.addView(tv);
        // this.addView(iv);
    }

//    public void setAdapter(AutoCompleteAdapter adapter) {
//        tv.setAdapter(adapter);
//    }

    /**
     * 设置用户至少输入多少个字符才会显示提示
     *
     * @param
     */
    public void setThreshold(int threshold) {
        tv.setThreshold(threshold);
    }

    /**
     * 设置下拉列表距离左边的距离
     */
    public void setDropDownHorizontalOffset(int offset) {
        tv.setDropDownHorizontalOffset(offset);
    }

    /**
     * 设置下拉菜单的高度
     *
     * @param
     */
    public void setDropDownHeight(int height) {
        tv.setDropDownHeight(height);
    }

    /**
     * 设置下拉菜单的宽度
     *
     * @param
     */
    public void setDropDownWidth(int width) {
        tv.setDropDownWidth(width);
    }

    /**
     * 设置出现在下拉菜单中的提示标题
     *
     * @param
     */
    public void setCompletionHint(String completionHint) {
        tv.setCompletionHint(completionHint);
    }

    public void setFocusable(Boolean b) {
        tv.setFocusable(b);
    }

    public String getText() {
        return tv.getText().toString();
    }

    public void setText(String text) {
        tv.setText(text);
    }

    public AutoCompleteTextView getAutoCompleteTextView() {
        return tv;
    }

    /**
     * 因为我们不能直接给EditText设置点击事件，所以我们用记住我们按下的位置来模拟点击事件 当我们按下的位置 在 EditText的宽度 -
     * 图标到控件右边的间距 - 图标的宽度 和 EditText的宽度 - 图标到控件右边的间距之间我们就算点击了图标，竖直方向就没有考虑
     */
    private OnTouchListener imageButtonTouchListener = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (tv.getCompoundDrawables()[2] != null) {

                    boolean touchable = event.getX() > (getWidth() - tv
                            .getTotalPaddingRight())
                            && (event.getX() < ((getWidth() - getPaddingRight())));
                    if (touchable) {
                        if(tv.getInputType()==InputType.TYPE_CLASS_TEXT){
                            tv.setInputType(InputType.TYPE_CLASS_TEXT
                                    | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        }else {
                            tv.setInputType(InputType.TYPE_CLASS_TEXT);
                        }
                    }
                }
            }
            return false;
        }
    };

    /**
     * 当EditText焦点发生变化的时候，判断里面字符串长度设置清除图标的显示与隐藏
     */
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        /*this.hasFoucs = hasFocus;
        if (hasFocus) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }*/
    }

    /**
     * 设置清除图标的显示与隐藏，调用setCompoundDrawables为EditText绘制上去
     *
     * @param visible
     */
    public void setClearIconVisible(boolean visible) {
       /* if(visible){
            // 获取EditText的DrawableRight,假如没有设置我们就使用默认的图片
            mRightDrawable = tv.getCompoundDrawables()[2];
            if (mRightDrawable == null) {
                mRightDrawable = getResources().getDrawable(
                        R.mipmap.ic_hide_pwd);
            }

            mRightDrawable.setBounds(0, 0, 32,
                    32);
        }*/
        Drawable right = visible ? mRightDrawable : null;
        tv.setCompoundDrawables(tv.getCompoundDrawables()[0],
                tv.getCompoundDrawables()[1], right,
                tv.getCompoundDrawables()[3]);
    }

    /**
     * 当输入框里面内容发生变化的时候回调的方法
     */
    @Override
    public void onTextChanged(CharSequence s, int start, int count, int after) {
        /**
         * Ada delete
         */
        /*if (hasFoucs) {
            setClearIconVisible(s.length() > 0);
        }*/
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    /**
     * 设置晃动动画
     */
    public void setShakeAnimation() {
        this.setAnimation(shakeAnimation(5));
    }

    /**
     * 晃动动画
     *
     * @param counts
     *            1秒钟晃动多少下
     * @return
     */
    public static Animation shakeAnimation(int counts) {
        Animation translateAnimation = new TranslateAnimation(0, 10, 0, 0);
        translateAnimation.setInterpolator(new CycleInterpolator(counts));
        translateAnimation.setDuration(1000);
        return translateAnimation;
    }

    /**
     * @param onEditorActionListener
     */
    public void setOnEditorActionListener(
            OnEditorActionListener onEditorActionListener) {
        tv.setOnEditorActionListener(onEditorActionListener);
    }

    /**
     * @param imeActionSend
     */
    public void setImeOptions(int imeActionSend) {
        tv.setImeOptions(imeActionSend);
    }

    public void setSingleLine(Boolean isSingleLine) {
        tv.setSingleLine(isSingleLine);
    }

    /**
     * @param textWatcher
     */
    public void addTextChangedListener(TextWatcher textWatcher) {
        tv.addTextChangedListener(textWatcher);
    }


}
