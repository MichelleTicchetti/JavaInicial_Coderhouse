package com.coderhouse.appFacturacion.service;

import java.util.List;

import com.coderhouse.appFacturacion.entity.Compra;

public interface CompraService {
	
	Compra crearCompra(Compra compra);

	void modificarTotalCompraById(Long id, double total) throws Exception;

	void borrarCompra(Long id);

	Compra obtenerCompraById(Long id) throws Exception;

	List<Compra> obtenerTodasLasCompras();


}
