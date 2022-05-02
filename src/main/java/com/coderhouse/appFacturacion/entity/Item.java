package com.coderhouse.appFacturacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ITEMS")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	
	@Column(name = "ID_ITEM")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Min(1)
	@Column(name = "CANTIDAD")
	private int cantidad;
	

	@Min(0)
	@Column(name = "PRECIO_SUBTOTAL")
	private double precioSubTotal;
	
	@ManyToOne
	@JoinColumn(name = "ID_COMPRA")
	private Compra compra;
	
	
	@OneToOne
	@JoinColumn(name="ID_PRODUCTO")
	private Producto producto;
	
}
