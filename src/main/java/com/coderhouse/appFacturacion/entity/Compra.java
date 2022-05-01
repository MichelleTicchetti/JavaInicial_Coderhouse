package com.coderhouse.appFacturacion.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "COMPRAS")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compra {
	
	@Column(name = "ID_COMPRA")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "La fecha de la compra es obligatoria")
	@Column(name = "FECHA")
	private Date fechaCompra;
	
	@NotBlank(message = "El precio total de la compra es obligatorio")
	@Column(name = "PRECIO_TOTAL")
	private double precioTotal;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;
	
	@OneToMany(mappedBy="compra")
	private Set<Item> items;
	

}
