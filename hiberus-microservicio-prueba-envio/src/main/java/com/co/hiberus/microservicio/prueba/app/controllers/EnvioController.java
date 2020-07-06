package com.co.hiberus.microservicio.prueba.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.hiberus.microservicio.prueba.app.models.entity.Envio;
import com.co.hiberus.microservicio.prueba.app.services.EnvioService;

@RestController
public class EnvioController {

	@Autowired
	private EnvioService service;
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Iterable<Envio> envios){
		
		Iterable<Envio> envioDb = service.saveAll(envios);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(envioDb);
		
	}
	
	@GetMapping("/cliente/{clienteId}/producto/{productoId}")
	public ResponseEntity<?>obteneEnvioPorClientePorProducto(@PathVariable Long clienteId, @PathVariable Long productoId){
		
		Iterable<Envio> envios = service.findEnvioByClienteByProducto(clienteId, productoId);
		
		return ResponseEntity.ok(envios);
	}
	
	@GetMapping("/cliente/{clienteId}/envios-despachados")
	public ResponseEntity<?> obtenerProductosIdsConDespachosCliente(@PathVariable Long clienteId){
		
		Iterable<Long> productosIds = service.findProductosIdsConEnviosByCliente(clienteId);
		
		return ResponseEntity.ok(productosIds);
	}
		
}
