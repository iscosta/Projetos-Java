package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Bebida;

public interface BebidaDAO extends GenericDAO<Bebida, Integer>{
	
	List<Bebida> listar();

}
