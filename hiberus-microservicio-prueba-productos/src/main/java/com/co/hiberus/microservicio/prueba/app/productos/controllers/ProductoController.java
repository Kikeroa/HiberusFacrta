package com.co.hiberus.microservicio.prueba.app.productos.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.hiberus.microservicio.prueba.app.productos.services.ProductoService;
import com.co.hiberus.microservicio.prueba.commons.controllers.CommonController;
import com.co.hiberus.microservicio.prueba.commons.productos.models.entity.Item;
import com.co.hiberus.microservicio.prueba.commons.productos.models.entity.Producto;

@RestController
public class ProductoController extends CommonController<Producto, ProductoService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Producto producto, BindingResult result, @PathVariable Long id){
		
		if (result.hasErrors()) {
			
			return this.validar(result);
		}
		
		Optional<Producto> opt = service.findById(id);
		
		if (!opt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Producto dbProducto = opt.get();
		dbProducto.setNombre(producto.getNombre());
		
		List<Item> eliminadas = new ArrayList<>();
		
		dbProducto.getItems().forEach(pdb -> {
			if (!producto.getItems().contains(pdb)) {
				eliminadas.add(pdb);
			}
		});
		
		eliminadas.forEach(p -> {
			dbProducto.removeItem(p);
		});
		
		dbProducto.setItems(producto.getItems());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbProducto));
		
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		
		return ResponseEntity.ok(service.findByNombre(term));
	
	}
	
	@GetMapping("/categorias")
	public ResponseEntity<?> listarCategorias(){
		
		return ResponseEntity.ok(service.findAllCategorias());
	
	}
}
