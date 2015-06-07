package com.ly.yida.utils;

import com.ly.yida.R;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToast extends Toast {

	private TextView textView;
	private String text;
	private View view;
	private int time;
	private Context context;
	
	public CustomToast(Context context,String text,int time) {
		super(context);
		this.context = context;
		this.text = text;
		this.time = time;
		init();
	}
	
	public CustomToast(Context context,int id,int time) {
		super(context);
		this.context = context;
		//this.text = text;
		this.time = time;
		init(id);
	}
	
	private void init() {
		view = View.inflate(context, R.layout.custom_toast, null);
		setView(view);
		textView = (TextView) view.findViewById(R.id.textView);
		textView.setText(text);
		//setGravity(Gravity.CENTER_HORIZONTAL, 0, 0); 
		setDuration(time); 
	}
	
	private void init(int id){
		view = View.inflate(context, R.layout.custom_toast, null);
		setView(view);
		textView = (TextView) view.findViewById(R.id.textView);
		textView.setText(id);
		//setGravity(Gravity.CENTER_HORIZONTAL, 0, 0); 
		setDuration(time); 
	}

}