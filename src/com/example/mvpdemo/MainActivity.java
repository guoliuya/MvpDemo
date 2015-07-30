package com.example.mvpdemo;

import com.example.mvpdemo.bean.User;
import com.example.mvpdemo.interf.IUserLoginView;
import com.example.mvpdemo.presenter.UserLoginPresenter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity implements IUserLoginView, OnClickListener {
private EditText e1,e2;
private Button bt1,bt2;
private ProgressBar progressBar;
private UserLoginPresenter userLoginPresenter=new UserLoginPresenter(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_login);
		initView();
		initAction();
	}

	

	private void initView() {
		// TODO Auto-generated method stub
		e1=(EditText) findViewById(R.id.et_username);
		e2=(EditText) findViewById(R.id.et_password);
		bt1=(Button) findViewById(R.id.bt_login);
		bt2=(Button) findViewById(R.id.bt_clear);
		progressBar=(ProgressBar) findViewById(R.id.id_pb_loading);
		
	}
	private void initAction() {
		// TODO Auto-generated method stub
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return e1.getText().toString();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return e2.getText().toString();
	}

	@Override
	public void showLoading() {
		// TODO Auto-generated method stub
		progressBar.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideLoading() {
		// TODO Auto-generated method stub
		progressBar.setVisibility(View.GONE);
		
	}

	@Override
	public void toSuccessActivity(User user) {
		// TODO Auto-generated method stub
		Toast.makeText(MainActivity.this, "登陆成功，跳转到成功页面", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void loginFail() {
		// TODO Auto-generated method stub
		Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void clearUsername() {
		// TODO Auto-generated method stub
		e1.setText("");
	}

	@Override
	public void clearPassword() {
		// TODO Auto-generated method stub
		e2.setText("");
	}



	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bt_login:
			userLoginPresenter.login();
			break;
		case R.id.bt_clear:
			userLoginPresenter.clear();
			break;

		default:
			break;
		}
	}

}
