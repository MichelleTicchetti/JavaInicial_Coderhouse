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

import com.coderhouse.appFacturacion.entity.Cliente;
import com.coderhouse.appFacturacion.dto.ClienteDto;
import com.coderhouse.appFacturacion.service.ClienteService;

import lombok.Data;

@Data
@RestController
public class ClienteController {
	@Autowired
	   ClienteService clienteService;

	   @GetMapping("/getCliente/id/{id}")
	   public ResponseEntity<Cliente> getCliente(@PathVariable(value = "id") Long clienteId) {
	       Cliente cliente = clienteService.obtenerCliente(clienteId);
	       return ResponseEntity.ok().body(cliente);
	   }
	   
	   @GetMapping("/getCliente/nombre/{nombre}")
	   public Cliente getClienteByNombre(@PathVariable(value = "nombre") String nombre) {
		   return clienteService.obtenerClientePorNombre(nombre);
	   }


	   @GetMapping("/getClientes")
	   public ResponseEntity<List<Cliente>> getAllClientes() {
	       List<Cliente> clienteList = clienteService.obtenerTodosLosClientes();
	       return ResponseEntity.ok().body(clienteList);
	   }

	   @PostMapping("/createCliente")
	   public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
	       Cliente nuevoCliente = clienteService.crearCliente(cliente);
	       return ResponseEntity.ok().body(nuevoCliente);
	   }

	   @PutMapping("/updateClienteTelefono")
	   public ResponseEntity<Cliente> updateClienteTelefono(@Param("id") Long id, @Param("tel") String tel) {
	       Cliente clienteModificado = clienteService.modificarTelefonoCliente(id, tel);
	       return ResponseEntity.ok().body(clienteModificado);
	   }

	   @DeleteMapping("/deleteCliente/{id}")
	   public void deleteCliente(@PathVariable(value = "id") Long clienteId) {
	        clienteService.borrarCliente(clienteId);
	   }
	   
	   
	   @GetMapping("/getEdadCliente/{id}")
	   public ResponseEntity<ClienteDto> getClienteDto(@PathVariable(value = "id") Long clienteId) {
	      ClienteDto clienteDto = clienteService.obtenerEdadClienteDto(clienteId);
	      return ResponseEntity.ok().body(clienteDto);
	   }



	   

}
