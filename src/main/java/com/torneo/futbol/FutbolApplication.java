package com.torneo.futbol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@SpringBootApplication
@ComponentScan(basePackages = {"com.torneo.futbol.repository", "com.torneo.futbol.service", "com.torneo.futbol.controller"})
public class FutbolApplication {

	private static final Logger log = LoggerFactory.getLogger(FutbolApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FutbolApplication.class, args);
	}

}
