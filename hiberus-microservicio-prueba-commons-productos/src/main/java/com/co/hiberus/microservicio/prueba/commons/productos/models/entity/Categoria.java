package com.co.hiberus.microservicio.prueba.commons.productos.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@JsonIgnoreProperties(value = { "hijos" })
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria padre;

	@JsonIgnoreProperties(value = { "padre" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "padre", cascade = CascadeType.ALL)
	private List<Categoria> hijos;
	
	public Categoria() {
		
		this.hijos = new ArrayList<>();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getPadre() {
		return padre;
	}

	public void setPadre(Categoria padre) {
		this.padre = padre;
	}

	public List<Categoria> getHijos() {
		return hijos;
	}

	public void setHijos(List<Categoria> hijos) {
		this.hijos = hijos;
	}
}
