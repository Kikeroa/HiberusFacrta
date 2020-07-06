package com.co.hiberus.microservicio.prueba.app.services;

import com.co.hiberus.microservicio.prueba.app.models.entity.Envio;

public interface EnvioService {

	public Iterable<Envio> saveAll(Iterable<Envio> envios);
	
	public Iterable<Envio> findEnvioByClienteByProducto(Long clienteId, Long productoId);
	
	public Iterable<Long> findProductosIdsConEnviosByCliente(Long clienteId);
}
