package com.ly.yida.fragment;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.ly.yida.BaseActivity;
import com.ly.yida.MainActivity;
import com.ly.yida.R;
import com.ly.yida.utils.Constants;
import com.ly.yida.utils.CustomToast;
import com.ly.yida.utils.VerifyUtil;
import com.ly.yida.view.PasswordView;

import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RegisterNextFragment extends BaseFragment{

	@ViewInject(R.id.pv_password1)
	private PasswordView pvPassword1;
	@ViewInject(R.id.pv_password2)
	private PasswordView pvPassword2;
	@ViewInject(R.id.btnSubmit)
	private Button btnSubmit;
	
	@ViewInject(R.id.titleBar)
	private RelativeLayout titleBar;
	@ViewInject(R.id.ib_back)
	private ImageButton ib_back;
	@ViewInject(R.id.tv_title)
	private TextView tv_title;
	@ViewInject(R.id.btn_right)
	private Button btnRight;
	
	@Override
	protected View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.frag_next, null);
		return view;
	}

	@Override
	protected void initData(Bundle savedInstanceState) {
		hideTitle();
		ib_back.setVisibility(View.VISIBLE);
		tv_title.setVisibility(View.VISIBLE);
		btnRight.setVisibility(View.VISIBLE);
		btnRight.setText("µÇÂ½");
		String tag = getTag();
		if(tag.equals("tag"+Constants.REGISTER2)){
			tv_title.setText("×¢²á");
			btnSubmit.setText("Íê³É×¢²á");
		}else{
			tv_title.setText("ÕÒ»ØÃÜÂë");
			btnSubmit.setText("ÉèÖÃÃÜÂë");
		}
	}

	@Override
	protected void registerEvent() {
		ib_back.setOnClickListener(this);
		btnRight.setOnClickListener(this);
		btnSubmit.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view) {
		super.onClick(view);
		String pwd1 = pvPassword1.getPassword().trim();
		String pwd2 = pvPassword2.getPassword().trim();
		switch (view.getId()) {
		case R.id.ib_back:
			if(activity.getSupportFragmentManager().getBackStackEntryCount() > 0){  
                activity.getSupportFragmentManager().popBackStack();  
            }
			break;
		case R.id.btn_right:
			//LoginFragment loginFragment = new LoginFragment();
			LoginFragment loginFragment = (LoginFragment) activity.getSupportFragmentManager().findFragmentByTag("tag"+Constants.LOGINFRAG);
			activity.switchFragment(loginFragment, Constants.LOGINFRAG);
			break;
		case R.id.btnSubmit:
			if(TextUtils.isEmpty(pwd1) || TextUtils.isEmpty(pwd2) || !pwd1.equals(pwd2)){
				new CustomToast(activity,R.string.norpwd_str, 1000).show();
			}else if(pwd1.length()<6){
				new CustomToast(activity,R.string.pwdlen_str, 1000).show();
			}else if(!VerifyUtil.isPassword(pwd1)){
				new CustomToast(activity,R.string.pwdsafe_str, 1000).show();
			}else{
				activity.switchActivity(MainActivity.class);
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
	}
}
