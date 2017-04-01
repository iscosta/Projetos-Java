package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends DAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		TypedQuery<Pacote> query = em.createQuery(
			"from Pacote p where p.transporte = :P",Pacote.class);
		query.setParameter("P", transporte);
		return query.getResultList();
	}

	@Override
	public List<Pacote> getPacotes(Calendar inicio, Calendar fim) {
		TypedQuery<Pacote> query = em.createQuery(
			"from Pacote p where p.dataSaida between :i and :f",Pacote.class);
		query.setParameter("i", inicio);
		query.setParameter("f", fim);
		return query.getResultList();
	}

}





