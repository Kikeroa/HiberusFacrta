package com.co.hiberus.microservicio.prueba.commons.productos.models.entity;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "precio")
	private Double precio;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAtDate;

	@JsonIgnoreProperties(value = { "producto" }, allowSetters = true)
	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> items;

	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;

	public Producto() {
		this.items = new ArrayList<>();
	}

	@PrePersist
	public void prePersist() {
		this.createAtDate = new Date();
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getCreateAtDate() {
		return createAtDate;
	}

	public void setCreateAtDate(Date createAtDate) {
		this.createAtDate = createAtDate;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items.clear();
		items.forEach(p -> this.addItem(p));
	}

	public void addItem(Item item) {
		this.items.add(item);
		item.setProducto(this);
	}

	public void removeItem(Item item) {
		this.items.remove(item);
		item.setProducto(null);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Producto)) {
			return false;
		}
		Producto prod = (Producto) obj;

		return this.id != null && this.id.equals(prod.getId());
	}

}
