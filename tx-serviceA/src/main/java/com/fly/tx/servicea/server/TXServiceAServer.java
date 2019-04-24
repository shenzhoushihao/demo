package com.fly.tx.servicea.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;

@SpringCloudApplication
@EnableHystrix
@EnableJpaRepositories(basePackages = "com.fly.tx.servicea.dao")
@EntityScan(basePackages = "com.fly.tx.servicea.entity")
@ComponentScan(basePackages = { "com.fly.tx.servicea.service", "com.fly.tx.servicea.controller" })
@EnableScheduling
@EnableDistributedTransaction
public class TXServiceAServer {
	public static void main(String[] args) {
		SpringApplication.run(TXServiceAServer.class, args);
	}
}
