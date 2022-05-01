package com.coderhouse.appFacturacion.service;

import java.util.List;

import com.coderhouse.appFacturacion.entity.Sucursal;

public interface SucursalService {
	
	Sucursal crearSucursal(Sucursal sucursal);

	Sucursal modificarDireccion(Sucursal sucursal);

	void borrarSucursal(Long id);

	Sucursal obtenerSucursal(Long id);

	List<Sucursal> obtenerTodasLasSucursales();


}
