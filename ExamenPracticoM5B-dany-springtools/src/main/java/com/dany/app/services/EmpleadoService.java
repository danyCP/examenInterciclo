package com.dany.app.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dany.app.entities.Empleado;

public interface EmpleadoService {

	public Iterable<Empleado> findAll();
	
	public Page<Empleado> findAll(Pageable pageable);
	
	public Optional<Empleado> findByid(Long id);
	
	public Empleado save(Empleado emleado);
	
	public void deleteById(Long id);
}