package com.coderhouse.appFacturacion.service;

import java.util.List;

import com.coderhouse.appFacturacion.entity.Cliente;
import com.coderhouse.appFacturacion.dto.ClienteDto;

public interface ClienteService {

	Cliente crearCliente(Cliente cliente);

	Cliente modificarTelefonoCliente(Long id, String tel);

	void borrarCliente(Long id);

	Cliente obtenerCliente(Long id);
	
	Cliente obtenerClientePorNombre(String nombre);

	List<Cliente> obtenerTodosLosClientes();

	ClienteDto obtenerEdadClienteDto(Long id);

}
