package com.ly.yida.fragment;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.ly.yida.R;
import com.ly.yida.utils.AppManager;
import com.ly.yida.utils.Constants;
import com.ly.yida.utils.CustomProgressDialog;
import com.ly.yida.utils.SharePrefUtil;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CenterFragment extends BaseFragment {

	@ViewInject(R.id.rl_invite)
	private RelativeLayout rlInvite;
	@ViewInject(R.id.rl_positon)
	private RelativeLayout rlPosition;
	@ViewInject(R.id.rl_grant)
	private RelativeLayout rlGrant;
	@ViewInject(R.id.tv_exit)
	private TextView tvExit;
	
	@Override
	protected View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.frag_center, null);
		return view;
	}

	@Override
	protected void initData(Bundle savedInstanceState) {

	}

	@Override
	protected void registerEvent() {
		rlInvite.setOnClickListener(this);
		rlPosition.setOnClickListener(this);
		rlGrant.setOnClickListener(this);
		tvExit.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()) {
		case R.id.rl_invite:
			InviteFragment inviteFragment = new InviteFragment();
			activity.switchFragment(inviteFragment, Constants.INVITE);
			break;
		case R.id.rl_positon:

			break;
		case R.id.rl_grant:

			break;
		case R.id.tv_exit:
			SharePrefUtil.clear(activity.getApplicationContext());
			final CustomProgressDialog pd = new CustomProgressDialog(activity, "ÕýÔÚÍË³ö¡­¡­¡­");
			pd.show();
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					pd.dismiss();
					AppManager.getAppManager().AppExit(activity);
				}
			}, 2000);
			break;
		default:
			break;
		}
	}
}
