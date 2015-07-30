package com.example.mvpdemo.interf;

import com.example.mvpdemo.bean.User;

public interface IUserLoginView {
//这里是布局中所有用得到的视图的业务逻辑
//登陆按钮的业务逻辑
	String getUsername();//获得用户名
	String getPassword();//获得用户密码
	void showLoading();//显示加载view
	void hideLoading();//隐藏加载视图
	void toSuccessActivity(User user);//登陆成功
	void loginFail();//登陆失败
//清除按钮的业务逻辑
	void clearUsername();
	void clearPassword();
}
