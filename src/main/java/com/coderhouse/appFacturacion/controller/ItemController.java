package com.coderhouse.appFacturacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

	@GetMapping("/getItemById/{id}")
	public ResponseEntity<Item> getItem(@PathVariable(value = "id") Long itemId) throws Exception {
		Item item = itemService.obtenerItemPorId(itemId);
		return ResponseEntity.ok().body(item);
	}

	@GetMapping("/getItemsList")
	public ResponseEntity<List<Item>> getAllItems() {
		List<Item> itemList = itemService.obtenerTodosLosItems();
		return ResponseEntity.ok().body(itemList);
	}

	@PostMapping("/createItem")
	public ResponseEntity<Item> createItem(@RequestBody Item item) {
		Item nuevoItem = itemService.crearItem(item);
		return ResponseEntity.ok().body(nuevoItem);
	}


	@PutMapping("/updateCantidadItem")
	public void updateCantidadItem(@Param("id") Long id, @Param("cant") int cant) throws Exception {
		itemService.modificarCantidadItemById(id, cant);
		
	}

	@DeleteMapping("/deleteItem/{id}")
	public void deleteItem(@PathVariable(value = "id") Long itemId) throws Exception {
		itemService.borrarItem(itemId);
	}


}
