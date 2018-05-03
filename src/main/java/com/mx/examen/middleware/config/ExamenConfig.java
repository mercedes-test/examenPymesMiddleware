package com.mx.examen.middleware.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mx.examen.middleware.constantes.Mensajes;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class ExamenConfig {

	@Profile({ "dev" })
	@EnableSwagger2
	public class Swagger {

		@Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2).select()
					.apis(RequestHandlerSelectors.basePackage("com.mx.examen.middleware.controllers"))
					.paths(PathSelectors.any()).build().useDefaultResponseMessages(false).apiInfo(apiInfo());
		}

		@SuppressWarnings("deprecation")
		private ApiInfo apiInfo() {
			return new ApiInfo(Mensajes.AUTOR_MICROSERVICIO, Mensajes.DESCRIPCION, Mensajes.VACIO, Mensajes.VACIO,
					Mensajes.VACIO, Mensajes.VACIO, Mensajes.VACIO);
		}

		@Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurerAdapter() {
				@Override
				public void addCorsMappings(CorsRegistry registro) {
					registro.addMapping("/perfiles").allowedOrigins("*");
					registro.addMapping("/perfil/{id}").allowedOrigins("*");
					registro.addMapping("/eliminarPerfil/{id}").allowedOrigins("*").allowedMethods("DELETE");
					registro.addMapping("/agregaPerfil").allowedOrigins("*").allowedMethods("POST");
					registro.addMapping("/actualizarPerfil").allowedOrigins("*").allowedMethods("PUT");
				}
			};
		}

	}

}
