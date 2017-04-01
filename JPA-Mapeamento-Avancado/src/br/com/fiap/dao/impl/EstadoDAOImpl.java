package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EstadoDAO;
import br.com.fiap.entity.Estado;

public class EstadoDAOImpl extends DAOImpl<Estado,String> implements EstadoDAO {

	public EstadoDAOImpl(EntityManager em) {
		super(em);

	}

}
