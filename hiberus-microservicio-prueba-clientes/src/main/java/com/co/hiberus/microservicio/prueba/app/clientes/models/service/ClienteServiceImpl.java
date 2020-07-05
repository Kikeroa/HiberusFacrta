package com.co.hiberus.microservicio.prueba.app.clientes.models.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.hiberus.microservicio.prueba.app.clientes.models.repository.ClienteRepository;
import com.co.hiberus.microservicio.prueba.commons.clientes.models.entity.Cliente;
import com.co.hiberus.microservicio.prueba.commons.service.CommonServiceImpl;

@Service
public class ClienteServiceImpl extends CommonServiceImpl<Cliente, ClienteRepository> implements ClienteService {

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByNombreOrApellido(String term) {
		
		return repository.findByNombreOrApellido(term);
	}

}
