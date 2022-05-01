package com.coderhouse.appFacturacion.controller;

import java.util.List;
import java.util.Optional;

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

import com.coderhouse.appFacturacion.entity.Producto;
import com.coderhouse.appFacturacion.service.ProductoService;

import lombok.Data;

@Data
@RestController
public class ProductoController {

	@Autowired
	ProductoService productoService;

	@GetMapping("/getProductoByNombre")
	public ResponseEntity<Producto> getProductoByNombre(@Param("nombre") String nombre) {
		Producto producto = productoService.obtenerProductoPorNombre(nombre);
		return ResponseEntity.ok().body(producto);
	}
	
	@GetMapping("/getProductoById/{id}")
	public ResponseEntity<Optional<Producto>> getProductoById(@PathVariable(value = "id") Long productoId) throws Exception {
		Optional <Producto> producto = productoService.obtenerProductoPorId(productoId);
		return ResponseEntity.ok().body(producto);
	}

	@GetMapping("/getProductos")
	public ResponseEntity<List<Producto>> getAllProductos() {
		List<Producto> productoList = productoService.obtenerTodosLosProductos();
		return ResponseEntity.ok().body(productoList);
	}

	@PostMapping("/createProducto")
	public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
		Producto nuevoProducto = productoService.crearProducto(producto);
		return ResponseEntity.ok().body(nuevoProducto);
	}

	@PutMapping("/updatePrecioProducto")
	public ResponseEntity<Producto> updatePrecioProducto(@Param("id") Long id, @Param("precio") double precio) {
		Producto productoModificado = productoService.modificarPrecioProducto(id, precio);
		return ResponseEntity.ok().body(productoModificado);
	}

	@DeleteMapping("/deleteProducto/{id}")
	public void deleteProducto(@PathVariable(value = "id") Long productoId) {
		productoService.borrarProducto(productoId);
	}

	@PutMapping("/updateStockProducto")
	public ResponseEntity<Producto> restarStockProducto(@Param("id") Long id, @Param("cant") int cant) {
		Producto productoModificado = productoService.restarStock(id, cant);
		return ResponseEntity.ok().body(productoModificado);
	}

}
