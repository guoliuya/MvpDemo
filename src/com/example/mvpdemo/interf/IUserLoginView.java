package com.example.mvpdemo.interf;

import com.example.mvpdemo.bean.User;

public interface IUserLoginView {
//�����ǲ����������õõ�����ͼ��ҵ���߼�
//��½��ť��ҵ���߼�
	String getUsername();//����û���
	String getPassword();//����û�����
	void showLoading();//��ʾ����view
	void hideLoading();//���ؼ�����ͼ
	void toSuccessActivity(User user);//��½�ɹ�
	void loginFail();//��½ʧ��
//�����ť��ҵ���߼�
	void clearUsername();
	void clearPassword();
}
