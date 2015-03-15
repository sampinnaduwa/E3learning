package com.samith.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Course.
 */
@Entity
@Table(name="course")
public class Course {
	
	/** The id. */
	@Id
	private int id;
	
	/** The code. */
	@Column(name="code")
	private String code;
	
	/** The title. */
	@Column(name="title")
	private String title;
	
	/** The account. */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="course")
	private List<Account> account;
	
	/**
	 * Instantiates a new course.
	 */
	public Course() {
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
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	public List<Account> getAccount() {
		return account;
	}

	/**
	 * Sets the account.
	 *
	 * @param account the new account
	 */
	public void setAccount(List<Account> account) {
		this.account = account;
	}

}
