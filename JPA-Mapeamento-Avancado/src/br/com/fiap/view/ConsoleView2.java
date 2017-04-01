package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.dao.impl.PessoaDAOImpl;
import br.com.fiap.entity.Pessoa;
import br.com.fiap.entity.PessoaFisica;
import br.com.fiap.entity.PessoaJuridica;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.singleton.EMFactorySingleton;

public class ConsoleView2 {

	public static void main(String[] args) {
		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		PessoaDAO dao = new PessoaDAOImpl(em);

		PessoaFisica pf = new PessoaFisica();
		pf.setCpf("123456789");
		pf.setPessoa("Igor");

		PessoaJuridica pj = new PessoaJuridica();
		pj.setPessoa("Humberto Churros LTDA");
		pj.setCnpj("23.325.365/0001-23");

		try {

			dao.insert(pf);
			dao.insert(pj);
		} catch (DBCommitException e) {
			e.printStackTrace();

		}
		System.exit(0);

}
}
