package com.coderhouse.appFacturacion.service;

import java.util.List;

import com.coderhouse.appFacturacion.entity.Cliente;
import com.coderhouse.appFacturacion.dto.ClienteDto;

public interface ClienteService {

	Cliente crearCliente(Cliente cliente);

	void modificarTelefonoCliente(Long id, String tel) throws Exception;

	void borrarCliente(Long id) throws Exception;

	Cliente obtenerClientePorId(Long id) throws Exception;
	
	Cliente obtenerClientePorNombre(String nombre);

	List<Cliente> obtenerTodosLosClientes();

	ClienteDto obtenerEdadClienteDto(Long id);

}
