package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Estado;
import br.com.fiap.generic.GenericDaoimplement;
import br.com.fiap.interfaces.EstadoInterface;

public class EstadoDao extends GenericDaoimplement<Estado, Integer> implements EstadoInterface{

	public EstadoDao(EntityManager em) {
		super(em);
	}

	@Override
	public List<Estado> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estado> listar(int primeiraPosicao, int maximoResultados) {
		// TODO Auto-generated method stub
		return null;
	}

}
