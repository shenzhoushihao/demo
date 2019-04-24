package com.fly.tx.servicea.service.impl;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.fly.tx.servicea.Entity.OrderInfo;
import com.fly.tx.servicea.dao.OrderRepository;
import com.fly.tx.servicea.service.IOrderService;
import com.fly.tx.servicea.service.IUserRpcClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(value = "orderService")
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private IUserRpcClient userRpcClient;

	@LcnTransaction
	@Transactional
	@Override
	public boolean saveOrder(Integer uid, String exType) throws Exception {
		boolean saveUser = userRpcClient.saveUser(exType);
		log.info("save user 2,flag:{}.", saveUser);
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setOrderName("1-1");
		orderInfo.setAddress("天津市");
		orderInfo.setUid(uid);
		if (StringUtils.isNoneBlank(exType) && exType.equalsIgnoreCase("1")) {
			throw new Exception("AAA service operate failed.");
		}
		OrderInfo order = orderRepository.saveAndFlush(orderInfo);
		return (order != null);
	}
}
