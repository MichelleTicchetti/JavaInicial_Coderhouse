package com.coderhouse.appFacturacion.service;

import java.util.List;

import com.coderhouse.appFacturacion.entity.Sucursal;

public interface SucursalService {
	
	Sucursal crearSucursal(Sucursal sucursal);

	void modificarDireccionById(Long id, String nuevaDireccion) throws Exception;
	
	void modificarTelefonoById(Long id, String nuevoTelefono) throws Exception;

	void borrarSucursal(Long id) throws Exception;

	Sucursal obtenerSucursalPorId(Long id) throws Exception;

	List<Sucursal> obtenerTodasLasSucursales();


}
