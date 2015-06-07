package com.ly.yida;

import com.ly.yida.fragment.LoginFragment;
import com.ly.yida.utils.Constants;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class SplashActivity extends BaseActivity {
	
	private boolean isLogin = false;
	/*private ImageButton ib_back;
	private TextView tv_title;
	private Button btnRight;
	private RelativeLayout titleBar;*/
	/**
	 * 跳到操作台
	 */
	private void gotoOperation(){
		Intent intent  = new Intent();
		intent.setClass(this, MainActivity.class);
		startActivity(intent);
		finish();
	}

	/**
	 * 跳到登录界面
	 */
	private void gotoLogin(){
		setContentView(R.layout.activity_splash);
	/*	ib_back = (ImageButton) findViewById(R.id.ib_back);
		tv_title = (TextView) findViewById(R.id.tv_title);
		btnRight = (Button) findViewById(R.id.btn_right);
		titleBar = (RelativeLayout) findViewById(R.id.titleBar);*/
		LoginFragment loginFrag = new LoginFragment();
		switchFragment(loginFrag,Constants.LOGINFRAG);
	}
	
	/*private void hideTitle(){
		ib_back.setVisibility(View.GONE);
		tv_title.setVisibility(View.GONE);
		btnRight.setVisibility(View.GONE);
	}*/
	
	@Override
	public void switchFragment(Fragment fm, int type) {
		//如果跳转到登陆页，清空fragment栈
		if(type == Constants.LOGINFRAG){
			if(getSupportFragmentManager().getBackStackEntryCount()>0){
				getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
			}
		}
		String tag = "tag" + type;
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.frame_splash, fm,tag);
		if(type!=Constants.LOGINFRAG){
			ft.addToBackStack(tag);
		}
		ft.commit();
	}

	@Override
	public void onClick(View v) {
	}

	@Override
	protected void initView() {
		if(isLogin){
			gotoOperation();
		}else{
			gotoLogin();
		}
	}

	@Override
	protected void registerEvent() {
		//ib_back.setOnClickListener(this);
		
	}

	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void switchActivity(Class<? extends Activity> clazz) {
		Intent intent = new Intent(this,clazz);
		startActivity(intent);
		finish();
	}
}
