package com.torneo.futbol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.torneo.futbol.repository", "com.torneo.futbol.service", "com.torneo.futbol.controller"})
public class FutbolApplication {

	private static final Logger log = LoggerFactory.getLogger(FutbolApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FutbolApplication.class, args);
	}

}
