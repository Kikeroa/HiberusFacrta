package com.co.hiberus.microservicio.prueba.app.clientes.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.co.hiberus.microservicio.prueba.commons.clientes.models.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{

	@Query("select c from Cliente c where c.nombre like %?1% or c.apellido like %?1%")
	public List<Cliente> findByNombreOrApellido(String term);
	
}
