package com.hexaware.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("mysql")
@Primary
public class MySQLDataSource implements DataSource{
	@Override
	public void getConnection() {
		System.out.println("Connecting to MySQL Database.....");
	}
}
