package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends DAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listar() {
		//Cria a query
		TypedQuery<Cliente> query = 
					em.createQuery("from Cliente",Cliente.class);
		query.setMaxResults(50); //Máximo de resultados
		//Executa e retorna o resultado da busca
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) {
		TypedQuery<Cliente> query = 
			em.createQuery("select c from Cliente c where c.nome = :churros"
					,Cliente.class);
		query.setParameter("churros", nome);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(String uf) {
		TypedQuery<Cliente> query = em.createQuery(
			"from Cliente c where c.endereco.cidade.uf = :estado",Cliente.class);
		query.setParameter("estado", uf);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiasReserva(int dias) {
		TypedQuery<Cliente> query = em.createQuery(
			"select r.cliente from Reserva r where r.numeroDias = :dias",Cliente.class);
		query.setParameter("dias", dias);
		return query.getResultList();
	}

	@Override
	public List<Object[]> buscarNomeCPF(String nome) {
		Query query = em.createQuery(
			"select c.nome, c.cpf from Cliente c where c.nome like :n");
		query.setParameter("n","%"+nome+"%");
		query.setMaxResults(50);
		return query.getResultList();
	}

	@Override
	public Long contarTotal() {
		TypedQuery<Long> query = em.createQuery(
			"select count(c) from Cliente c",Long.class);
		return query.getSingleResult();
	}

	@Override
	public List<Cliente> getClientePorNome(String nome, String cidade) {
		TypedQuery<Cliente> query = em.createQuery(
			"from Cliente c where c.nome like :n and "
			+ "c.endereco.cidade.nome like :c",Cliente.class);
		query.setParameter("n", "%"+nome+"%");
		query.setParameter("c", "%"+cidade+"%");
		return query.getResultList();
	}

	@Override
	public List<Cliente> getClientePorEstado(List<String> estados) {
		TypedQuery<Cliente> query = em.createQuery(
			"from Cliente c where c.endereco.cidade.uf in :e",Cliente.class);
		query.setParameter("e", estados);
		return query.getResultList();
	}
	
}




