package com.coderhouse.appFacturacion.service;

import java.util.List;

import com.coderhouse.appFacturacion.entity.Item;

public interface ItemService {
	
	Item crearItem(Item item);

	void modificarCantidadItemById(Long id, int cant) throws Exception;

	void borrarItem(Long id) throws Exception;

	Item obtenerItemPorId(Long id) throws Exception;

	List<Item> obtenerTodosLosItems();


}
