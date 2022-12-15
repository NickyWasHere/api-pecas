package br.com.mesttra.pecasapi.exception;

public class ErroDeNegocioException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ErroDeNegocioException(String message) {
		super(message);
	}

}
