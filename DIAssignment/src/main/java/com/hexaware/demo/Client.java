package com.hexaware.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		DataSource dataSource1 = context.getBean(MySQLDataSource.class);
		DataSource dataSource2 = context.getBean(PostgreSQLDataSource.class);
        EmailService emailService1 = new EmailService(dataSource1);
        EmailService emailService2 = new EmailService(dataSource2);
        emailService1.sendemail();
        emailService2.sendemail();
	}
}
