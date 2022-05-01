package com.coderhouse.appFacturacion.service;

import java.util.List;
import java.util.Optional;

import com.coderhouse.appFacturacion.entity.Producto;

public interface ProductoService {
	
	Producto crearProducto(Producto producto);

	Producto modificarPrecioProducto(Long id, double precio);

	void borrarProducto(Long id);
	
	Producto obtenerProductoPorNombre(String nombre);
	
	Optional<Producto> obtenerProductoPorId(Long id) throws Exception;

	List<Producto> obtenerTodosLosProductos();
	
	Producto restarStock(Long id, int cant);


}
