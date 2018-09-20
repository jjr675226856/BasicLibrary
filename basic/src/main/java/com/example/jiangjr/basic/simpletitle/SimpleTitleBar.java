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
public class SimpleTitleBar extends FrameLayout{
    private TextView mLeftText;
    private TextView mTitleText;
    private TextView mRightText;
    public SimpleTitleBar(Context context) {
        this(context,null,0);
    }

    public SimpleTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SimpleTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.title_bar,this);
        mLeftText = (TextView) findViewById(R.id.tv_left);
        mTitleText = (TextView) findViewById(R.id.tv_title);
        mRightText = (TextView) findViewById(R.id.tv_right);

        /**
         * 绑定attrs.style
         */
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.title_bar,defStyleAttr,0);
        String leftText = a.getString(R.styleable.title_bar_simple_left_title);
        String title = a.getString(R.styleable.title_bar_simple_title);
        String rightText = a.getString(R.styleable.title_bar_simple_right_title);

        setLeftText(leftText);
        setTitleText(title);
        setRightText(rightText);

        a.recycle();  //获得绑定

        mLeftText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
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

    public void setRightDrawable(int image){
        mRightText.setBackgroundResource(image);
    }

    public TextView getmLeftText() {
        return mLeftText;
    }

    public TextView getmRightText() {
        return mRightText;
    }

}