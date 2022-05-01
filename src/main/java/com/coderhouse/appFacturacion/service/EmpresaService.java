package com.coderhouse.appFacturacion.service;

import java.util.List;

import com.coderhouse.appFacturacion.entity.Empresa;

public interface EmpresaService {

	Empresa crearEmpresa(Empresa empresa);

	Empresa modificarRazonSocial(Empresa empresa);

	void borrarEmpresa(Long id);

	Empresa obtenerEmpresa(Long id);

	List<Empresa> obtenerTodasLasEmpresas();


}
