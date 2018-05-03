package com.mx.examen.middleware.constantes;

public class PatronesValidaciones {
	
	private PatronesValidaciones() {

	}

	public static final String PATTERN_NOMBRE = "^[a-zA-Z\\s]*$";
	public static final String PATTERN_FECHA = "^\\s*(3[01]|[12][0-9]|0?[1-9])\\/(1[012]|0?[1-9])\\/((?:19|20)\\d{2})\\s*$";
	public static final String TIME_ZONE = "America/Mexico_City";

}
