package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	protected EntityManager em;
	
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void cadastrar(T entidade) throws DBException {
		try{
			em.getTransaction().begin();
			em.persist(entidade);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			if (em.getTransaction().isActive()){ 
				em.getTransaction().rollback();
			}
			throw new DBException("Cadastro n�o realizado");
		}
	}

	@Override
	public void alterar(T entidade) throws DBException {
		try{
			em.getTransaction().begin();
			em.merge(entidade);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			if (em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			throw new DBException("Altera��o n�o realizada");
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public T pesquisar(K chave) throws IdNotFoundException {		
		Class<T> classe = (Class<T>) ((ParameterizedType)getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		T entidade =  em.find(classe, chave);
		if (entidade != null) 
			return entidade;
		throw new IdNotFoundException("Dado n�o encontrado");
	}

	@Override
	public void excluir(K chave) throws DBException, IdNotFoundException {
		T entidade = pesquisar(chave);
		try{
			em.getTransaction().begin();
			em.remove(entidade);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			if (em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			throw new DBException("Exclus�o n�o realizada");
		}
	}

}
