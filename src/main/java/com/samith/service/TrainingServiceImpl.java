package com.samith.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.samith.dao.TrainingDao;
import com.samith.model.Training;

/**
 * The Class TrainingServiceImpl.
 */
@Service
public class TrainingServiceImpl implements TrainingService {

	/** The training dao. */
	@Autowired
	TrainingDao trainingDao;
	
	/* (non-Javadoc)
	 * @see com.samith.service.TrainingService#saveTraining(com.samith.model.Training)
	 */
	@Transactional (propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public void saveTraining(Training training) {
		trainingDao.persist(training);
	}

	/* (non-Javadoc)
	 * @see com.samith.service.TrainingService#getTrainingPerCourse(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Training getTrainingPerCourse(Integer accountId, Integer courseId) {
		return trainingDao.getTrainingByAccountAndCourse(accountId, courseId);
	}

}
