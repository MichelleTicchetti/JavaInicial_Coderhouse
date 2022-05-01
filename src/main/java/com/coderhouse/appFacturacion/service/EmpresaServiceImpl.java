package com.coderhouse.appFacturacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.appFacturacion.entity.Empresa;
import com.coderhouse.appFacturacion.repository.EmpresaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmpresaServiceImpl implements EmpresaService{
	
	@Autowired
	EmpresaRepository empresaRepository;

	public Empresa crearEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public Empresa modificarRazonSocial(Empresa empresa) {
		Empresa empresaModificada = empresaRepository.getById(empresa.getId());
		empresaModificada.setRazonSocial(empresa.getRazonSocial());
		return empresaRepository.save(empresaModificada);

	}

	public void borrarEmpresa(Long id) {
		Empresa empresa = empresaRepository.getById(id);
		empresaRepository.deleteById(id);
		log.info("Se va a borrar la empresa {}",empresa.getRazonSocial());
	}

	public Empresa obtenerEmpresa(Long id) {
		return empresaRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public List<Empresa> obtenerTodasLasEmpresas() {
		return empresaRepository.findAll();
	}


	

}
