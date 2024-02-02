package com.hexaware.demo;

import org.springframework.stereotype.Component;

@Component("mailservice")
public class EmailService {
	private final DataSource dataSource;
	
	public EmailService(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void sendemail() {
		this.dataSource.getConnection();
	}
}
