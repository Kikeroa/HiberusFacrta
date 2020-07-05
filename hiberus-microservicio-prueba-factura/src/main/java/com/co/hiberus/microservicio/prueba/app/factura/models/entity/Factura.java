package com.co.hiberus.microservicio.prueba.app.factura.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.co.hiberus.microservicio.prueba.commons.clientes.models.entity.Cliente;
import com.co.hiberus.microservicio.prueba.commons.productos.models.entity.Producto;

@Entity
@Table(name = "facturas")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(name ="creat_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Cliente> clientes;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Producto> productos;
	
	public Factura() {
		
		this.clientes = new ArrayList<>();
		this.productos = new ArrayList<>();
	
	}

	@PrePersist
	public void PrePersist() {
		this.createAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void addClientes(Cliente cliente) {
		this.clientes.add(cliente);
	}

	public void removeClientes(Cliente cliente) {
		this.clientes.remove(cliente);
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void addProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public void removeProducto(Producto producto) {
		this.productos.remove(producto);
	}
	
}
