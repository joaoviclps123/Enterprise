package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Cliente;
import br.com.fiap.generic.GenericDaoimplement;
import br.com.fiap.interfaces.ClienteInterface;

public class ClienteDao extends GenericDaoimplement<Cliente, Integer> implements ClienteInterface{

	
	public ClienteDao(EntityManager em) {
		super(em);
		
		
	}
	

	@Override
	public List<Cliente> buscarNome(String nome) {
		return null;
	}

	@Override
	public List<Cliente> cpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
