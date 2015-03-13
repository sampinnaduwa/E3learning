package com.samith.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.samith.model.Course;

@Repository
public class CourseDaoImpl extends GenericDaoImpl<Integer, Course> implements CourseDao {

	public CourseDaoImpl() {
		super(Course.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllCourses() {
		Query query = entityManager.createQuery("SELECT c FROM Course c");
		return (List<Course>) query.getResultList();
	}

	@Override
	public Course getCourseByName(String name) {
		Query query = entityManager.createQuery("SELECT c FROM Course c Where c.title  = :name");
		query.setParameter("name", name);
		Course course = (Course) query.getSingleResult();
		return course;
	}

}
