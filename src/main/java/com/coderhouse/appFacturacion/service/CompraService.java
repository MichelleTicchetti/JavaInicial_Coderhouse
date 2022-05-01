package com.coderhouse.appFacturacion.service;

import java.util.List;

import com.coderhouse.appFacturacion.entity.Compra;

public interface CompraService {
	
	Compra crearCompra(Compra compra);

	Compra modificarTotalCompra(Compra compra);

	void borrarCompra(Long id);

	Compra obtenerCompra(Long id);

	List<Compra> obtenerTodasLasCompras();


}
