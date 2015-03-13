package com.samith.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.samith.dao.CourseDao;
import com.samith.model.Course;

@Repository
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseDao courseDao;

	@Transactional (propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public void createCourse(Course course) {
		courseDao.persist(course);
		
	}

	@Override
	public List<Course> findAllCourses() {
		
		return courseDao.getAllCourses();
	}

	@Override
	public Course getCourse(Integer id) {
		
		return courseDao.findById(id);
	}

	@Override
	public Course getCourseByName(String title) {
		
		return courseDao.getCourseByName(title);
	}
	
	
}
