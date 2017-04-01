package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;

public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	private EntityManager em;

	public GenericDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void alterar(T entidade) throws DBException {
		try {

			em.getTransaction().begin();

			em.merge(entidade);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();

			}
			throw new DBException("Alteracao nao realizada");

		}
	}

	@Override
	public void cadastrar(T entidade) throws DBException {
		try {

			em.getTransaction().begin();
			em.persist(entidade);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

			if (em.getTransaction().isActive())
				em.getTransaction().rollback();

		}
		throw new DBException("Produto nao cadastrado");
	}

	@SuppressWarnings("all")
	@Override
	public void excluir(K chave) throws DBException, IdNotFoundException {
		T entidade = pesquisar(chave);
		try {
			em.getTransaction().begin();
			em.remove(chave);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw new DBException("Exclusao nao realizada");
		}
	}

	@SuppressWarnings("all")
	@Override
	public T pesquisar(K chave) throws IdNotFoundException {
		Class<T> classe = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		T entidade = em.find(classe, chave);
		if (entidade != null)
			return entidade;
		throw new IdNotFoundException("Dados nao encontrados");

	}

}
