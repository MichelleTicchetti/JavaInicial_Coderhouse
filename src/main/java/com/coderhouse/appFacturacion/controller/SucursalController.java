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

import com.coderhouse.appFacturacion.entity.Sucursal;
import com.coderhouse.appFacturacion.service.SucursalService;

import lombok.Data;

@Data
@RestController
public class SucursalController {	

	@Autowired
	SucursalService sucursalService;

	@GetMapping("/getSucursal/{id}")
	public ResponseEntity<Sucursal> getSucursal(@PathVariable(value = "id") Long sucursalId) {
		Sucursal sucursal = sucursalService.obtenerSucursal(sucursalId);
		return ResponseEntity.ok().body(sucursal);
	}

	@GetMapping("/getSucursales")
	public ResponseEntity<List<Sucursal>> getAllSucursales() {
		List<Sucursal> sucursalList = sucursalService.obtenerTodasLasSucursales();
		return ResponseEntity.ok().body(sucursalList);
	}

	@PostMapping("/createSucursal")
	public ResponseEntity<Sucursal> createSucursal(@RequestBody Sucursal sucursal) {
		Sucursal nuevaSucursal = sucursalService.crearSucursal(sucursal);
		return ResponseEntity.ok().body(nuevaSucursal);
	}

	   //revisar pasar dato a ser modificado por param
	@PutMapping("/updateDireccionSucursal")
	public ResponseEntity<Sucursal> updateDireccionSucursal(@RequestBody Sucursal sucursal) {
		Sucursal sucursalModificada = sucursalService.modificarDireccion(sucursal);
		return ResponseEntity.ok().body(sucursalModificada);
	}

	@DeleteMapping("/deleteSucursal/{id}")
	public void deleteSucursal(@PathVariable(value = "id") Long sucursalId) {
		sucursalService.borrarSucursal(sucursalId);
	}
	
	

}
