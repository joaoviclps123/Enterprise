package br.com.fiap.interfaces;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteInterface extends GenericDaointerface<Cliente, Integer>{
	List<Cliente> buscarNome(String nome);
	
	List<Cliente> cpf (String cpf);
}
