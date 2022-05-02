package com.coderhouse.appFacturacion.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "SUCURSALES")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {
	
	@Column(name = "ID_SUCURSAL")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "El nombre de la sucursal es obligatorio")
	@Column(name = "NOMBRE")
	private String nombre;

	@NotBlank(message = "La dirección de la sucursal es obligatoria")
	@Column(name = "DIRECCION")
	private String direccion;
	
	@NotBlank(message = "El teléfono de la sucursal es obligatorio")
	@Column(name = "TELEFONO")
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name="ID_EMPRESA")
	private Empresa empresa;
	
	@ManyToMany
	@JoinTable(name="SUCURSAL_CLIENTES",
	joinColumns=@JoinColumn(name="ID_SUCURSAL"),
	inverseJoinColumns = @JoinColumn(name="ID_CLIENTE"))
	private Set<Cliente>clientes;
	

}
