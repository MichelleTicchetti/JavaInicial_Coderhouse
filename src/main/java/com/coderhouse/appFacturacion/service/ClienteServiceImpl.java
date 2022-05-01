package com.coderhouse.appFacturacion.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.appFacturacion.entity.Cliente;
import com.coderhouse.appFacturacion.dto.ClienteDto;
import com.coderhouse.appFacturacion.repository.ClienteRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public Cliente crearCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente modificarTelefonoCliente(Long id, String tel) {
		Cliente clienteModificado = clienteRepository.getById(id);
		clienteModificado.setTelefono(tel);
		return clienteRepository.save(clienteModificado);

	}

	public void borrarCliente(Long id) {
		Cliente cliente = clienteRepository.getById(id);
		log.info("Se va a borrar el cliente {}", cliente.getNombre());
		clienteRepository.deleteById(id);
	}

	public Cliente obtenerCliente(Long id) {
		return clienteRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public List<Cliente> obtenerTodosLosClientes() {
		return clienteRepository.findAll();
	}

	public ClienteDto obtenerEdadClienteDto(Long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(RuntimeException::new);

		LocalDate fechaNacimiento = cliente.getFechaNacimiento();

		LocalDate hoy = LocalDate.now();

		Period periodo = Period.between(fechaNacimiento, hoy);

		int edad = periodo.getYears();

		return new ClienteDto(cliente.getNombre(), cliente.getApellido(), cliente.getFechaNacimiento(), edad);
	}

	public Cliente obtenerClientePorNombre(String nombre) {
		return clienteRepository.findByNombre(nombre);

	}

}
