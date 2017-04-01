package br.com.fiap.dao;

public interface GenericDao<T,K> {
	
	public void cadastrar(T objeto);
	
	public void atualizar (T objeto);

	public void excluir (K chave);
	
	public T buscarPorId(K chave);
	
	
	
}
