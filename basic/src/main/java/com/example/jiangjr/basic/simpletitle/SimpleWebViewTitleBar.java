package com.example.jiangjr.basic.simpletitle;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.jiangjr.basic.R;


/**
 * Created by jiangjr on 2015/1/13.
 */
//  带返回的标题栏
public class SimpleWebViewTitleBar extends FrameLayout{
    private TextView mLeftText;
    private TextView mTextOff;
    private TextView mTitleText;
    private TextView mRightText;
    public SimpleWebViewTitleBar(Context context) {
        this(context,null,0);
    }

    public SimpleWebViewTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SimpleWebViewTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.webview_title_bar, this);
        mLeftText = (TextView) findViewById(R.id.tv_left);
        mTextOff = (TextView) findViewById(R.id.tv_guangbi);
        mTitleText = (TextView) findViewById(R.id.tv_title);
        mRightText = (TextView) findViewById(R.id.tv_right);

        /**
         * 绑定attrs.style
         */
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.webview_title_bar,defStyleAttr,0);
        String leftText = a.getString(R.styleable.webview_title_bar_web_left_title);
        String title = a.getString(R.styleable.webview_title_bar_web_title);
        String rightText = a.getString(R.styleable.webview_title_bar_web_right_title);
        String offText = a.getString(R.styleable.webview_title_bar_web_left_off_title);

        setOffText(offText);
        setLeftText(leftText);
        setTitleText(title);
        setRightText(rightText);

        setOffVissable(true);

        a.recycle();  //获得绑定

        mTextOff.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }

    public void setOffVissable(boolean flag) {
        if (flag){
            mTextOff.setVisibility(GONE);
        }else {
            mTextOff.setVisibility(VISIBLE);
        }
    }


    public void setLeftOnClickListener(OnClickListener l){
        mLeftText.setOnClickListener(l);
    }

    public void setTitleOnClickListener(OnClickListener l)
    {
        mTitleText.setOnClickListener(l);
    }

    public void setRightOnClickListener(OnClickListener l)
    {
        mRightText.setOnClickListener(l);
    }

    public void setLeftText(String text) {
        mLeftText.setText(text);
    }

    public void setTitleText(String text) {
        mTitleText.setText(text);
    }

    public void setRightText(String text)
    {
        mRightText.setText(text);
    }

    public void setOffText(String offText) {
       mTextOff.setText(offText);
    }

    public void setRightDrawable(int image){
        mRightText.setBackgroundResource(image);
    }
}