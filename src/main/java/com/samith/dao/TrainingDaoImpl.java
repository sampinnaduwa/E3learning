package com.samith.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.samith.model.Training;

/**
 * The Class TrainingDaoImpl.
 */
@Repository
public class TrainingDaoImpl extends GenericDaoImpl<Integer, Training> implements
		TrainingDao {

	/**
	 * Instantiates a new training dao impl.
	 */
	public TrainingDaoImpl() {
		super(Training.class);
	}

	/* (non-Javadoc)
	 * @see com.samith.dao.TrainingDao#getTrainingByAccountAndCourse(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Training getTrainingByAccountAndCourse(Integer accountId,
			Integer courseId) {
		Query query = entityManager.createQuery("SELECT t FROM Training t WHERE t.accountId  = :accountId AND t.courseId = :courseId");
		query.setParameter("accountId", accountId);
		query.setParameter("courseId", courseId);
		@SuppressWarnings("unchecked")
		List<Training> training = query.getResultList();
		if(training.isEmpty()){
			return null;
		}
		return training.get(0);
	}

}
