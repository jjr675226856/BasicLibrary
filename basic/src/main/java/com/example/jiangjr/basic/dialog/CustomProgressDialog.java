package com.example.jiangjr.basic.dialog;


import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiangjr.basic.R;


public class CustomProgressDialog extends Dialog {

	private AnimationDrawable animationDrawable;

	public CustomProgressDialog(Context context, String strMessage) {
		this(context, R.style.CustomProgressDialog, strMessage);
	}

	public CustomProgressDialog(Context context, int theme, String strMessage) {
		super(context, theme);
		this.setContentView(R.layout.layout_custom_progressdialog);
		this.getWindow().getAttributes().gravity = Gravity.CENTER;
		TextView tvMsg = (TextView) this.findViewById(R.id.tv_loadingmsg);
		ImageView imageView = (ImageView) this.findViewById(R.id.loadingImageView);
		animationDrawable = (AnimationDrawable) imageView.getBackground();
		animationDrawable.start();
		if (tvMsg != null) {
			tvMsg.setText(strMessage);
		}
	}

}