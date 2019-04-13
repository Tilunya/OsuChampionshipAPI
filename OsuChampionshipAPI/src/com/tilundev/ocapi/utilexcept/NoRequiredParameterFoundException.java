package com.tilundev.ocapi.utilexcept;

public class NoRequiredParameterFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8441437209804856403L;
	
	public NoRequiredParameterFoundException() {
		super();
	}
	
	public NoRequiredParameterFoundException(String message) {
		super(message);
	}
}
