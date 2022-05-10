package com.example.demoAPI.estudiante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Capa de controlador que contiene todos los recursos de la API

@RestController //Etiqueta semántica que indica capa controladora para la API REST
@RequestMapping(path = "api/v1/estudiante")
public class EstudianteControlador {
	
	private final EstudianteServicio estudianteServicio;

	@Autowired //forma idónea para instanciar e inyectar al constructor un EstudianteServicio
	public EstudianteControlador(EstudianteServicio estudianteServicio) {
		this.estudianteServicio = estudianteServicio;
		
		/* Debemos evitar hacer esto siempre que sea posible
		 * y utilizar la inyección de dependencias:
		 * 		 
		this.estudianteServicio = new EstudianteServicio();
		*/
	}

		@GetMapping //anotación que sirve para que este método sea restful endpoint
		public List<Estudiante> getEstudiantes() {
			return estudianteServicio.getEstudiantes();
		}
		
		@PostMapping //tomamos el request lo mapeamos en un estudiante
		public void registrarNuevoEstudiante(@RequestBody Estudiante estudiante) {
			estudianteServicio.agregarNuevoEstudiante(estudiante);
		}
		
		@DeleteMapping(path = "{estudianteId}")
		public void borrarEstudiante(@PathVariable("estudianteId") Long estudianteID) {
			estudianteServicio.borrarEstudiante(estudianteID);
		}
		
		@PutMapping(path = "{estudianteId}")
		public void actualizarEstudiante(
				@PathVariable("estudianteId") Long estudianteId,
				@RequestParam(required = false) String nombre,
				@RequestParam(required = false) String email) {
			estudianteServicio.actualizarEstudiante(estudianteId, nombre, email);
		}
}
