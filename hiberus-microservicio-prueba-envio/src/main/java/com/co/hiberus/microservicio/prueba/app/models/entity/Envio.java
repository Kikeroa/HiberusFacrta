package com.co.hiberus.microservicio.prueba.app.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.co.hiberus.microservicio.prueba.commons.clientes.models.entity.Cliente;
import com.co.hiberus.microservicio.prueba.commons.productos.models.entity.Producto;

@Entity
@Table(name = "envios")
public class Envio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String ubicacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Producto producto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
