package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends DAO<Cliente,Integer>{

	List<Cliente> listar();
	
	List<Cliente> buscarPorNome(String nome);
	
	List<Cliente> buscarPorEstado(String uf);
	
	List<Cliente> buscarPorDiasReserva(int dias);
	
	List<Object[]> buscarNomeCPF(String nome);
	
	Long contarTotal();
	
	List<Cliente> getClientePorNome(String nome, String cidade);
	
	List<Cliente> getClientePorEstado(List<String> estados);
	
}
