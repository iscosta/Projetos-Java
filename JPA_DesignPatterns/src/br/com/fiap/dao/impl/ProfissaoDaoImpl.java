package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProfissaoDao;
import br.com.fiap.entity.Profissao;

public class ProfissaoDaoImpl extends GenericDaoImpl <Profissao, Integer> implements  ProfissaoDao {

	public ProfissaoDaoImpl(EntityManager em) {
		super(em);
	
	}
	
	
		
		


}
