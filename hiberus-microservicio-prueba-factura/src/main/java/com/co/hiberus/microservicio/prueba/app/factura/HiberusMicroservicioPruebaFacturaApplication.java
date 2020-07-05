package com.co.hiberus.microservicio.prueba.app.factura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.co.hiberus.microservicio.prueba.commons.clientes.models.entity",
	"com.co.hiberus.microservicio.prueba.commons.productos.models.entity",
	"com.co.hiberus.microservicio.prueba.app.factura.models.entity"})
public class HiberusMicroservicioPruebaFacturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiberusMicroservicioPruebaFacturaApplication.class, args);
	}

}
