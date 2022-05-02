package com.coderhouse.appFacturacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.appFacturacion.entity.Sucursal;
import com.coderhouse.appFacturacion.repository.SucursalRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SucursalServiceImpl implements SucursalService {

	@Autowired
	SucursalRepository sucursalRepository;

	public Sucursal crearSucursal(Sucursal sucursal) {
		return sucursalRepository.save(sucursal);
	}

	public void modificarDireccionById(Long id, String nuevaDireccion) throws Exception {
		Sucursal sucursalModificada = obtenerSucursalPorId(id);
		sucursalModificada.setDireccion(nuevaDireccion);
		sucursalRepository.save(sucursalModificada);

	}

	
	public void modificarTelefonoById(Long id, String nuevoTel) throws Exception {
		Sucursal sucursalModificada = obtenerSucursalPorId(id);
		sucursalModificada.setTelefono(nuevoTel);
		sucursalRepository.save(sucursalModificada);

	}
	
	public void borrarSucursal(Long id) throws Exception {
		Sucursal sucursal = obtenerSucursalPorId(id);
		sucursalRepository.deleteById(id);
		log.info("Se va a borrar la sucursal {}", sucursal.getNombre());
	}

	public Sucursal obtenerSucursalPorId(Long id) throws Exception {

		Optional<Sucursal> sucursal = sucursalRepository.findById(id);

		if (sucursal.isPresent()) {

			return sucursal.get();

		} else {

			throw new Exception("No existe esa sucursal en la bd");
		}
	}

	public List<Sucursal> obtenerTodasLasSucursales() {
		return sucursalRepository.findAll();
	}

}
