package com.portfolio.portfoliospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.portfolio")
@EnableJpaRepositories("com.portfolio.Repository")
@EntityScan("com.portfolio.Models") 
public class PortfoliospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfoliospringApplication.class, args);
	}
	
	
}
