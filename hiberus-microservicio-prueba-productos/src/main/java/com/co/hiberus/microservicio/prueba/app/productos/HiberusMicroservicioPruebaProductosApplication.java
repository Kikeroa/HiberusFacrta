package com.co.hiberus.microservicio.prueba.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.co.hiberus.microservicio.prueba.commons.productos.models.entity"})
public class HiberusMicroservicioPruebaProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiberusMicroservicioPruebaProductosApplication.class, args);
	}

}
