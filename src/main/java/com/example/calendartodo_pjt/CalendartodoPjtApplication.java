package com.example.calendartodo_pjt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CalendartodoPjtApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalendartodoPjtApplication.class, args);
	}

}
