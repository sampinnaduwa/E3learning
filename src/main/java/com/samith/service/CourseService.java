package com.samith.service;

import java.util.List;

import com.samith.model.Course;

public interface CourseService {
	
	void createCourse(Course course);

	List<Course> findAllCourses();
	
	Course getCourse(Integer id);

	Course getCourseByName(String title);

}
