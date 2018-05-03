package com.mx.examen.middleware.utilerias;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Utilerias {

	public static <T> List<T> obtenInformacion(List<T> lista, Predicate<T> predicate) {
		List<T> resultados = new ArrayList<>();
		for (T t : lista) {
			if (predicate.test(t)) {
				resultados.add(t);
			}
		}
		return resultados;
	}

}
