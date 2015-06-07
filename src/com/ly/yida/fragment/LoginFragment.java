package com.ly.yida.fragment;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.ly.yida.MainActivity;
import com.ly.yida.R;
import com.ly.yida.utils.Constants;
import com.ly.yida.utils.CustomToast;
import com.ly.yida.utils.VerifyUtil;
import com.ly.yida.view.ClearEditText;
import com.ly.yida.view.PasswordView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginFragment extends BaseFragment {

	@ViewInject(R.id.pv_password)
	private PasswordView passwordView;
	@ViewInject(R.id.et_account)
	private ClearEditText cetCount;
	@ViewInject(R.id.btn_login)
	private Button btnLogin;
	@ViewInject(R.id.tv_signup)
	private TextView tvSignUp;
	@ViewInject(R.id.tv_password)
	private TextView tvForgetPW;
	
	@Override
	protected View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.frag_login, null);
		return view;
	}

	@Override
	protected void initData(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()) {
		case R.id.btn_login:
			String phoneNum = cetCount.getText().toString().trim();
			if(!VerifyUtil.isCellphone(phoneNum)){
				new CustomToast(activity, R.string.rightphone_str, 1000).show();
				return;
			}
			activity.switchActivity(MainActivity.class);
			break;
		case R.id.tv_signup:
			RegisterFragment registerFragment = new RegisterFragment();
			activity.switchFragment(registerFragment, Constants.REGISTER1);
			break;
		case R.id.tv_password:
			RegisterFragment forgetFragment = new RegisterFragment();
			activity.switchFragment(forgetFragment, Constants.FORGETPD1);
			break;
		default:
			break;
		}
	}

	@Override
	protected void registerEvent() {
		btnLogin.setOnClickListener(this);
		tvSignUp.setOnClickListener(this);
		tvForgetPW.setOnClickListener(this);
	}

}
