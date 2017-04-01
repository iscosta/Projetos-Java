package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Transporte;

public interface TransporteDAO extends DAO<Transporte,Integer>{

	List<Transporte> buscarPorEmpresa(String empresa);
	
}
