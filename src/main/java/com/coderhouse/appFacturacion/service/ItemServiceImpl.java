package com.coderhouse.appFacturacion.service;

import java.util.List;

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

	public Item modificarCantidadItem(Item item) {
		Item itemModificado = itemRepository.getById(item.getId());
		itemModificado.setCantidad(item.getCantidad());
		return itemRepository.save(itemModificado);

	}

	public void borrarItem(Long id) {
		Item item = itemRepository.getById(id);
		itemRepository.deleteById(id);
		log.info("Se va a borrar el item {}",item.getId());
	}

	public Item obtenerItem(Long id) {
		return itemRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public List<Item> obtenerTodosLosItems() {
		return itemRepository.findAll();
	}


}
