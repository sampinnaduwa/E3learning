package com.samith.dao;

public interface GenericDao<K, E> {
	
	void persist(E entity);
	
	void remove(E entity);

	E findById(K id);

}
