package com.co.hiberus.microservicio.prueba.app.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.co.hiberus.microservicio.prueba.app.models.entity.Envio;

public interface EnvioRepository extends CrudRepository<Envio, Long> {

	@Query("select e from Envio e join fetch e.cliente c join fetch e.item i join fetch i join fetch i.producto p where c.id=?1 and p.id=?2")
	public Iterable<Envio> findEnvioByClienteByProducto(Long clienteId, Long productoId);
	
	@Query("select p.id from Envio e join e.cliente c join e.item i join i.producto p where c.id=?1 group by p.id")
	public Iterable<Long> findProductosIdsConEnviosByCliente(Long clienteId);
}
