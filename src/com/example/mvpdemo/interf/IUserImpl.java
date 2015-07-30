package com.example.mvpdemo.interf;

import com.example.mvpdemo.bean.User;

public class IUserImpl implements IUser{

	

	@Override
	public void login(final String username, final String password,
			final OnLoginListener onLoginListener) {
		// TODO Auto-generated method stub
		//模拟子线程耗时操作
		new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//模拟登陆成功和失败
				if("guoliuya".equals(username)&&"123456".equals(password)){
					User user=new User();
					user.setUsername(username);
					user.setPassword(password);
					onLoginListener.success(user);
				}else {
					onLoginListener.fail();
				}
			}
		}.start();
	}

}
