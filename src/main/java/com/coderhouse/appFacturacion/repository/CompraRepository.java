package com.coderhouse.appFacturacion.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.appFacturacion.entity.Cliente;
import com.coderhouse.appFacturacion.entity.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>  {
	
	public Cliente findByFechaCompra(Date fecha);
	public Cliente findById(int id);


}
