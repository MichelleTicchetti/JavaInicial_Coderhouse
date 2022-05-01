package com.coderhouse.appFacturacion.service;

import java.util.List;

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

	public Sucursal modificarDireccion(Sucursal sucursal) {
		Sucursal sucursalModificada = sucursalRepository.getById(sucursal.getId());
		sucursalModificada.setDireccion(sucursal.getDireccion());
		return sucursalRepository.save(sucursalModificada);

	}

	public void borrarSucursal(Long id) {
		Sucursal sucursal = sucursalRepository.getById(id);
		sucursalRepository.deleteById(id);
		log.info("Se va a borrar la sucursal {}",sucursal.getNombre());
	}

	public Sucursal obtenerSucursal(Long id) {
		return sucursalRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public List<Sucursal> obtenerTodasLasSucursales() {
		return sucursalRepository.findAll();
	}

	


}
