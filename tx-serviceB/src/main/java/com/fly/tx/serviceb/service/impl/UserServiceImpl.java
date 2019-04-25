package com.fly.tx.serviceb.service.impl;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.fly.tx.serviceb.config.BRPCError;
import com.fly.tx.serviceb.config.BRPCException;
import com.fly.tx.serviceb.dao.UserRepository;
import com.fly.tx.serviceb.entity.UserInfo;
import com.fly.tx.serviceb.service.IUserService;
import com.fly.tx.serviceb.service.IorderRpcClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IorderRpcClient orderRpcClient;

	@LcnTransaction
	@Transactional
	@Override
	public UserInfo saveUserAndOrder(String exType) {
		UserInfo user = new UserInfo();
		user.setUserName(UUID.randomUUID().toString());
		user.setTrueName("zhangSir");
		user.setEmail("hello@zhang.com");
		user.setAge((int) (Math.random() * 100));
		UserInfo u0 = userRepository.saveAndFlush(user);
		boolean saveOrderStatus = orderRpcClient.saveOrder(u0.getId(), exType);
		log.info("saveOrderStatus=========>{}", saveOrderStatus);
		return u0;
	}

	@LcnTransaction
	@Transactional
	@Override
	public UserInfo saveOrderAndUser(String exType) {
		boolean saveOrderStatus = orderRpcClient.saveOrder(11, exType);
		log.info("saveOrderStatus=========>{}", saveOrderStatus);

		UserInfo user = new UserInfo();
		user.setUserName(UUID.randomUUID().toString());
		user.setTrueName("zhangSir");
		user.setEmail("hello@zhang.com");
		user.setAge((int) (Math.random() * 100));
		UserInfo u0 = userRepository.saveAndFlush(user);
		if (StringUtils.isNotBlank(exType) && StringUtils.equalsIgnoreCase(exType, "2")) {
			throw new BRPCException(BRPCError.RPC_BAD_REQUEST);
		}
		return u0;
	}

	@LcnTransaction
	@Transactional
	@Override
	public boolean saveUser(String exType) {
		UserInfo user = new UserInfo();
		user.setUserName(UUID.randomUUID().toString());
		user.setTrueName("liSir");
		user.setEmail("world@li.com");
		user.setAge((int) (Math.random() * 100));
		userRepository.saveAndFlush(user);
		if (StringUtils.isNotBlank(exType) && exType.equalsIgnoreCase("3")) {
			throw new BRPCException("2 save user fail.", BRPCError.RPC_BAD_REQUEST);
		}
		return true;
	}
}
