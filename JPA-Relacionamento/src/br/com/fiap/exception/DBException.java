package br.com.fiap.exception;

/**
 * Exception lan�ada pelo DAO caso n�o consiga realizar a opera��o
 * @author Igor Costa rm75095
 *
 */

public class DBException extends Exception{
	
	public DBException(String arg){
		super(arg);
	}

}
