package com.mx.examen.middleware.repocitory;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mx.examen.middleware.request.PerfilRequest;

public interface PerfilRepository extends MongoRepository<PerfilRequest, String> {
	
}
