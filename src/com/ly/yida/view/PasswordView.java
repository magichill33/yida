package com.ly.yida.view;

import com.ly.yida.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.view.View.OnClickListener;

public class PasswordView extends RelativeLayout implements OnClickListener{
	private ClearEditText cet_password;
	private ImageView iv_show;
	private String hintInfo;
	private int srcId;
	
	public PasswordView(Context context) {
		super(context);
		initView(context);
	}
	
	public PasswordView(Context context,AttributeSet set){
		super(context, set);
		TypedArray ta = context.obtainStyledAttributes(set, R.styleable.PasswordView);
		int count = ta.getIndexCount();
		hintInfo = ta.getString(R.styleable.PasswordView_ivHint);
		srcId = ta.getResourceId(R.styleable.PasswordView_imageSrc, -1);
		if(srcId == -1){
			throw new RuntimeException("«Î…Ë÷√±≥æ∞Õº∆¨");
		}
		ta.recycle();
		initView(context);
	}

	private void initView(Context context){
		View.inflate(context, R.layout.view_password, this);
		cet_password = (ClearEditText) findViewById(R.id.et_password);
		iv_show = (ImageView) findViewById(R.id.iv_show);
		cet_password.setHint(hintInfo);
		iv_show.setImageResource(srcId);
		iv_show.setOnClickListener(this);
	}
	
	public String getPassword()
	{
		return cet_password.getText().toString();
	}

	private boolean isShow = true;
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.iv_show){
			if(isShow){
            //»Áπ˚—°÷–£¨œ‘ æ√‹¬Î      
				cet_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
				//iv_show.setBackgroundResource(R.drawable.hide_eye);
				iv_show.setImageResource(R.drawable.hide_eye);
				
			}else{
            //∑Ò‘Ú“˛≤ÿ√‹¬Î
				cet_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
				//iv_show.setBackgroundResource(R.drawable.show_eye);
				iv_show.setImageResource(R.drawable.show_eye);
			}
			cet_password.setSelection(getPassword().length());
			isShow = !isShow;
		}
	}
	
}
