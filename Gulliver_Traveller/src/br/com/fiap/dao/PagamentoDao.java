package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Pagamento;
import br.com.fiap.generic.GenericDaoimplement;
import br.com.fiap.interfaces.PagamentoInterface;

public class PagamentoDao extends GenericDaoimplement<Pagamento, Integer> implements PagamentoInterface{

	public PagamentoDao(EntityManager em) {
		super(em);
	}

	@Override
	public List<Pagamento> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pagamento> listar(int primeiraPosicao, int maximoResultados) {
		// TODO Auto-generated method stub
		return null;
	}

}
