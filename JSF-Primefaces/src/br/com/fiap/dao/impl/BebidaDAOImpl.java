package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.BebidaDAO;
import br.com.fiap.entity.Bebida;

public class BebidaDAOImpl extends GenericDAOImpl<Bebida, Integer> implements BebidaDAO{

	public BebidaDAOImpl(EntityManager em) {
		super(em);
		
	}

	@Override
	public List<Bebida> listar() {
		
		return em.createQuery("from Bebida", Bebida.class)
				.getResultList();
		
	}

}
