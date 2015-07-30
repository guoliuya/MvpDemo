package com.example.mvpdemo.presenter;

import android.os.Handler;

import com.example.mvpdemo.bean.User;
import com.example.mvpdemo.interf.IUserImpl;
import com.example.mvpdemo.interf.IUserLoginView;
import com.example.mvpdemo.interf.OnLoginListener;

public class UserLoginPresenter {
//presenter 是 view和model进行交互的桥梁，也可以形象的比喻成中间人，presenter的字面含义是主持人，推荐人。
//既然是桥梁，那么应该有什么方法呢，那就要看要实现的功能都有哪些操作，本例的功能是有两个操作，登陆和清除
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
