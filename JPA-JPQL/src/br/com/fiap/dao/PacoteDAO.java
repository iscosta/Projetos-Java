package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends DAO<Pacote,Integer>{

	List<Pacote> buscarPorTransporte(Transporte transporte);
	
	List<Pacote> getPacotes(Calendar inicio, Calendar fim);
	
}
