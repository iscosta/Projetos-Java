package br.com.fiap.bean;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.entity.Aluno;
import br.com.fiap.repository.AlunoRepository;

@ManagedBean
@RequestScoped
public class AlunoAlterarBean {

	private Aluno aluno;

	private AlunoRepository rep;

	public AlunoAlterarBean() {

		setAluno(new Aluno());
		getAluno().setDataNascimento(Calendar.getInstance());
		rep = new AlunoRepository();

	}

	public void alterar() {
		FacesMessage msg = null;
		try {

			rep.atualizar(getAluno());
			msg = new FacesMessage("Dados do aluno alterado com sucesso!");

		} catch (Exception e) {
			msg = new FacesMessage("Error: " + e.getMessage());
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
