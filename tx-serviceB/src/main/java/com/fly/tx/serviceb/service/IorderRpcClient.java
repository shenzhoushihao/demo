package com.fly.tx.serviceb.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fly.tx.serviceb.service.impl.IOrderHystrixRpcClient;

@FeignClient(name = "tx-service-a", fallback = IOrderHystrixRpcClient.class)
public interface IorderRpcClient {

	@PostMapping(value = "/v0/user/{uid}/order")
	boolean saveOrder(@PathVariable(value = "uid") Integer uid, @RequestParam(value = "exType") String exType)
			throws Exception;
}
