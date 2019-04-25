package com.fly.tx.serviceb.service;

import com.fly.tx.serviceb.entity.UserInfo;

public interface IUserService {

	UserInfo saveUserAndOrder(String exType);

	UserInfo saveOrderAndUser(String exType);

	UserInfo saveUser(String exType);
}
