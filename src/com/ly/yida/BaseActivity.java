package com.ly.yida;

import java.util.Locale;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.util.LogUtils;
import com.ly.yida.utils.AppManager;
import com.ly.yida.utils.CommonUtil;
import com.ly.yida.utils.CustomToast;
import com.ly.yida.utils.PreferenceUtil;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.audiofx.BassBoost;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;

public abstract class BaseActivity extends FragmentActivity implements OnClickListener{
	
	private Context ct;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		AppManager.getAppManager().addActivity(this);
		
		//初始化PreferenceUtil
		PreferenceUtil.init(this);
		ct = this;
		//根据上次的语言设置，重新设置语言
	
	    initView();
	    registerEvent();
	    initData();
	}
	
	protected abstract void initView();
	
	protected abstract void registerEvent();

	protected abstract void initData();
	
	public abstract void switchFragment(Fragment fm, int type);
	
	public abstract void switchActivity(Class<? extends Activity> clazz);
	
	
	protected void loadData(HttpRequest.HttpMethod method, String url,
			RequestParams params, RequestCallBack<String> callback) {
		HttpUtils http = new HttpUtils();
		http.configCurrentHttpCacheExpiry(0);

		LogUtils.allowD = true;
		if (params != null) {
			if (params.getQueryStringParams() != null)
				LogUtils.d(url + "?" + params.getQueryStringParams().toString());
		}else{
			params = new RequestParams();
			
		}
//		params.addHeader("x-deviceid", app.deviceId);
//		params.addHeader("x-channel", app.channel);
		if (0 == CommonUtil.isNetworkAvailable(ct)) {
			showToast("加载失败，请检查网络！");
		} else {
			LogUtils.d(url);
			http.send(method, url, params, callback);
		}
	}
	
	protected void showToast(String msg) {
		showToast(msg, 0);
	}

	protected void showToast(String msg, int time) {
		CustomToast customToast = new CustomToast(ct, msg, time);
		customToast.show();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		AppManager.getAppManager().finishActivity(this);
	}
}
