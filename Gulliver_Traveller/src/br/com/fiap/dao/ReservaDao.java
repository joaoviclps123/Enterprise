package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Reserva;
import br.com.fiap.generic.GenericDaoimplement;
import br.com.fiap.interfaces.ReservaInterface;

public class ReservaDao extends GenericDaoimplement<Reserva, Integer> implements ReservaInterface{

	public ReservaDao(EntityManager em) {
		super(em);
	}

	@Override
	public List<Reserva> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reserva> listar(int primeiraPosicao, int maximoResultados) {
		// TODO Auto-generated method stub
		return null;
	}

}
