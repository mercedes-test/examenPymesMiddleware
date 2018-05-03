package com.mx.examen.middleware.responses;

public class ResponseWrapper implements Response {

	private int codigoOperacion;
	private String mensaje;
	private Response data;

	public int getCodigoOperacion() {
		return codigoOperacion;
	}

	public void setCodigoOperacion(int codigoOperacion) {
		this.codigoOperacion = codigoOperacion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Response getData() {
		return data;
	}

	public void setData(Response data) {
		this.data = data;
	}

}
