package com.co.hiberus.microservicio.prueba.app.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HiberusMicroservicioPruebaEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiberusMicroservicioPruebaEurekaServerApplication.class, args);
	}

}
