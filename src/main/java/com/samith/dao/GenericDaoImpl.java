package com.samith.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * The Class GenericDaoImpl.
 *
 * @param <K> the key type
 * @param <E> the element type
 */
public class GenericDaoImpl<K, E> implements GenericDao<K, E> {
	
	/** The entity class. */
	protected Class<E> entityClass;
	
	/** The entity manager. */
	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;
	
	/**
	 * Instantiates a new generic dao impl.
	 *
	 * @param entityClass the entity class
	 */
	public GenericDaoImpl(final Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	/* (non-Javadoc)
	 * @see com.samith.dao.GenericDao#persist(java.lang.Object)
	 */
	@Override
	public void persist(E entity) {
		entityManager.persist(entity);
	}

	/* (non-Javadoc)
	 * @see com.samith.dao.GenericDao#remove(java.lang.Object)
	 */
	@Override
	public void remove(E entity) {
		entityManager.remove(entity);
	}

	/* (non-Javadoc)
	 * @see com.samith.dao.GenericDao#findById(java.lang.Object)
	 */
	@Override
	public E findById(K id) {
		return entityManager.find(entityClass, id);
	}

}
