package com.co.hiberus.microservicio.prueba.app.productos.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.hiberus.microservicio.prueba.app.productos.models.repository.CategoriaRespository;
import com.co.hiberus.microservicio.prueba.app.productos.models.repository.ProductoRepository;
import com.co.hiberus.microservicio.prueba.commons.productos.models.entity.Categoria;
import com.co.hiberus.microservicio.prueba.commons.productos.models.entity.Producto;
import com.co.hiberus.microservicio.prueba.commons.service.CommonServiceImpl;

@Service
public class ProductoServiceImpl extends CommonServiceImpl<Producto, ProductoRepository> implements ProductoService {

	@Autowired
	private CategoriaRespository categoriaRespository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {

		return repository.findByNombre(term);
	}

	@Override
	public Iterable<Categoria> findAllCategorias() {
		return categoriaRespository.findAll();
	}
	

}
