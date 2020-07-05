package com.co.hiberus.microservicio.prueba.app.productos.services;


import java.util.List;

import com.co.hiberus.microservicio.prueba.commons.productos.models.entity.Categoria;
import com.co.hiberus.microservicio.prueba.commons.productos.models.entity.Producto;
import com.co.hiberus.microservicio.prueba.commons.service.CommonService;

public interface ProductoService extends CommonService<Producto>{

	public List<Producto> findByNombre(String term);

	public Iterable<Categoria> findAllCategorias();	
}
