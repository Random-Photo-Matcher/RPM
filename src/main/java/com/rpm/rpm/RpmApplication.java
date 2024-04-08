package com.rpm.rpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RpmApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpmApplication.class, args);
	}
}
