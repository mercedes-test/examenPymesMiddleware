package com.mx.examen.middleware.service;

import java.util.List;

import com.mx.examen.middleware.request.PerfilRequest;
import com.mx.examen.middleware.responses.PerfilResponse;

public interface PerfilService {

	public void savePerfil(PerfilRequest perfilRequest);
	
	public List<PerfilResponse> findAllPerfiles();
	
	public PerfilResponse findPerfil(String id);

	public void eliminaPerfil(String id);

}
