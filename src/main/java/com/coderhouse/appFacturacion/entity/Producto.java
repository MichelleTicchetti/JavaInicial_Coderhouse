package com.coderhouse.appFacturacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "PRODUCTOS")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
	
	@Column(name = "ID_PRODUCTO")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El nombre del producto es obligatorio")
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@NotBlank(message = "La plataforma es obligatoria")
	@Column(name = "PLATAFORMA")
	private String plataforma;	
		

	@Min(1)
	@Column(name = "PRECIO_UNITARIO")
	private double precio;
	
	
	@NotBlank(message = "La categoria del producto es obligatoria")
	@Column(name = "CATEGORIA")
	private String categoria;
	

	@Min(0)
	@Column(name = "STOCK")
	private int stock;

}
