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

import com.coderhouse.appFacturacion.entity.Sucursal;
import com.coderhouse.appFacturacion.service.SucursalService;

import lombok.Data;

@Data
@RestController
public class SucursalController {	

	@Autowired
	SucursalService sucursalService;

	@GetMapping("/getSucursal/{id}")
	public ResponseEntity<Sucursal> getSucursal(@PathVariable(value = "id") Long sucursalId) throws Exception {
		Sucursal sucursal = sucursalService.obtenerSucursalPorId(sucursalId);
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

	@PutMapping("/updateDireccionSucursal")
	public void updateDireccionSucursal(@Param("id") Long id, @Param("direccion") String direccion) throws Exception {
		sucursalService.modificarDireccionById(id, direccion);
	}
	
	@PutMapping("/updateTelefonoSucursal")
	public void updateTelefonoSucursal(@Param("id") Long id, @Param("tel") String tel) throws Exception {
		sucursalService.modificarTelefonoById(id, tel);
	}

	@DeleteMapping("/deleteSucursal/{id}")
	public void deleteSucursal(@PathVariable(value = "id") Long sucursalId) throws Exception {
		sucursalService.borrarSucursal(sucursalId);
	}
	
	

}
