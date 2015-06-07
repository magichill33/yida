package com.ly.yida.fragment;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.ly.yida.R;
import com.ly.yida.SelectContactActivity;
import com.ly.yida.utils.CustomToast;
import com.ly.yida.utils.VerifyUtil;
import com.ly.yida.view.ClearEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class InviteFragment extends BaseFragment {
	@ViewInject(R.id.cet_phone)
	private ClearEditText cetPhone;
	@ViewInject(R.id.btnContact)
	private Button btnContact;
	@ViewInject(R.id.spr_lock)
	private Spinner sprLock;
	@ViewInject(R.id.btn_grant)
	private Button btnGrant;
	
	private String[] m_arr = {"车位锁A","车位锁B","车位锁C"};
	
	@Override
	protected View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.frag_invite, null);
		return view;
	}

	@Override
	protected void initData(Bundle savedInstanceState) {
		ArrayAdapter<String> ada = new ArrayAdapter<String>(activity,
				android.R.layout.simple_spinner_item,m_arr);
		ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sprLock.setAdapter(ada);
		sprLock.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	protected void registerEvent() {
		btnContact.setOnClickListener(this);
		btnGrant.setOnClickListener(this);
	}
	
	public void setContactInfo(String info){
		cetPhone.setText(info);
	}
	
	@Override
	public void onClick(View view) {
		super.onClick(view);
		String phoneNum = cetPhone.getText().toString().trim();
		switch (view.getId()) {
		case R.id.btn_grant:
			if(!VerifyUtil.isCellphone(phoneNum)){
				new CustomToast(activity, R.string.rightphone_str, 1000).show();
				return;
			}
			break;
		case R.id.btnContact:
			activity.startActivityForResult(new Intent(activity,SelectContactActivity.class),
					0);
			break;
		default:
			break;
		}
	}
}
