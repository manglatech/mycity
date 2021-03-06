package com.mgt.findmycity.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "findmycity", uniqueConstraints = {})
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2833332181281247573L;
	// Fields

	private int userId;
	private String emailAddress;
	private String password;
	private String enabled;
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(int userId, String emailAddress, String password, String enabled) {
		this.userId = userId;
		this.emailAddress = emailAddress;
		this.password = password;
		this.enabled = enabled;
	}

	/** full constructor */
	public User(int userId, String emailAddress, String password,
			String enabled, Set<UserRole> userRoles) {
		this.userId = userId;
		this.emailAddress = emailAddress;
		this.password = password;
		this.enabled = enabled;
		this.userRoles = userRoles;
	}

	// Property accessors
	@Id
	@Column(name = "user_id", unique = true, nullable = false, insertable = true, updatable = true)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "emailAddress", unique = false, nullable = false, insertable = true, updatable = true, length = 256)
	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "password", unique = false, nullable = false, insertable = true, updatable = true, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled", unique = false, nullable = false, insertable = true, updatable = true, length = 1)
	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}
