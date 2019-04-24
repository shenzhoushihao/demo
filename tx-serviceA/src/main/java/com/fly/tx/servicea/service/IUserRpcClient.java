package com.fly.tx.servicea.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fly.tx.servicea.service.impl.IUserHystrixRpcClient;

@FeignClient(name = "tx-service-b", fallback = IUserHystrixRpcClient.class)
public interface IUserRpcClient {

	@PostMapping(value = "/v0/user")
	boolean saveUser(@RequestParam(value = "exType") String exType);
}
