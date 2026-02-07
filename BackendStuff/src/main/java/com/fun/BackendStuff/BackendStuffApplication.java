package com.fun.BackendStuff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BackendStuffApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendStuffApplication.class, args);
	}

}
