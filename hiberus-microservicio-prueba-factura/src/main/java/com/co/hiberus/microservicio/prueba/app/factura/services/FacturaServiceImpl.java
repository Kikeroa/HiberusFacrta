package com.co.hiberus.microservicio.prueba.app.factura.services;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.hiberus.microservicio.prueba.app.factura.models.entity.Factura;
import com.co.hiberus.microservicio.prueba.app.factura.models.repository.FacturaRepository;
import com.co.hiberus.microservicio.prueba.commons.service.CommonServiceImpl;

@Service
public class FacturaServiceImpl extends CommonServiceImpl<Factura, FacturaRepository> implements FacturaService {

	@Override
	@Transactional(readOnly = true)
	public Factura findFacturaByClienteId(Long id) {

		return repository.findFacturaByClienteId(id);
	}

}
