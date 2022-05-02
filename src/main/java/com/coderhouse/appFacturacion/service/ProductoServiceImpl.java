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

	public void modificarPrecioProducto(Long id, double precio) throws Exception {
		
		Producto productoModificado = obtenerProductoPorId(id);
		
		if(precio > 0) {
			
			productoModificado.setPrecio(precio);
			log.info("Se ha modificado el precio del producto "+productoModificado.getNombre() + " a $" + precio);
			productoRepository.save(productoModificado);
			
		} else {
			
			log.info("No se puede ingresar número negativo");
			
		}
		
	
	}

	public void borrarProducto(Long id) throws Exception  {
		
		Producto producto = obtenerProductoPorId(id);
		productoRepository.deleteById(id);
		log.info("Se va a borrar el producto {}", producto.getNombre());
	}

	public List <Producto> obtenerProductosPorNombre(String nombre){
		
			return productoRepository.findAllByNombre(nombre);
						
	}
		
	public Producto obtenerProductoPorId(Long id) throws Exception {

		Optional <Producto> producto = productoRepository.findById(id);

		if (producto.isPresent()) {
			
			return producto.get();
			
		} else {
			
			throw new Exception("No existe ese producto en la bd");
		}

	}

	public List<Producto> obtenerTodosLosProductos() {
		return productoRepository.findAll();
	}

	public void restarStock(Long id, int cant) throws Exception {

		Optional<Producto> producto = productoRepository.findById(id);

		if (producto.isPresent()) {
			
			Producto productoModificado = producto.get();

			if (cant > 0) {
		

				if (productoModificado.getStock() >= cant) {

					productoModificado.setStock(productoModificado.getStock() - cant);
					productoRepository.save(productoModificado);
					
					
				} else {
					log.info("No hay suficiente stock. Stock disponible para " + productoModificado.getNombre() + ":"
							+ productoModificado.getStock());
				}

			} else {
				
				log.info("No se puede ingresar número negativo");
			}

		} else {

			throw new Exception("No existe ese producto en la bd");
		}

		

	}

	public List<Producto> obtenerProductosPorPlataforma(String plataforma) {
		return productoRepository.findAllByPlataforma(plataforma);
	}

	public List<Producto> obtenerProductosPorCategoria(String categoria) {
		return productoRepository.findAllByCategoria(categoria);
	}


}
