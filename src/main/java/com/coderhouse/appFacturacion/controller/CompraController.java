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

import com.coderhouse.appFacturacion.entity.Compra;
import com.coderhouse.appFacturacion.service.CompraService;

import lombok.Data;

@Data
@RestController
public class CompraController {
	
	@Autowired
	   CompraService compraService;

	   @GetMapping("/getCompra/id/{id}")
	   public ResponseEntity<Compra> getCompra(@PathVariable(value = "id") Long compraId) {
	       Compra compra = compraService.obtenerCompra(compraId);
	       return ResponseEntity.ok().body(compra);
	   }


	   @GetMapping("/getCompras")
	   public ResponseEntity<List<Compra>> getAllCompras() {
	       List<Compra> compraList = compraService.obtenerTodasLasCompras();
	       return ResponseEntity.ok().body(compraList);
	   }

	   @PostMapping("/createCompra")
	   public ResponseEntity<Compra> createCompra(@RequestBody Compra compra) {
		   Compra nuevaCompra = compraService.crearCompra(compra);
	       return ResponseEntity.ok().body(nuevaCompra);
	   }

	 //revisar pasar dato a ser modificado por param
	   @PutMapping("/updateTotalCompra")
	   public ResponseEntity<Compra> updateTotalCompra(@RequestBody Compra compra) {
		   Compra compraModificada = compraService.modificarTotalCompra(compra);
	       return ResponseEntity.ok().body(compraModificada);
	   }

	   @DeleteMapping("/deleteCompra/{id}")
	   public void deleteCompra(@PathVariable(value = "id") Long compraId) {
		   compraService.borrarCompra(compraId);
	   }
	   
	  



}
