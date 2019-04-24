package com.fly.tx.servicea.service.impl;

import org.springframework.stereotype.Component;

import com.fly.tx.servicea.service.IUserRpcClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class IUserHystrixRpcClient implements IUserRpcClient {

	@Override
	public boolean saveUser(String exType) throws Exception {
		log.warn("saveUser rpc fallback,exType:{}", exType);
		throw new Exception("rpc fail.");
	}

}
