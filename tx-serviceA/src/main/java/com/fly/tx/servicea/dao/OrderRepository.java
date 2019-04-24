package com.fly.tx.servicea.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fly.tx.servicea.Entity.OrderInfo;

public interface OrderRepository extends JpaRepository<OrderInfo, Integer> {

}