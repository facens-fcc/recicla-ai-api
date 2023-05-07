package com.example.recicla_ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.recicla_ai.repositories.CategoryRepository;
import com.example.recicla_ai.repositories.CompanyRepository;

@SpringBootApplication
public class ReciclaAiApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired CompanyRepository companyRepository,
			@Autowired CategoryRepository categoryRepository) {
		return args -> {
			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ReciclaAiApplication.class, args);
	}

}
