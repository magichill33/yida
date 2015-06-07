package com.ly.yida.fragment;


import com.lidroid.xutils.ViewUtils;
import com.ly.yida.BaseActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment implements OnClickListener  {
	protected BaseActivity activity;     
	public View rootView;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		
		super.onActivityCreated(savedInstanceState);
		initData(savedInstanceState);
		registerEvent();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		activity = (BaseActivity) getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView  = initView(inflater);
		ViewUtils.inject(this, rootView);
		return rootView;
	}
	public View getRootView(){
		return rootView;
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	protected abstract View initView(LayoutInflater inflater);

	protected abstract void initData(Bundle savedInstanceState);

	protected abstract void registerEvent();
}
