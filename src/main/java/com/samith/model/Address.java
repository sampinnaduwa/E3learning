package com.samith.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class Address.
 */
@Embeddable
public class Address {
	
	/** The street name. */
	@Column(name="street_name")
	private String streetName;
	
	/** The suburb. */
	@Column
	private String suburb;
	
	/** The state. */
	@Column
	private String state;
	
	/** The country. */
	@Column
	private String country;

	/**
	 * Gets the street name.
	 *
	 * @return the street name
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * Sets the street name.
	 *
	 * @param streetName the new street name
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * Gets the suburb.
	 *
	 * @return the suburb
	 */
	public String getSuburb() {
		return suburb;
	}

	/**
	 * Sets the suburb.
	 *
	 * @param suburb the new suburb
	 */
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}
