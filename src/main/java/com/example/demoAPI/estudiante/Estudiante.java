package com.example.demoAPI.estudiante;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

//Las siguientes etiquetas son para hibernate y tabla Estudiante en bd.
@Entity
@Table
public class Estudiante {

	@Id
	@SequenceGenerator(
			name = "estudiante_secuencia",
			sequenceName = "estudiante_secuencia",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "estudiante_secuencia"
	)
	private Long id;
	private String nombre;
	private String email;
	private LocalDate fdn;
	@Transient //indica que edad no necesita una columna en la bd (xq la calculamos)
	private Integer edad;
	
	public Estudiante() {
	}

	public Estudiante(Long id, String nombre, String email, LocalDate fdn) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.fdn = fdn;
	}

	public Estudiante(String nombre, String email, LocalDate fdn) {
		this.nombre = nombre;
		this.email = email;
		this.fdn = fdn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFdn() {
		return fdn;
	}

	public void setFdn(LocalDate fdn) {
		this.fdn = fdn;
	}

	//Calcula la edad
	public Integer getEdad() {
		return Period.between(this.fdn, LocalDate.now()).getYears();
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", email=" + email + ", fdn=" + fdn + ", edad=" + edad
				+ "]";
	}
	
	

}
