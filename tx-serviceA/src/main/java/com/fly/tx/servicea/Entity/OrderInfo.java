package com.fly.tx.servicea.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "order_info")
@Data
public class OrderInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid", length = 11)
	private Integer id;

	@Column(name = "ordername", length = 32)
	private String orderName;

	@Column(name = "address", length = 32)
	private String address;

	@Column(name = "uid", length = 12)
	private Integer uid;
}
