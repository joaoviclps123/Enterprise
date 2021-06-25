package br.com.fiap.generic;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.exeption.CommitException;
import br.com.fiap.exeption.EntityNotFoundException;
import br.com.fiap.interfaces.GenericDaointerface;



public abstract class GenericDaoimplement<E, K> implements GenericDaointerface<E, K> {
	private EntityManager em;
	private Class<E> clazz;

	@SuppressWarnings("all")
	public GenericDaoimplement(EntityManager em) {
		this.em = em;
		this.clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public List<E> listar() {
		TypedQuery<E> query = em.createQuery("from " + clazz.getName() , clazz);
		query.setMaxResults(2);
		return query.getResultList();
	}
	
	@Override
	public void create(E entidade) {
		em.persist(entidade);
	}

	@Override
	public E read(K id) throws EntityNotFoundException {
		E entidade = em.find(clazz, id);
		if (entidade == null)
			throw new EntityNotFoundException();
		return entidade;
	}

	@Override
	public void update(E entidade) {
		em.merge(entidade);
	}

	@Override
	public void remove(K id) throws EntityNotFoundException {
		E entidade = read(id);
		em.remove(entidade);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
	}
	
	@Override
	public E pesquisar(K codigo) {
		return em.find(clazz, codigo);
	}
	
	@Override
	public List<E> listar(int primeiraPosicao, int maximoResultados){
		return em.createQuery("from " + clazz.getName(), clazz)
				.setMaxResults(maximoResultados)
				.setFirstResult(primeiraPosicao)
				.getResultList();
	}
	
}
