package com.co.hiberus.microservicio.prueba.app.clientes.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.hiberus.microservicio.prueba.app.clientes.models.service.ClienteService;
import com.co.hiberus.microservicio.prueba.commons.clientes.models.entity.Cliente;
import com.co.hiberus.microservicio.prueba.commons.controllers.CommonController;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends CommonController<Cliente, ClienteService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id ) {

		if (result.hasErrors()) {
			
			return this.validar(result);
		}
		
		Optional<Cliente> opt = service.findById(id);

		if (!opt.isPresent()) {

			return ResponseEntity.notFound().build();
		}

		Cliente clienteDb = opt.get();

		clienteDb.setNombre(cliente.getNombre());
		clienteDb.setApellido(cliente.getApellido());
		clienteDb.setEmail(cliente.getEmail());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clienteDb));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		
		return ResponseEntity.ok(service.findByNombreOrApellido(term));
	}
}
