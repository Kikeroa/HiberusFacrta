package com.co.hiberus.microservicio.prueba.app.factura.services;

import com.co.hiberus.microservicio.prueba.app.factura.models.entity.Factura;
import com.co.hiberus.microservicio.prueba.commons.service.CommonService;

public interface FacturaService extends CommonService<Factura> {
	
	public Factura findFacturaByClienteId(Long id);
}
