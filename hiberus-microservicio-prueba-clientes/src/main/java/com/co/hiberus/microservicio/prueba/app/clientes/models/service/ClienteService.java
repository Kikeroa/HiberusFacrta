package com.co.hiberus.microservicio.prueba.app.clientes.models.service;


import java.util.List;

import com.co.hiberus.microservicio.prueba.commons.clientes.models.entity.Cliente;
import com.co.hiberus.microservicio.prueba.commons.service.CommonService;

public interface ClienteService extends CommonService<Cliente> {

	public List<Cliente> findByNombreOrApellido(String term);
}
