package com.mx.examen.middleware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.mx.examen.middleware.constantes.Mensajes;

/**
 * @author Mercedes Ramirez Sanchez
 */
@SpringBootApplication
@ComponentScan("com.mx.examen.middleware")
public class ExamenApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExamenApplication.class);

	@Value("${examen.pymes.perfiles.nombre}")
	private String perfilAplicativo;

	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		LOGGER.info(Mensajes.PERFIL_MICROSERVICIO, perfilAplicativo);
	}
}
