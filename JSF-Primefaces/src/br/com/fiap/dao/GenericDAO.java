package br.com.fiap.dao;

import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;

public interface GenericDAO<T,K> {

	public void cadastrar(T entidade) throws DBException;
	
	public void alterar(T entidade) throws DBException;
	
	public T pesquisar(K chave) throws IdNotFoundException;
	
	public void excluir(K chave) throws DBException, IdNotFoundException ;
	
}