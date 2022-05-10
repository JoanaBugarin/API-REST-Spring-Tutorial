package com.example.demoAPI.estudiante;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //responsable del acceso a datos
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long>{
	
	/*
	 * Otras opciones:
	 * @Query("SELECT s FROM Estudiante s WHERE s.email = ?1")
	 * SELECT * FROM estudiante WHERE email = ?
	 * 
	 * Se puede personalizar los metodos find de las clase repositorio, manteniendo
	 * el findEstudianteBy y el atributo por el que queramos buscar en bd.
	 */
	Optional<Estudiante> findEstudianteByEmail(String email);

}
