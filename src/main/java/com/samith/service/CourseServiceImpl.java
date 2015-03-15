package com.samith.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.samith.dao.CourseDao;
import com.samith.model.Course;

/**
 * The Class CourseServiceImpl.
 */
@Service
public class CourseServiceImpl implements CourseService {
	
	/** The course dao. */
	@Autowired
	CourseDao courseDao;

	/* (non-Javadoc)
	 * @see com.samith.service.CourseService#createCourse(com.samith.model.Course)
	 */
	@Transactional (propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public void createCourse(Course course) {
		courseDao.persist(course);
		
	}

	/* (non-Javadoc)
	 * @see com.samith.service.CourseService#findAllCourses()
	 */
	@Override
	public List<Course> findAllCourses() {
		
		return courseDao.getAllCourses();
	}

	/* (non-Javadoc)
	 * @see com.samith.service.CourseService#getCourse(java.lang.Integer)
	 */
	@Override
	public Course getCourse(Integer id) {
		
		return courseDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.samith.service.CourseService#getCourseByName(java.lang.String)
	 */
	@Override
	public Course getCourseByName(String title) {
		
		return courseDao.getCourseByName(title);
	}

	/* (non-Javadoc)
	 * @see com.samith.service.CourseService#isCourseExists(java.lang.String)
	 */
	@Override
	public boolean isCourseExists(String name) {
		return courseDao.isCourseExists(name);
	}
	
	
}
