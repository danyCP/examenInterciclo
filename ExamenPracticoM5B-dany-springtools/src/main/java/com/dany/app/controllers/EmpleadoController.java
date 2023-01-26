package com.dany.app.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dany.app.entities.Empleado;
import com.dany.app.services.EmpleadoService;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

	
	private EmpleadoService empServ;
	
	@PostMapping("/crear")
	public ResponseEntity<?> create (@RequestBody Empleado empleado){
		return ResponseEntity.status(HttpStatus.CREATED).body(empServ.save(empleado));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable (value = "id") Long empleadoId){
		Optional<Empleado> opEmpleado = empServ.findByid(empleadoId);
		if(!opEmpleado.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(opEmpleado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Empleado empleadoDetails, @PathVariable(value = "id") Long emplId){
		Optional<Empleado> empleado = empServ.findByid(emplId);
		
		if(!empleado.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		empleado.get().setApellido(empleadoDetails.getApellido());
		empleado.get().setNombre(empleadoDetails.getNombre());
		empleado.get().setTelefono(empleadoDetails.getTelefono());
		empleado.get().setDireccion(empleadoDetails.getDireccion());
		empleado.get().setCreatat(empleadoDetails.getCreatat());
		empleado.get().setObservacion(empleadoDetails.getObservacion());
		empleado.get().setDias_trabajo(empleadoDetails.getDias_trabajo());
		empleado.get().setSueldo(empleadoDetails.getSueldo());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(empServ.save(empleado.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable (value = "id") Long emplId){
		
		if (!empServ.findByid(emplId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		empServ.deleteById(emplId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Empleado> readAll() {
		
		List<Empleado> empleado = StreamSupport.stream(empServ.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return empleado;
	}
}
