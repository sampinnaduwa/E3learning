package com.samith.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.samith.model.Course;

/**
 * The Class CourseDaoImpl.
 */
@Repository
public class CourseDaoImpl extends GenericDaoImpl<Integer, Course> implements CourseDao {

	/**
	 * Instantiates a new course dao impl.
	 */
	public CourseDaoImpl() {
		super(Course.class);
	}

	/* (non-Javadoc)
	 * @see com.samith.dao.CourseDao#getAllCourses()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllCourses() {
		Query query = entityManager.createQuery("SELECT c FROM Course c");
		return (List<Course>) query.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.samith.dao.CourseDao#getCourseByName(java.lang.String)
	 */
	@Override
	public Course getCourseByName(String name) {
		Query query = entityManager.createQuery("SELECT c FROM Course c Where c.title  = :name");
		query.setParameter("name", name);
		Course course = (Course) query.getSingleResult();
		return course;
	}

	/* (non-Javadoc)
	 * @see com.samith.dao.CourseDao#isCourseExists(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean isCourseExists(String name) {
		List<Course> courseList = new ArrayList<Course>();
		Query query = entityManager.createQuery("from Course c where c.title = :name");
        query.setParameter("name", name);  
        courseList = query.getResultList();  
        if (courseList.size() > 0)  
            return true;  
        
		return false;
	}

}
