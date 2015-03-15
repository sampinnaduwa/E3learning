package com.samith.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Training.
 */
@Entity
@Table(name="training")
public class Training {
	
	/** The id. */
	@Id
	@GeneratedValue
	private int id;
	
	/** The account id. */
	@Column(name="account_id")
	private int accountId;
	
	/** The course id. */
	@Column(name="course_id")
	private int courseId;
	
	/** The grade. */
	@Column(name="grade")
	private double grade;
	

	/**
	 * Instantiates a new training.
	 */
	public Training() {
	}

	/**
	 * Instantiates a new training.
	 *
	 * @param accountId the account id
	 * @param courseId the course id
	 */
	public Training(int accountId, int courseId) {
		this.accountId = accountId;
		this.courseId = courseId;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the account id.
	 *
	 * @return the account id
	 */
	public int getAccountId() {
		return accountId;
	}

	/**
	 * Sets the account id.
	 *
	 * @param accountId the new account id
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/**
	 * Gets the course id.
	 *
	 * @return the course id
	 */
	public int getCourseId() {
		return courseId;
	}

	/**
	 * Sets the course id.
	 *
	 * @param courseId the new course id
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	/**
	 * Gets the grade.
	 *
	 * @return the grade
	 */
	public double getGrade() {
		return grade;
	}

	/**
	 * Sets the grade.
	 *
	 * @param grade the new grade
	 */
	public void setGrade(double grade) {
		this.grade = grade;
	}

}
