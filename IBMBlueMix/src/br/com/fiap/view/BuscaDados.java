package br.com.fiap.view;

import java.util.List;

import br.com.fiap.repository.DadosPessoaRepository;
import br.com.fiap.to.DadosPessoa;

public class BuscaDados {
	
	public static void main(String[] args) throws Exception {
		DadosPessoaRepository rep = new DadosPessoaRepository();
		List<DadosPessoa> lista = rep.buscar(1);
		
		for (DadosPessoa dadosPessoa : lista){
			
			System.out.println("Dispositivo: " + dadosPessoa.getDispositivo());
			System.out.println("Batimento: " + dadosPessoa.getBatimento());
			System.out.println("Pressao: " + dadosPessoa.getPressao());
			System.out.println("Temperatura: " + dadosPessoa.getTemperatura());
			System.out.println("Timestamp: " + dadosPessoa.getTimestamp());
			System.out.println("----------------------------------------");
			
		}
	}

}
