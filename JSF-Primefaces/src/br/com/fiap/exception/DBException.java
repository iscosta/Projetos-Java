package br.com.fiap.exception;

/**
 * Exception lan�ada pela DAO caso n�o consiga realizar a opera��o
 * @author Thiago Yama
 */
public class DBException extends Exception {

	public DBException(String arg0) {
		super(arg0);
	}

}
