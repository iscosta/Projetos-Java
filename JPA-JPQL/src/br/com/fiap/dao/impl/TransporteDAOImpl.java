package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.entity.Transporte;

public class TransporteDAOImpl extends DAOImpl<Transporte,Integer> implements TransporteDAO{

	public TransporteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Transporte> buscarPorEmpresa(String empresa) {
		TypedQuery<Transporte> query = 
			em.createNamedQuery("Transporte.porEmpresa", Transporte.class);
		query.setParameter("e", "%"+ empresa + "%");
		return query.getResultList();
	}

}
