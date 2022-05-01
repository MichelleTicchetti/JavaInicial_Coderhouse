package com.coderhouse.appFacturacion.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "EMPRESA")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {
	
	@Column(name = "ID_EMPRESA")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "La razón social de la empresa es obligatoria")
	@Column(name = "RAZON_SOCIAL")
	private String razonSocial;
	
	@NotBlank(message = "El rubo de la empresa es obligatorio")
	@Column(name = "RUBRO")
	private String rubro;

	@NotBlank(message = "El cuit de la empresa es obligatorio")
	@Column(name = "CUIT")
	private String cuit;
	
	@OneToMany(mappedBy="empresa")
	private Set<Sucursal> sucursales;

	public Long getId() {
		return id;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public String getCuit() {
		return cuit;
	}

	public Set<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public void setSucursales(Set<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	
	
	
	
}
