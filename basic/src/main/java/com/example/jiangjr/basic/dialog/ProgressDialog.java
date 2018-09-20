package com.example.jiangjr.basic.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jiangjr.basic.R;


/**
 * Created by Jiangjr on 2015/12/1.
 */
public class ProgressDialog extends AlertDialog {
    private String msg;

    public ProgressDialog(Context context) {
        this(context, R.style.Dialogs_Light);
    }

    public ProgressDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public ProgressDialog(Context context, String msg) {
        this(context, R.style.Dialogs_Light);
        this.msg = msg;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
        TextView loadingMsg = (TextView) findViewById(R.id.loading_msg);
        loadingMsg.setText(msg);
        //setCancelable(false);
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
