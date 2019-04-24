package com.fly.tx.serviceb.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.fly.tx.serviceb.service.IorderRpcClient;

/**
 * 
 * @author Roc
 *
 */
@SpringCloudApplication
@EnableHystrix
@EnableFeignClients(clients = { IorderRpcClient.class })
@EnableJpaRepositories(basePackages = "com.fly.tx.serviceb.dao")
@EntityScan(basePackages = "com.fly.tx.serviceb.entity")
@ComponentScan(basePackages = { "com.fly.tx.serviceb.service", "com.fly.tx.serviceb.controller",
		"com.fly.tx.serviceb.config" })
@EnableScheduling
@EnableDistributedTransaction
public class TXServiceBServer {
	public static void main(String[] args) {
		SpringApplication.run(TXServiceBServer.class, args);
	}
}
