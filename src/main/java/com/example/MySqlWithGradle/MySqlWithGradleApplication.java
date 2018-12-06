package com.example.MySqlWithGradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MySqlWithGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySqlWithGradleApplication.class, args);
	}
}
