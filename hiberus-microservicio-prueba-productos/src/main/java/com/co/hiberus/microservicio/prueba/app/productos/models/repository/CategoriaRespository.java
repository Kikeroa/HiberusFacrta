package com.co.hiberus.microservicio.prueba.app.productos.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.co.hiberus.microservicio.prueba.commons.productos.models.entity.Categoria;

public interface CategoriaRespository extends CrudRepository<Categoria, Long> {

}
