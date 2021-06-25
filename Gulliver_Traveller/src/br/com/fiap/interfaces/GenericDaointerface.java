package br.com.fiap.interfaces;

import br.com.fiap.exeption.EntityNotFoundException;

import java.util.List;

import br.com.fiap.exeption.CommitException;

public interface GenericDaointerface<E, K> {

	void create(E entidade);

	E read(K id) throws EntityNotFoundException;
	
	E pesquisar(K codigo);
	
	void update(E entidade);

	void remove(K id) throws EntityNotFoundException;

	void commit() throws CommitException;
	
	List<E> listar();
	
	List<E> listar(int primeiraPosicao, int maximoResultados);

	
}