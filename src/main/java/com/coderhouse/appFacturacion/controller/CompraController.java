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

import com.coderhouse.appFacturacion.entity.Compra;
import com.coderhouse.appFacturacion.service.CompraService;

import lombok.Data;

@Data
@RestController
public class CompraController {
	
	@Autowired
	   CompraService compraService;

	   @GetMapping("/getCompra/{id}")
	   public ResponseEntity<Compra> getCompra(@PathVariable(value = "id") Long compraId) throws Exception {
	       Compra compra = compraService.obtenerCompraById(compraId);
	       return ResponseEntity.ok().body(compra);
	   }


	   @GetMapping("/getComprasList")
	   public ResponseEntity<List<Compra>> getAllCompras() {
	       List<Compra> compraList = compraService.obtenerTodasLasCompras();
	       return ResponseEntity.ok().body(compraList);
	   }

	   @PostMapping("/createCompra")
	   public ResponseEntity<Compra> createCompra(@RequestBody Compra compra) {
		   Compra nuevaCompra = compraService.crearCompra(compra);
	       return ResponseEntity.ok().body(nuevaCompra);
	   }

	   @PutMapping("/updateTotalCompraById")
	   public void updateTotalCompra(@Param("id") Long id, @Param("total") double total) throws Exception {
		  compraService.modificarTotalCompraById(id, total);
	       
	   }

	   @DeleteMapping("/deleteCompraById/{id}")
	   public void deleteCompra(@PathVariable(value = "id") Long compraId) {
		   compraService.borrarCompra(compraId);
	   }
	   
	  



}
