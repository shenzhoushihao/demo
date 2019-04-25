package com.fly.tx.servicea.service.impl;

import org.springframework.stereotype.Component;

import com.fly.tx.servicea.config.ARPCError;
import com.fly.tx.servicea.config.ARPCException;
import com.fly.tx.servicea.service.IUserRpcClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class IUserHystrixRpcClient implements IUserRpcClient {

	@Override
	public boolean saveUser(String exType) {
		log.warn("saveUser rpc fallback,exType:{}", exType);
		throw new ARPCException("rpc fail.", ARPCError.RPC_ERROR);
	}

}
