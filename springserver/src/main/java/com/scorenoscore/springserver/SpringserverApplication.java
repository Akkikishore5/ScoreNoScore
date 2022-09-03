package com.scorenoscore.springserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.scorenoscore.springserver")
@EnableAutoConfiguration
public class SpringserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringserverApplication.class, args);
	}

}
