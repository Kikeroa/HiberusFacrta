package com.co.hiberus.microservicio.prueba.app.productos.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.co.hiberus.microservicio.prueba.commons.productos.models.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findByNombre(String term);
	
}
