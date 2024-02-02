package com.hexaware.demo;

import org.springframework.stereotype.Component;

@Component("postgresql")
public class PostgreSQLDataSource implements DataSource{
	@Override
	public void getConnection() {
		System.out.println("Connecting to PostgreSQL Database.....");
	}
}
