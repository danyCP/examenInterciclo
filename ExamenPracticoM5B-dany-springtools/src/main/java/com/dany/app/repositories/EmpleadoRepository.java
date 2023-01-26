package com.dany.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dany.app.entities.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
