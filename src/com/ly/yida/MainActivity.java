package com.ly.yida;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.ly.yida.fragment.CenterFragment;
import com.ly.yida.fragment.InviteFragment;
import com.ly.yida.fragment.OperationFragment;
import com.ly.yida.utils.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

	@ViewInject(R.id.btnOperation)
	private Button btnOperation;
	@ViewInject(R.id.btnInvite)
	private Button btnInvite;
	@ViewInject(R.id.btnCenter)
	private Button btnCenter;
	
	private OperationFragment operationFragment;
	private InviteFragment inviteFragment;
	private CenterFragment centerFragment;

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnOperation:
			switchFragment(operationFragment, Constants.OPERATION);
			break;
		case R.id.btnInvite:
			switchFragment(inviteFragment, Constants.INVITE);
			break;
		case R.id.btnCenter:
			switchFragment(centerFragment, Constants.CENTER);
			break;
		default:
			break;
		}
	}

	@Override
	protected void initView() {
		setContentView(R.layout.activity_main);
		ViewUtils.inject(this);
		operationFragment = new OperationFragment();
		inviteFragment = new InviteFragment();
		centerFragment = new CenterFragment();
		switchFragment(operationFragment, Constants.OPERATION);
	}

	@Override
	protected void registerEvent() {
		btnOperation.setOnClickListener(this);
		btnInvite.setOnClickListener(this);
		btnCenter.setOnClickListener(this);
	}

	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void switchFragment(Fragment fm, int type) {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.fl_content, fm, "tag"+type);
		ft.commit();
	}

	@Override
	public void switchActivity(Class<? extends Activity> clazz) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(data==null)
			return;
		String phone = data.getStringExtra("phone").replace("-", "");
		inviteFragment.setContactInfo(phone);
	}

}
