package br.com.fiap.bean;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.entity.Aluno;
import br.com.fiap.repository.AlunoRepository;

@ManagedBean
@ViewScoped
public class AlunoBean {

	private Aluno aluno;

	private List<Aluno> listaAluno;
	
	private AlunoRepository rep;

	//private String nomeBusca;
	
	//private List<String> nome;

	@PostConstruct
	private void init() {

		aluno = new Aluno();
		aluno.setDataNascimento(Calendar.getInstance());
		rep = new AlunoRepository();

	}

	public void cadastrar() {
		FacesMessage msg;
		try {
			rep.cadastrar(aluno);
			msg = new FacesMessage("Aluno cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro!");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}
	
/*	public void buscarPorNome() throws Exception {
		
		listaAluno = rep.buscarPorNome(nomeBusca);
		
	}
	
	*/

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getListaAluno() {
		return listaAluno;
	}

	public void setListaAluno(List<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}

/*	public String getNomeBusca() {
		return nomeBusca;
	}

	public void setNomebusca(String nomeBusca) {
		this.nomeBusca = nomeBusca;
	}

	public List<String> getNome() {
		return nome;
	}

	public void setNome(List<String> nome) {
		this.nome = nome;
	}
	

	*/
}
