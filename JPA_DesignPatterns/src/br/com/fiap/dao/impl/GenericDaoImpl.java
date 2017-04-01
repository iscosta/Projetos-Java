package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDao;

public abstract class GenericDaoImpl<T, K> implements GenericDao<T, K> {

	private EntityManager em;

	public GenericDaoImpl(EntityManager em) {

		this.em = em;
	}

	@Override
	public void cadastrar(T objeto) {
		em.getTransaction().begin();
		em.persist(objeto);
		em.getTransaction().commit();

	}

	@Override
	public void atualizar(T objeto) {

		em.getTransaction().begin();
		em.merge(objeto);
		em.getTransaction().commit();

	}

	@Override
	public void excluir(K chave) {

		T objeto = buscarPorId(chave);

		em.getTransaction().begin();
		em.remove(objeto);
		em.getTransaction().commit();

	}

	@Override
	@SuppressWarnings("all")
	public T buscarPorId(K chave) {
		Class<T> classe = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

		return em.find(classe, chave);
	}

}
