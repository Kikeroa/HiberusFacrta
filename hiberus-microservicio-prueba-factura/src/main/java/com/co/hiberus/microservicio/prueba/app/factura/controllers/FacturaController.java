package com.co.hiberus.microservicio.prueba.app.factura.controllers;

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

import com.co.hiberus.microservicio.prueba.app.factura.models.entity.Factura;
import com.co.hiberus.microservicio.prueba.app.factura.services.FacturaService;
import com.co.hiberus.microservicio.prueba.commons.clientes.models.entity.Cliente;
import com.co.hiberus.microservicio.prueba.commons.controllers.CommonController;
import com.co.hiberus.microservicio.prueba.commons.productos.models.entity.Producto;

@RestController
public class FacturaController extends CommonController<Factura, FacturaService>{

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Factura factura, BindingResult result, @PathVariable Long id){
		
		if (result.hasErrors()) {
			
			return this.validar(result);
		}
		
		
		Optional<Factura> opt = this.service.findById(id);
		
		if (!opt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Factura dbFactura = opt.get();
		dbFactura.setDescription(factura.getDescription());
	
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.service.save(dbFactura));
	}
	
	@PutMapping("/{id}/asignar-clientes")
	public ResponseEntity<?> asignarClientes(@RequestBody List<Cliente> clientes,@PathVariable Long id){
		
		Optional<Factura> optional = this.service.findById(id);
		
		if (!optional.isPresent()) {
			
			return ResponseEntity.notFound().build();
		}
		Factura dbFactura = optional.get();
		
		clientes.forEach(a ->{
			dbFactura.addClientes(a);
		});
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.service.save(dbFactura));
	}
	
	@PutMapping("/{id}/eliminar-cliente")
	public ResponseEntity<?> eliminarCliente(@RequestBody Cliente cliente,@PathVariable Long id){
		
		Optional<Factura> optional = this.service.findById(id);
		
		if (!optional.isPresent()) {
			
			return ResponseEntity.notFound().build();
		}
		Factura dbFactura = optional.get();
		
		dbFactura.removeClientes(cliente);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.service.save(dbFactura));
	}
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<?>buscarPorClienteId(@PathVariable Long id){
		
		Factura factura = service.findFacturaByClienteId(id);
		
		return ResponseEntity.ok(factura);
	}
	
	@PutMapping("/{id}/asignar-productos")
	public ResponseEntity<?> asignarProductos(@RequestBody List<Producto> productos,@PathVariable Long id){
		
		Optional<Factura> optional = this.service.findById(id);
		
		if (!optional.isPresent()) {
			
			return ResponseEntity.notFound().build();
		}
		Factura dbFactura = optional.get();
		
		productos.forEach(p ->{
			dbFactura.addProducto(p);
		});
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.service.save(dbFactura));
	}
	
	@PutMapping("/{id}/eliminar-producto")
	public ResponseEntity<?> eliminarProducto(@RequestBody Producto producto,@PathVariable Long id){
		
		Optional<Factura> optional = this.service.findById(id);
		
		if (!optional.isPresent()) {
			
			return ResponseEntity.notFound().build();
		}
		Factura dbFactura = optional.get();
		
		dbFactura.removeProducto(producto);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.service.save(dbFactura));
	}
}
