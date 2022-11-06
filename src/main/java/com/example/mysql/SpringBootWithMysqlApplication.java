package com.example.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
public class SpringBootWithMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMysqlApplication.class, args);
	}


}
