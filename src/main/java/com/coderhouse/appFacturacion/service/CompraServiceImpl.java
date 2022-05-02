package com.coderhouse.appFacturacion.service;

import java.util.List;
import java.util.Optional;

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

	public void modificarTotalCompraById(Long id, double total) throws Exception {
		
		Compra compraModificada = obtenerCompraById(id);
		
		compraModificada.setPrecioTotal(total);
		
		compraRepository.save(compraModificada);

	}

	public void borrarCompra(Long id) {
		Compra compra = compraRepository.getById(id);
		compraRepository.deleteById(id);
		log.info("Se va a borrar la compra {}",compra.getId());
	}

	public Compra obtenerCompraById(Long id) throws Exception {
		Optional <Compra> compra = compraRepository.findById(id);

		if (compra.isPresent()) {
			
			return compra.get();
			
		} else {
			
			throw new Exception("No existe esa compra en la bd");
		}
	}

	public List<Compra> obtenerTodasLasCompras() {
		return compraRepository.findAll();
	}


	

}
