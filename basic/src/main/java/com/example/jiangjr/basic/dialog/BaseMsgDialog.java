package com.example.jiangjr.basic.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jiangjr.basic.R;
import com.example.jiangjr.basic.utils.CommonUtils;


/**
 * Created by Jiangjr on 2015/12/1.
 */
public class BaseMsgDialog extends AlertDialog {
    private BaseMsgOnclickListener listener;
    private Context mContext;
    private Button positiveButton, negativeButton;
    private boolean flag;
    private String title = "";
    private String msg ="";
    private int msgColor = 0;
    private String cancel="";
    private String enter="";

    public void setListener(BaseMsgOnclickListener listener){
        this.listener = listener;
    }

    public BaseMsgDialog(Context context) {
        this(context, R.style.Dialogs_Light);
        this.mContext = context;
    }

    public BaseMsgDialog(Context context, String title, String msg, String cancel, String enter) {
        this(context, R.style.Dialogs_Light);
        this.mContext = context;
        this.title = title;
        this.msg = msg;
        this.cancel = cancel;
        this.enter = enter;
    }

    public BaseMsgDialog(Context context, String title, String msg, int msgColor, String cancel, String enter) {
        this(context, R.style.Dialogs_Light);
        this.mContext = context;
        this.mContext = context;
        this.title = title;
        this.msg = msg;
        this.cancel = cancel;
        this.enter = enter;
        this.msgColor = msgColor;
    }

    public BaseMsgDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_base_dialog);
        TextView tvTitle = (TextView) findViewById(R.id.tv_dialog_title);
        tvTitle.setText(title);
        TextView tvMsg = (TextView) findViewById(R.id.tv_dialog_msg);
        tvMsg.setText(msg);
        if (msgColor!=0){
            tvMsg.setTextColor(mContext.getResources().getColor(msgColor));
            tvMsg.setTextSize(22.0f);
        }
        positiveButton = (Button) findViewById(R.id.btn_pos);
        if (!CommonUtils.isEmpty(enter)){
            positiveButton.setText(enter);
        }
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                listener.setOnPositiveListener();
            }
        });

        negativeButton = (Button) findViewById(R.id.btn_nag);
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                listener.setOnNegativeListener();
            }
        });
        if (!CommonUtils.isEmpty(cancel)){
            negativeButton.setText(cancel);
        }
        setCancelable(false);
    }

    /**
     * 确定键监听器
     * @param
     */

    public interface BaseMsgOnclickListener{
        void setOnPositiveListener();
        void setOnNegativeListener();
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.dismiss();
    }

}
