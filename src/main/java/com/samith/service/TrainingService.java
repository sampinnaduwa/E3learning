package com.samith.service;

import com.samith.model.Training;

/**
 * The Interface TrainingService.
 */
public interface TrainingService {
	
	/**
	 * Save training.
	 *
	 * @param training the training
	 */
	void saveTraining(Training training);

	/**
	 * Gets the training per course.
	 *
	 * @param accountId the account id
	 * @param courseId the course id
	 * @return the training per course
	 */
	Training getTrainingPerCourse(Integer accountId, Integer courseId);

}
