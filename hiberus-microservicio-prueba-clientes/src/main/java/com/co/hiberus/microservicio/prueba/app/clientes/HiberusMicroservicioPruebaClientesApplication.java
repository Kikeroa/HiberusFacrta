package com.co.hiberus.microservicio.prueba.app.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.co.hiberus.microservicio.prueba.commons.clientes.models.entity"})
public class HiberusMicroservicioPruebaClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiberusMicroservicioPruebaClientesApplication.class, args);
	}

}
