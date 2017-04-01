package br.com.fiap.teste;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.impl.CarroDAOImpl;
import br.com.fiap.entity.Carro;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.singleton.EMFSingleton;

public class CarroDAOTeste {

	public static CarroDAO dao;

	@BeforeClass
	public static void inicializar() {
		EntityManager em = EMFSingleton.getInstance().createEntityManager();

		dao = new CarroDAOImpl(em);

	}

	// Método de suporte que cadastra um carro

	private Carro cadastrar() throws DBException {

		Carro carro = new Carro();
		carro.setMarca("JAC");
		carro.setModelo("J7");
		carro.setCor("Preto");
		carro.setPreco(15000);

		dao.cadastrar(carro);

		return carro;

	}

	@Test
	public void cadastroSet() {
		// Cadastrar um carro
		try {
			Carro carro = cadastrar();

			// Valida se recebeu um ID
			Assert.assertNotEquals(carro.getId(), 0);
		} catch (DBException e) {
			e.printStackTrace();
			Assert.fail();

		}

	}

	@Test
	public void buscaTest() {
		// Cadastra um carro

		try {
			Carro carro = cadastrar();

			// Busca o carro cadastrado e verifica se ele existe
			Carro busca = dao.pesquisar((carro.getId()));
			Assert.assertNotNull(busca);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test
	public void alteraTest() {
		// Cadastra um carro

		try {
			Carro carro = cadastrar();

			// Altera o carro

			carro.setModelo("J8");
			dao.alterar(carro);

			// Busca e valida se a alteracao foi realizada no banco
			Carro busca = dao.pesquisar(carro.getId());
			Assert.assertEquals("J8", busca.getModelo());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test
	@SuppressWarnings("all")
	public void removeTest() {

		try {
			// Cadastra um carro

			Carro carro = cadastrar();
			// Remove o carro
			dao.excluir(carro.getId());
			// Buscar e validar se o carro foi removido
			try {
				Carro busca = dao.pesquisar(carro.getId());
			} catch (IdNotFoundException e) {
				System.out.println("Sucesso!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

}
