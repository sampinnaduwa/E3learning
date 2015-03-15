package com.samith.dao;

import com.samith.model.Training;

/**
 * The Interface TrainingDao.
 */
public interface TrainingDao extends GenericDao<Integer, Training> {

	/**
	 * Gets the training by account and course.
	 *
	 * @param accountId the account id
	 * @param courseId the course id
	 * @return the training by account and course
	 */
	Training getTrainingByAccountAndCourse(Integer accountId, Integer courseId);

}
