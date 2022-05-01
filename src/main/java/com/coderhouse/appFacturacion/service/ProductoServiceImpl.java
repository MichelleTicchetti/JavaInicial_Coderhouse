package com.coderhouse.appFacturacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.appFacturacion.entity.Producto;
import com.coderhouse.appFacturacion.repository.ProductoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	public Producto crearProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	public Producto modificarPrecioProducto(Long id, double precio) {
		Producto productoModificado = productoRepository.getById(id);
		productoModificado.setPrecio(precio);
		return productoRepository.save(productoModificado);

	}

	public void borrarProducto(Long id) {
		Producto producto = productoRepository.getById(id);
		productoRepository.deleteById(id);
		log.info("Se va a borrar el producto {}", producto.getId());
	}

	public Producto obtenerProductoPorNombre(String nombre) {
		return productoRepository.findByNombre(nombre);
	}
	
	public Optional<Producto> obtenerProductoPorId(Long id) throws Exception {
		
		Optional<Producto> producto = productoRepository.findById(id);
		
		if(producto.isPresent()) {
			return productoRepository.findById(id);
		}else {
			throw new Exception("No existe ese producto en la bd");
		}

	
	}

	public List<Producto> obtenerTodosLosProductos() {
		return productoRepository.findAll();
	}

	public Producto restarStock(Long id, int cant) {

		Producto productoModificado = productoRepository.getById(id);

		if (productoModificado.getStock() >= cant) {

			productoModificado.setStock(productoModificado.getStock() - cant);

		} else {

			log.info("No hay suficiente stock. Stock disponible para " + productoModificado.getNombre() + ":"
					+ productoModificado.getStock());
		}
		
		return productoRepository.save(productoModificado);

		
	}

}
