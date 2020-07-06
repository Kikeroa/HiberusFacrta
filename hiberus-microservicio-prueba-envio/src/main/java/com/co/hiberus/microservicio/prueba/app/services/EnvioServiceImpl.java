package com.co.hiberus.microservicio.prueba.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.hiberus.microservicio.prueba.app.models.entity.Envio;
import com.co.hiberus.microservicio.prueba.app.models.repository.EnvioRepository;

@Service
public class EnvioServiceImpl implements EnvioService {

	@Autowired
	private EnvioRepository respository;
	
	@Override
	@Transactional
	public Iterable<Envio> saveAll(Iterable<Envio> envios) {

		return respository.saveAll(envios);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Envio> findEnvioByClienteByProducto(Long clienteId, Long productoId) {

		return respository.findEnvioByClienteByProducto(clienteId, productoId);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> findProductosIdsConEnviosByCliente(Long clienteId) {

		return respository.findProductosIdsConEnviosByCliente(clienteId);
	}

}
