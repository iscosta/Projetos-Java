package br.com.fiap.bean;

import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.entity.Aluno;
import br.com.fiap.repository.AlunoRepository;

@ManagedBean
@ViewScoped
public class AlunoListarBean {

	private List<Aluno> listaAluno;
	private Aluno aluno;
	private AlunoRepository rep;
	private int id;

	public AlunoListarBean() {
		try {
			aluno = new Aluno();
			aluno.setDataNascimento(Calendar.getInstance());
			rep = new AlunoRepository();
			listaAluno = rep.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletar() {
		FacesMessage msg = null;
		try {
			rep.remover(id);
			listaAluno = rep.listar();
			msg = new FacesMessage("Dados do aluno foi deletado com sucesso!");
		} catch (Exception e) {
			msg = new FacesMessage("Error: " + e.getMessage());
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public List<Aluno> getListaAluno() {
		return listaAluno;
	}

	public void setListaAluno(List<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


}
