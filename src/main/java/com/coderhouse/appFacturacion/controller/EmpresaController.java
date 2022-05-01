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

import com.coderhouse.appFacturacion.entity.Empresa;
import com.coderhouse.appFacturacion.service.EmpresaService;

import lombok.Data;

@Data
@RestController
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;

	@GetMapping("/getEmpresa/id/{id}")
	public ResponseEntity<Empresa> getEmpresa(@PathVariable(value = "id") Long empresaId) {
		Empresa empresa = empresaService.obtenerEmpresa(empresaId);
		return ResponseEntity.ok().body(empresa);
	}

	@GetMapping("/getEmpresas")
	public ResponseEntity<List<Empresa>> getAllEmpresas() {
		List<Empresa> empresaList = empresaService.obtenerTodasLasEmpresas();
		return ResponseEntity.ok().body(empresaList);
	}

	@PostMapping("/createEmpresa")
	public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa) {
		Empresa nuevaEmpresa = empresaService.crearEmpresa(empresa);
		return ResponseEntity.ok().body(nuevaEmpresa);
	}

	//revisar pasar dato a ser modificado por param
	@PutMapping("/updateEmpresaRazonSocial")
	public ResponseEntity<Empresa> updateEmpresaRazonSocial(@RequestBody Empresa empresa) {
		Empresa empresaModificada = empresaService.modificarRazonSocial(empresa);
		return ResponseEntity.ok().body(empresaModificada);
	}

	@DeleteMapping("/deleteEmpresa/{id}")
	public void deleteEmpresa(@PathVariable(value = "id") Long empresaId) {
		empresaService.borrarEmpresa(empresaId);
	}

}
