package br.com.fiap.view;


import br.com.fiap.repository.DadosPessoaRepository;
import br.com.fiap.to.DadosPessoa;



public class CadastraDados {

	public static void main(String[] args) {
		
	DadosPessoaRepository repo = new DadosPessoaRepository();
	DadosPessoa dados = new DadosPessoa(1,65,"12/7",37,11516165);
	repo.cadastrar(dados);

	
	System.out.println("Cadastrado!");
	
	}
	
	
}
