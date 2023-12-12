package com.example.CitizenServiceApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages ={"com.example.Citizenserives","com.example.CitizenController","com.example.exception"})
@EnableJpaRepositories("com.example.CitizenRepository")
@EntityScan("com.example.CitizenModel")
public class CitizenServiceModApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitizenServiceModApplication.class, args);
	}

}
