package com.fly.tx.serviceb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fly.tx.serviceb.entity.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {

}
