package com.fly.registry.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 功能描述:注册中心
 * 
 * @author Roc
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistryServer {
	public static void main(String[] args) {
		SpringApplication.run(RegistryServer.class, args);
	}
}
