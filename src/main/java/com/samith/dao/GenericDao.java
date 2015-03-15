package com.samith.dao;

/**
 * The Interface GenericDao.
 *
 * @param <K> the key type
 * @param <E> the element type
 */
public interface GenericDao<K, E> {
	
	/**
	 * Persist.
	 *
	 * @param entity the entity
	 */
	void persist(E entity);
	
	/**
	 * Removes the.
	 *
	 * @param entity the entity
	 */
	void remove(E entity);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the e
	 */
	E findById(K id);

}
