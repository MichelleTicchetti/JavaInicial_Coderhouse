package com.coderhouse.appFacturacion.service;

import java.util.List;

import com.coderhouse.appFacturacion.entity.Item;

public interface ItemService {
	
	Item crearItem(Item item);

	Item modificarCantidadItem(Item item);

	void borrarItem(Long id);

	Item obtenerItem(Long id);

	List<Item> obtenerTodosLosItems();


}
