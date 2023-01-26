package com.dany.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.dany.app.entities.Empleado;
import com.dany.app.repositories.EmpleadoRepository;



public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	private EmpleadoRepository emplRepo;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Empleado> findAll() {
		
		return emplRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Empleado> findAll(Pageable pageable) {
		
		return emplRepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Empleado> findByid(Long id) {
		
		return emplRepo.findById(id);
	}

	@Override
	@Transactional
	public Empleado save(Empleado emleado) {
		
		return emplRepo.save(emleado);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		emplRepo.deleteById(id);
		
	}

}
