package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.EstadoDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.EstadoDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Estado;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.singleton.EMFactorySingleton;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		EstadoDAO estadoDao = new EstadoDAOImpl(em);
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		
		Estado estado = new Estado("TO","Tocantins",152000);
		Cidade cidade = new Cidade("Palmas",estado,89,2.5f);
		
		//Cadastrar o estado
		try {
			estadoDao.insert(estado);
			cidadeDao.insert(cidade);
		} catch (DBCommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
		//Cadastrar a cidade
	}
	
	
}
