package com.co.hiberus.microservicio.prueba.app.factura.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.co.hiberus.microservicio.prueba.app.factura.models.entity.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Long> {

	@Query("select f from Factura f join fetch f.clientes c where c.id=?1")
	public Factura findFacturaByClienteId(Long id);
}