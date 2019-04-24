package com.fly.tx.serviceb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 功能描述:Entity
 * 
 * @author Roc
 *
 */
@Entity
@Table(name = "user_info")
@Data
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 5492713944191255534L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uid", length = 11)
	private Integer id;

	@Column(name = "username", length = 64)
	private String userName;

	@Column(name = "truename", length = 64)
	private String trueName;

	@Column(name = "email", length = 64)
	private String email;

	@Column(name = "age", length = 64)
	private Integer age;
}
