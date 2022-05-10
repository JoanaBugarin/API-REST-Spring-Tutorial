package com.example.demoAPI.estudiante;

import static java.time.Month.*;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //será un archivo de configuración
public class EstudianteConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(
			EstudianteRepositorio repositorio) {
		return args -> {
			Estudiante mariam = new Estudiante(					
					"Mariam",
					"mariam.jamal@gmail.com",
					LocalDate.of(2000, JANUARY, 5)
					);
			Estudiante alex = new Estudiante(
					"Alex",
					"alex@gmail.com",
					LocalDate.of(2004, DECEMBER, 5)					
					);
			repositorio.saveAll(List.of(mariam, alex));
		};
	}

}
