package com.coderhouse.appFacturacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.coderhouse.appFacturacion.entity.Item;
import com.coderhouse.appFacturacion.repository.ItemRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
	

	@Autowired
	ItemRepository itemRepository;

	public Item crearItem(Item item) {
		return itemRepository.save(item);
	}

	public void modificarCantidadItemById(Long id, int cant) throws Exception {
		Item itemModificado = obtenerItemPorId(id);
		itemModificado.setCantidad(cant);
		itemRepository.save(itemModificado);

	}

	public void borrarItem(Long id) throws Exception {
		Item item = obtenerItemPorId(id);
		itemRepository.deleteById(id);
		log.info("Se va a borrar el item {}",item.getId());
	}

	public Item obtenerItemPorId(Long id) throws Exception {
		
		Optional <Item> item = itemRepository.findById(id);

		if (item.isPresent()) {
			
			return item.get();
			
		} else {
			
			throw new Exception("No existe ese item de compra en la bd");
		}

		
	}

	public List<Item> obtenerTodosLosItems() {
		return itemRepository.findAll();
	}


}
