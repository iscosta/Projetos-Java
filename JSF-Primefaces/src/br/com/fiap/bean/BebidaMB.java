package br.com.fiap.bean;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.fiap.dao.BebidaDAO;
import br.com.fiap.dao.impl.BebidaDAOImpl;

import br.com.fiap.entity.Bebida;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@ManagedBean(name="bebidaMB")
@RequestScoped
public class BebidaMB {

	private Bebida bebida;

	private BebidaDAO dao;

	private List<Bebida> lista;

	@PostConstruct
	private void init() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new BebidaDAOImpl(em);

		bebida = new Bebida();
		bebida.setDataValidade(Calendar.getInstance());

		lista = dao.listar();

	}

	public void cadastrar() {
		FacesMessage msg;
		try {

			dao.cadastrar(bebida);
			msg = new FacesMessage("Cadastrado!");
		} catch (DBException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);

		lista = dao.listar(); // Atualizar a lista
	}

	public Bebida getBebida() {
		return bebida;
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}

	public List<Bebida> getLista() {
		return lista;
	}

	public void setLista(List<Bebida> lista) {
		this.lista = lista;
	}

}
