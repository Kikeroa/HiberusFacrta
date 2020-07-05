package com.co.hiberus.microservicio.prueba.commons.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.co.hiberus.microservicio.prueba.commons.service.CommonService;


public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S service;

	@GetMapping
	public ResponseEntity<?> listar() {

		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {

		
		Optional<E> opt = service.findById(id);

		if (!opt.isPresent()) {
			
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(opt.get());

	}

	@PostMapping()
	public ResponseEntity<?> crear(@Valid @RequestBody E entity, BindingResult result) {

		if (result.hasErrors()) {
			
			return this.validar(result);
		}
		
		E entitydb = service.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(entitydb);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {

		service.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	protected ResponseEntity<?> validar(BindingResult result){
		
		Map<String, Object> errores = new HashMap<String, Object>();
		
		result.getFieldErrors().forEach(error -> {
			errores.put(error.getField(),"El campo "+error.getField()+" "+error.getDefaultMessage());
		});
		
		return ResponseEntity.badRequest().body(errores);
	}
}
