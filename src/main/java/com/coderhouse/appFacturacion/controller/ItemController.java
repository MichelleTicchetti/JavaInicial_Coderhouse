package com.coderhouse.appFacturacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.appFacturacion.entity.Item;
import com.coderhouse.appFacturacion.service.ItemService;

import lombok.Data;

@Data
@RestController
public class ItemController {
	
	
	@Autowired
	ItemService itemService;

	@GetMapping("/getItem/{id}")
	public ResponseEntity<Item> getItem(@PathVariable(value = "id") Long itemId) {
		Item item = itemService.obtenerItem(itemId);
		return ResponseEntity.ok().body(item);
	}

	@GetMapping("/items")
	public ResponseEntity<List<Item>> getAllItems() {
		List<Item> itemList = itemService.obtenerTodosLosItems();
		return ResponseEntity.ok().body(itemList);
	}

	@PostMapping("/createItem")
	public ResponseEntity<Item> createItem(@RequestBody Item item) {
		Item nuevoItem = itemService.crearItem(item);
		return ResponseEntity.ok().body(nuevoItem);
	}

	// revisar pasar dato a ser modificado por param
	@PutMapping("/updateCantidadItem")
	public ResponseEntity<Item> updateCantidadItem(@RequestBody Item item) {
		Item itemModificado = itemService.modificarCantidadItem(item);
		return ResponseEntity.ok().body(itemModificado);
	}

	@DeleteMapping("/deleteItem/{id}")
	public void deleteItem(@PathVariable(value = "id") Long itemId) {
		itemService.borrarItem(itemId);
	}


}
