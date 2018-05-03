package com.mx.examen.middleware.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.examen.middleware.repocitory.PerfilRepository;
import com.mx.examen.middleware.request.PerfilRequest;
import com.mx.examen.middleware.responses.PerfilResponse;
import com.mx.examen.middleware.responses.PerfilesResponse;

@Service("perfilService")
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;

	@Override
	public void savePerfil(PerfilRequest perfilRequest) {
		perfilRepository.save(perfilRequest);
	}

	@Override
	public void eliminaPerfil(String id) {
		perfilRepository.delete(id);
	}

	@Override
	public List<PerfilResponse> findAllPerfiles() {
		PerfilesResponse perfilesResponse = new PerfilesResponse();

		List<PerfilResponse> listaRespose = new ArrayList<>();

		for (PerfilRequest perfilRequest : perfilRepository.findAll()) {
			PerfilResponse perfilResponse = new PerfilResponse();
			perfilResponse.setId(perfilRequest.getId());
			perfilResponse.setNombre(perfilRequest.getNombre());
			perfilResponse.setApellidoMaterno(perfilRequest.getApellidoMaterno());
			perfilResponse.setApellidoPaterno(perfilRequest.getApellidoPaterno());
			perfilResponse.setFechaNacimiento(perfilRequest.getFechaNacimiento());
			perfilResponse.setFoto(perfilRequest.getFoto());
			perfilResponse.setEdad(perfilRequest.getEdad());

			listaRespose.add(perfilResponse);
		}

		perfilesResponse.setListPerfilesResponse(listaRespose);

		return perfilesResponse.getListPerfilesResponse();
	}

	@Override
	public PerfilResponse findPerfil(String id) {

		PerfilRequest perfilRequest = perfilRepository.findOne(id);

		PerfilResponse perfilResponse = new PerfilResponse();
		perfilResponse.setId(perfilRequest.getId());
		perfilResponse.setNombre(perfilRequest.getNombre());
		perfilResponse.setFoto(perfilRequest.getFoto());
		perfilResponse.setApellidoMaterno(perfilRequest.getApellidoMaterno());
		perfilResponse.setApellidoPaterno(perfilRequest.getApellidoPaterno());
		perfilResponse.setEdad(perfilRequest.getEdad());
		perfilResponse.setFechaNacimiento(perfilRequest.getFechaNacimiento());

		return perfilResponse;
	}

}
