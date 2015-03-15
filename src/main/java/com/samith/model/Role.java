package com.samith.model;

import java.util.Set;

import javax.persistence.CascadeType;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
import javax.persistence.JoinColumn;  
import javax.persistence.JoinTable;  
import javax.persistence.OneToMany;  
import javax.persistence.Table;  
  
/**
 * The Class Role.
 */
@Entity  
@Table(name="roles")  
public class Role {  
  
    /** The id. */
    @Id  
    @GeneratedValue  
    private Integer id;  
      
    /** The role. */
    private String role;  
      
    /** The user roles. */
    @OneToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="user_roles",  
    	joinColumns={@JoinColumn(name="role_id", referencedColumnName="id")},  
    	inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="id")}
    )  
    private Set<User> userRoles;  
      
    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {  
        return id;  
    }  
    
    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {  
        this.id = id;  
    }  
    
    /**
     * Gets the role.
     *
     * @return the role
     */
    public String getRole() {  
        return role;  
    }  
    
    /**
     * Sets the role.
     *
     * @param role the new role
     */
    public void setRole(String role) {  
        this.role = role;  
    }  
    
    /**
     * Gets the user roles.
     *
     * @return the user roles
     */
    public Set<User> getUserRoles() {
		return userRoles;
	}

	/**
	 * Sets the user roles.
	 *
	 * @param userRoles the new user roles
	 */
	public void setUserRoles(Set<User> userRoles) {
		this.userRoles = userRoles;
	} 
      
}  