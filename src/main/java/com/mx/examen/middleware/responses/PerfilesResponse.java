package com.mx.examen.middleware.responses;

import java.io.Serializable;
import java.util.List;

public class PerfilesResponse implements Serializable, Response {

	private static final long serialVersionUID = -5622499111207855189L;
	private List<PerfilResponse> listPerfilesResponse;

	public List<PerfilResponse> getListPerfilesResponse() {
		return listPerfilesResponse;
	}

	public void setListPerfilesResponse(List<PerfilResponse> listPerfilesResponse) {
		this.listPerfilesResponse = listPerfilesResponse;
	}

}
