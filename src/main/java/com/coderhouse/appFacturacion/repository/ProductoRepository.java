package com.coderhouse.appFacturacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.appFacturacion.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	public Producto findById(int id);
	public List<Producto> findAll();
	public Producto findByNombre(String nombre);
	public Producto findByPlataforma(String plataforma);
	public Producto findByPrecio(double precio);
	public Producto findByCategoria(String categoria);
	public Producto findByStock(int stock);

}
