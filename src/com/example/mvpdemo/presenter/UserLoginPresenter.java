package com.example.mvpdemo.presenter;

import android.os.Handler;

import com.example.mvpdemo.bean.User;
import com.example.mvpdemo.interf.IUserImpl;
import com.example.mvpdemo.interf.IUserLoginView;
import com.example.mvpdemo.interf.OnLoginListener;

public class UserLoginPresenter {
//presenter �� view��model���н�����������Ҳ��������ı������м��ˣ�presenter�����溬���������ˣ��Ƽ��ˡ�
//��Ȼ����������ôӦ����ʲô�����أ��Ǿ�Ҫ��Ҫʵ�ֵĹ��ܶ�����Щ�����������Ĺ�������������������½�����
	private IUserImpl iUserImpl;
	private IUserLoginView iUserLoginView;
	private Handler handler=new Handler();
	public UserLoginPresenter(IUserLoginView iLoginView){
		this.iUserLoginView=iLoginView;
		this.iUserImpl=new IUserImpl();
	}
	public void login(){
		iUserLoginView.showLoading();
		iUserImpl.login(iUserLoginView.getUsername(), iUserLoginView.getPassword(), new OnLoginListener() {
			
			@Override
			public void success(final User user) {
				// TODO Auto-generated method stub
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						iUserLoginView.toSuccessActivity(user);
						iUserLoginView.hideLoading();
					}
				});
//				handler.postDelayed(new Runnable() {
//					
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						
//					}
//				}, 1000);
			}
			
			@Override
			public void fail() {
				// TODO Auto-generated method stub
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						iUserLoginView.loginFail();
						iUserLoginView.hideLoading();
					}
				});
			}
		});
	}
	public void clear(){
		iUserLoginView.clearUsername();
		iUserLoginView.clearPassword();
	}
}
