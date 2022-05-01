package com.coderhouse.appFacturacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.appFacturacion.entity.Compra;
import com.coderhouse.appFacturacion.repository.CompraRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompraServiceImpl implements CompraService{
	

	@Autowired
	CompraRepository compraRepository;

	public Compra crearCompra(Compra compra) {
		return compraRepository.save(compra);
	}

	public Compra modificarTotalCompra(Compra compra) {
		Compra compraModificada = compraRepository.getById(compra.getId());
		compraModificada.setPrecioTotal(compra.getPrecioTotal());
		return compraRepository.save(compraModificada);

	}

	public void borrarCompra(Long id) {
		Compra compra = compraRepository.getById(id);
		compraRepository.deleteById(id);
		log.info("Se va a borrar la compra {}",compra.getId());
	}

	public Compra obtenerCompra(Long id) {
		return compraRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public List<Compra> obtenerTodasLasCompras() {
		return compraRepository.findAll();
	}

	

}
