package com.mx.examen.middleware.constantes;

public class Codigos {
	
	private Codigos() {
		
	}
	
	public static int EXITO;

	public static final String RESPUESTA_SUCCESS = "Succes";
	public static final String RESPUESTA_UNAUTHORIZED = "Unauthorized";
	public static final String RESPUESTA_FORBIDDEN = "Forbidden";
	public static final String RESPUESTA_NOT_FOUND = "Not Found";
	public static final String RESPUESTA_FAILURE = "Failure";

	public static final int CODIGO_SUCCESS = 200;
	public static final int CODIGO_UNAUTHORIZED = 401;
	public static final int CODIGO_FORBIDDEN = 403;
	public static final int CODIGO_NOT_FOUND = 404;
	public static final int CODIGO_FAILURE = 500;
}
