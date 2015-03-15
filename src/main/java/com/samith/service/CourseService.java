package com.samith.service;

import java.util.List;

import com.samith.model.Course;

/**
 * The Interface CourseService.
 */
public interface CourseService {
	
	/**
	 * Creates the course.
	 *
	 * @param course the course
	 */
	void createCourse(Course course);

	/**
	 * Find all courses.
	 *
	 * @return the list
	 */
	List<Course> findAllCourses();
	
	/**
	 * Gets the course.
	 *
	 * @param id the id
	 * @return the course
	 */
	Course getCourse(Integer id);

	/**
	 * Gets the course by name.
	 *
	 * @param title the title
	 * @return the course by name
	 */
	Course getCourseByName(String title);
	
	/**
	 * Checks if is course exists.
	 *
	 * @param name the name
	 * @return true, if is course exists
	 */
	boolean isCourseExists(String name);

}
