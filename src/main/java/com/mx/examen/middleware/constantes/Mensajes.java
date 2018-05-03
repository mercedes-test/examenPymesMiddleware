package com.mx.examen.middleware.constantes;

public class Mensajes {

	private Mensajes() {	
	}
	
	public static final String EXITO = "Operaci\u00F3n Exitosa.";

	// Constantes de Inicio
	public static final String PERFIL_MICROSERVICIO = "inciando microservicio con perfil={}";
	public static final String AUTOR_MICROSERVICIO = "Examen Mercedes Ramirez.";
	public static final String DESCRIPCION = "Microservicio de examen Mercedes Ramirez - perfiles";

	// Constantes de mensajes Swagger
	public static final String CONSULTA_PERFILES_SWAGGER = "Consulta de perfiles";
	public static final String VALOR_PERFILES_SWAGGER = "consultaPerfiles";
	public static final String LOG_CONSULTA_PERFILES = "-Metodo consulta Perfiles-";
	
	public static final String CONSULTA_PERFILES_PATRON_SWAGGER = "Consulta de perfiles patron Busqueda";
	public static final String VALOR_PERFILES_PATRON_SWAGGER = "consultaPatronPerfiles";
	public static final String LOG_CONSULTA_PATRON_PERFILES = "-Metodo consulta patron Perfiles-";

	public static final String CONSULTA_PERFIL_SWAGGER = "Consulta el perfil de un usuario por id";
	public static final String VALOR_PERFIL_SWAGGER = "consultaPerfil";
	public static final String LOG_CONSULTA_PERFIL = "-Metodo consulta de Perfil-";

	public static final String AGREGA_PERFIL_SWAGGER = "Agrega el perfil a BD Mongo";
	public static final String VALOR_AGREGA_PERFIL_SWAGGER = "agregaPerfil";
	public static final String LOG_AGREGA_PERFIL = "-Metodo agrega  Perfil-";
	
	public static final String ACTUALIZAR_PERFIL_SWAGGER = "Actualizar el perfil a BD Mongo";
	public static final String VALOR_ACTUALIZAR_PERFIL_SWAGGER = "actualizarPerfil";
	public static final String LOG_ACTUAIZAR_PERFIL = "-Metodo Actualizar  Perfil-";


	public static final String ELIMINA_PERFIL_SWAGGER = "Elimina un perfil de la BD Mongo";
	public static final String VALOR_ELIMINA_PERFIL_SWAGGER = "eliminaPerfil";
	public static final String LOG_ELIMINA_PERFIL = "-Metodo para Elimibar Perfil-";

	public static final String VACIO = "";

}
