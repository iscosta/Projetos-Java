package br.com.fiap.exception;

/**
 * Exception lançada pelo DAO caso não consiga realizar a operação
 * @author Igor Costa rm75095
 *
 */

public class DBException extends Exception{
	
	public DBException(String arg){
		super(arg);
	}

}
