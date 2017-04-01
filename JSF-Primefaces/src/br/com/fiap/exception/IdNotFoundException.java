package br.com.fiap.exception;

/**
 * Exception que ser� lan�ada caso o Id n�o seja encontrado no BD
 * @author Thiago Yama
 */
public class IdNotFoundException extends Exception {

	public IdNotFoundException(String arg) {
		super(arg);
	}
	
}
