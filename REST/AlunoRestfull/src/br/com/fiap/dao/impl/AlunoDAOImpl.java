package br.com.fiap.dao.impl;




import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.entity.Aluno;

public class AlunoDAOImpl extends DAOImpl<Aluno, Integer> implements AlunoDAO {

	public AlunoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	
@Override
	public List<Aluno> buscarPorNome(String nome) {
		
		
		return em.createQuery("from Aluno a where a.nome like :n",Aluno.class)
				.setParameter("n","%"+nome+"%").getResultList();
		
	}



}

