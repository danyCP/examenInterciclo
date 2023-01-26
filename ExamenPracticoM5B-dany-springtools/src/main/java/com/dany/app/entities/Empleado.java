package com.dany.app.entities;

import java.io.Serializable;
import java.util.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length =45, nullable = false)
	private String apellido;
	
	@Column(length =45, nullable = false)
	private String nombre;
	
	@Column(length =15, nullable = false)
	private String telefono;
	
	@Column(length =45, nullable = false)
	private String direccion;
	
	@Column(name="fecha_nac", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date creatat;
	
	@Column(length =45, nullable = false)
	private String observacion;
	
	@Column(nullable = false)
	private Integer dias_trabajo;
	
	@Column(nullable = false)
	private Integer sueldo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getCreatat() {
		return creatat;
	}

	public void setCreatat(Date creatat) {
		this.creatat = creatat;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getDias_trabajo() {
		return dias_trabajo;
	}

	public void setDias_trabajo(Integer dias_trabajo) {
		
		
		this.dias_trabajo = dias_trabajo;
	}

	public Integer getSueldo() {
		return sueldo;
	}

	public void setSueldo  (Integer sueldo) {
		if (dias_trabajo < 20 ) {
			this.sueldo = (dias_trabajo * 15);
		} else if (dias_trabajo >= 20 && dias_trabajo < 30) {
			this.sueldo = (int) ((dias_trabajo * 15) + (sueldo * 0.2));
		} else if (dias_trabajo >= 30) {
			this.sueldo = (int) ((dias_trabajo * 15) + (sueldo * 0.5));
		}
		
	}
	
	
}
