package com.example.jiangjr.basic.utils;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/1/30.
 */
public class MyCountUtil<T extends View> extends CountDownTimer{

        private T text;

        /** 倒计时的时长
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         *  改变的时间
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */

        public MyCountUtil(long millisInFuture, long countDownInterval, T text) {
            super(millisInFuture, countDownInterval);
            this.text = text;
        }


        @Override
        public void onTick(long millisInFuture) {   /*开始时候调用*/
            if(text instanceof TextView)
            {
                ((TextView)text).setText(millisInFuture/1000+"秒后重新获取");
                ((TextView)text).setEnabled(false);
            }else if (text instanceof Button){
                ((Button) text).setText(millisInFuture/1000+"秒");
            }

        }

        @Override
        public void onFinish() {  /*完成时候调用*/
            if(text instanceof TextView)
            {
                ((TextView)text).setText("重新获取验证码");
                ((TextView)text).setEnabled(true);
            }
            else if (text instanceof Button){
                ((Button) text).setText("获取验证码");
            }
        }
}
