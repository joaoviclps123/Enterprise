package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Hotel;
import br.com.fiap.generic.GenericDaoimplement;
import br.com.fiap.interfaces.HotelInterface;

public class HotelDao extends GenericDaoimplement<Hotel, Integer> implements HotelInterface{

	public HotelDao(EntityManager em) {
		super(em);
	}

	@Override
	public List<Hotel> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> listar(int primeiraPosicao, int maximoResultados) {
		// TODO Auto-generated method stub
		return null;
	}

}
