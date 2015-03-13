package com.samith.dao;

import java.util.List;

import com.samith.model.Course;

public interface CourseDao extends GenericDao<Integer, Course> {

	List<Course> getAllCourses();
	
	Course getCourseByName(String name);

}
