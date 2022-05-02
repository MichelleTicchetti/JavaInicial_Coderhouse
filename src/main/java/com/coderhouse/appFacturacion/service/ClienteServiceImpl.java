package com.coderhouse.appFacturacion.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

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

	public void modificarTelefonoCliente(Long id, String tel) throws Exception {
		
		Cliente clienteModificado = obtenerClientePorId(id);
		
		if(Pattern.matches("^[0-9]{2,3}[0-9]{4}[0-9]{4}$", tel)) {
			clienteModificado.setTelefono(tel);
			log.info("Se ha modificado el telefono de " + clienteModificado.getApellido().toUpperCase()+ ", " + clienteModificado.getNombre());
			clienteRepository.save(clienteModificado);
		}else {
			
			throw new Exception("El formato de teléfono no es valido. No debe contener espacios ni carácteres especiales.");
		}
		
		

	}

	public void borrarCliente(Long id) throws Exception {
		Cliente cliente = obtenerClientePorId(id);
		log.info("Se va a borrar el cliente {}", cliente.getApellido().toUpperCase()+", "+cliente.getNombre());
		clienteRepository.deleteById(id);
	}

	public Cliente obtenerClientePorId(Long id) throws Exception {
		
		Optional <Cliente> cliente = clienteRepository.findById(id);

		if (cliente.isPresent()) {
			
			return cliente.get();
			
		} else {
			
			throw new Exception("No existe ese cliente en la bd");
		}

		
	}

	public List<Cliente> obtenerTodosLosClientes() {
		return clienteRepository.findAll();
	}

	public ClienteDto obtenerEdadClienteDto(Long id) throws Exception {
		
		Cliente cliente = obtenerClientePorId(id);

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
