package com.coderhouse.appFacturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.appFacturacion.entity.Cliente;
import com.coderhouse.appFacturacion.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	public Cliente findById(int id);
	

}
