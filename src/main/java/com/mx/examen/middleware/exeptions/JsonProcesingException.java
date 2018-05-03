package com.mx.examen.middleware.exeptions;

public class JsonProcesingException extends RuntimeException {

	private static final long serialVersionUID = -1634887589662391714L;

	public JsonProcesingException() {
	}

	public JsonProcesingException(Exception e) {
		super(e);
	}

	public JsonProcesingException(String msg, Exception e) {
		super(msg, e);
	}

}
