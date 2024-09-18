package com.devWeb.trabalho01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.devWeb.trabalho01.model"})
public class Trabalho01Application {

	public static void main(String[] args) {
		SpringApplication.run(Trabalho01Application.class, args);
	}

}
