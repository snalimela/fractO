package com.realpage.fracto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHibernateProjectApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateProjectApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//Employee employee = getEmployee();
		//employeeDao.createEmployee(employee);
	}
}
