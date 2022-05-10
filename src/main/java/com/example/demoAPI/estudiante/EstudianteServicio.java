package com.example.demoAPI.estudiante;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServicio {
	
	private final EstudianteRepositorio estudianteRepositorio;

	@Autowired
	public EstudianteServicio(EstudianteRepositorio estudianterepositorio) {
		this.estudianteRepositorio = estudianterepositorio;
	}



	//Genera un Json
	public List<Estudiante> getEstudiantes() {
		return estudianteRepositorio.findAll();
	}



	public void agregarNuevoEstudiante(Estudiante estudiante) {
		Optional<Estudiante> estudianteOpcional = 
				estudianteRepositorio.findEstudianteByEmail(estudiante.getEmail());
		if (estudianteOpcional.isPresent()) {
			throw new IllegalStateException("email tomado");
		}
		estudianteRepositorio.save(estudiante);
		
	}



	public void borrarEstudiante(Long estudianteId) {
		boolean existe = estudianteRepositorio.existsById(estudianteId);
		if (!existe) {
			throw new IllegalStateException 
			("Estudiante con id " + estudianteId + " no existe");
		}
		estudianteRepositorio.deleteById(estudianteId);
		
	}

	@Transactional //con esta anotación no hace falta implementar jpql query, permite usar los setters de tu entidad.
	public void actualizarEstudiante(Long estudianteId, String nombre, String email) {
		Estudiante estudiante = estudianteRepositorio.findById(estudianteId).orElseThrow(
				() -> new IllegalStateException("estudiante con id " + estudianteId + " no existe"));
		if (nombre != null && nombre.length() > 0 && !Objects.equals(estudiante.getNombre(), nombre)) {
			estudiante.setNombre(nombre);
		}
		
		if (email != null && email.length() > 0 && !Objects.equals(estudiante.getEmail(), email)) {
			Optional<Estudiante> estudianteOpcional = estudianteRepositorio.findEstudianteByEmail(email);
			if (estudianteOpcional.isPresent()) {
				throw new IllegalStateException("email tomado");
			}
			estudiante.setEmail(email);
		}
		
	}
}
