package com.fly.tx.serviceb.service.impl;

import org.springframework.stereotype.Component;

import com.fly.tx.serviceb.service.IorderRpcClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class IOrderHystrixRpcClient implements IorderRpcClient {

	@Override
	public boolean saveOrder(Integer uid, String exType) {
		log.warn("saveOrder rpc fallback,uid:{},exType:{}", uid, exType);
		return false;
	}

}
