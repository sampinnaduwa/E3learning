package com.samith.dao;

import java.util.List;

import com.samith.model.Course;

/**
 * The Interface CourseDao.
 */
public interface CourseDao extends GenericDao<Integer, Course> {

	/**
	 * Gets the all courses.
	 *
	 * @return the all courses
	 */
	List<Course> getAllCourses();
	
	/**
	 * Gets the course by name.
	 *
	 * @param name the name
	 * @return the course by name
	 */
	Course getCourseByName(String name);

	/**
	 * Checks if is course exists.
	 *
	 * @param name the name
	 * @return true, if is course exists
	 */
	boolean isCourseExists(String name);

}
