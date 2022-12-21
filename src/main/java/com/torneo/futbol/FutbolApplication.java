package com.torneo.futbol;

import com.torneo.futbol.model.Player;
import com.torneo.futbol.model.Team;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class FutbolApplication {

	private static final Logger log = LoggerFactory.getLogger(FutbolApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FutbolApplication.class, args);
	}

}
