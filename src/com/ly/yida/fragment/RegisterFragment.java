package com.ly.yida.fragment;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.ly.yida.BaseActivity;
import com.ly.yida.R;
import com.ly.yida.utils.Constants;
import com.ly.yida.utils.CustomToast;
import com.ly.yida.utils.VerifyUtil;
import com.ly.yida.view.ClearEditText;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RegisterFragment extends BaseFragment {

	@ViewInject(R.id.cet_phone)
	private ClearEditText cet_phone;
	@ViewInject(R.id.et_verifycode)
	private ClearEditText et_verify;
	@ViewInject(R.id.btn_verify)
	private Button btn_verify;
	@ViewInject(R.id.btnNext)
	private Button btnNext;
	@ViewInject(R.id.tv_tip)
	private TextView tvTip;
	@ViewInject(R.id.tv_deal)
	private TextView tvDeal;
	@ViewInject(R.id.titleBar)
	private RelativeLayout titleBar;
	@ViewInject(R.id.ib_back)
	private ImageButton ib_back;
	@ViewInject(R.id.tv_title)
	private TextView tv_title;
	@ViewInject(R.id.btn_right)
	private Button btnRight;
	@ViewInject(R.id.ll_protocol)
	private LinearLayout llLayout;
	
	@Override
	protected View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.frag_register, null);
		return view;
	}

	@Override
	protected void initData(Bundle savedInstanceState) {
		hideTitle();
		ib_back.setVisibility(View.VISIBLE);
		tv_title.setVisibility(View.VISIBLE);
		String tag = getTag();
		if(tag.equals("tag"+Constants.REGISTER1)){
			tv_title.setText("×¢²á");
			llLayout.setVisibility(View.VISIBLE);
		}else{
			tv_title.setText("ÕÒ»ØÃÜÂë");
		}
		
	}

	@Override
	protected void registerEvent() {
		btn_verify.setOnClickListener(this);
		btnNext.setOnClickListener(this);
		tvDeal.setOnClickListener(this);
		ib_back.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view) {
		super.onClick(view);
		BaseActivity activity = (BaseActivity) getActivity();
		String phoneNum = cet_phone.getText().toString().trim();
		switch (view.getId()) {
		case R.id.btn_verify:
			
			if(!VerifyUtil.isCellphone(phoneNum)){
				new CustomToast(activity,R.string.rightphone_str, 1000).show();
				return;
			}
			break;
		case R.id.btnNext:
			RegisterNextFragment nextFragment = new RegisterNextFragment();
			int nextType = Constants.REGISTER2;
			if(getTag().equals("tag"+Constants.FORGETPD1)){
				nextType = Constants.FORGETPD2;
			}
			activity.switchFragment(nextFragment,nextType);
			break;
		case R.id.tv_deal:
	
			break;
		case R.id.ib_back:
			if(activity.getSupportFragmentManager().getBackStackEntryCount() > 0){  
                activity.getSupportFragmentManager().popBackStack();  
            } 
			break;
		default:
			break;
		}
	}
	
	private void hideTitle(){
		ib_back.setVisibility(View.GONE);
		tv_title.setVisibility(View.GONE);
		btnRight.setVisibility(View.GONE);
		llLayout.setVisibility(View.GONE);
	}

}
