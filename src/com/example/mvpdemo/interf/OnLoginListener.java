package com.example.mvpdemo.interf;

import com.example.mvpdemo.bean.User;

public interface OnLoginListener {
  void success(User user);
  void fail();
}
