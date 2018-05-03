package com.mx.examen.middleware.responses;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.examen.middleware.exeptions.JsonProcesingException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface Response {

	static final ObjectMapper OM = new ObjectMapper();

	public default String toJsonString() {
		try {
			return OM.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new JsonProcesingException(e);
		}
	}

}
