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

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "FECHA")
	private Date fechaCompra;
	
	@Min(0)
	@Column(name = "PRECIO_TOTAL")
	@NotNull
	private double precioTotal;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;
	
	@OneToMany(mappedBy="compra")
	private Set<Item> items;
	

}
