package com.fly.tx.servicea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fly.tx.servicea.service.IOrderService;

@RestController
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@PostMapping(value = "/v0/user/{uid}/order")
	public boolean saveOrder(@PathVariable(value = "uid") Integer uid, @RequestParam(value = "exType") String exType)
			throws Exception {
		boolean isSuccess = false;
		isSuccess = orderService.saveOrder(uid, exType);
		return isSuccess;
	}
}
