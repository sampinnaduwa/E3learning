package com.samith.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public class GenericDaoImpl<K, E> implements GenericDao<K, E> {
	
	protected Class<E> entityClass;
	
	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;
	
	public GenericDaoImpl(final Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void persist(E entity) {
		entityManager.persist(entity);
	}

	@Override
	public void remove(E entity) {
		entityManager.remove(entity);
	}

	@Override
	public E findById(K id) {
		return entityManager.find(entityClass, id);
	}

}
