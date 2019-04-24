package com.fly.tx.servicea.config;

import org.hibernate.dialect.MySQL57InnoDBDialect;

/**
 * 配置字符集
 * 
 * @author Roc
 *
 */
@SuppressWarnings("deprecation")
public class MySQL57InnoDBDialectUtf8mb4 extends MySQL57InnoDBDialect {
	@Override
	public String getTableTypeString() {
		return "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci";
	}
}
