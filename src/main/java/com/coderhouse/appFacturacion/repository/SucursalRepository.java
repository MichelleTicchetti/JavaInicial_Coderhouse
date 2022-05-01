package com.coderhouse.appFacturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.appFacturacion.entity.Cliente;
import com.coderhouse.appFacturacion.entity.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
	
	public Cliente findById(int id);
	public Cliente findByNombre(String nombre);
	public Cliente findByDireccion(String direccion);
	public Cliente findByTelefono(String telefono);

}
