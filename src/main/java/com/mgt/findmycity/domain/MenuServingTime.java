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
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "menu_serving_time", catalog = "findmycity", uniqueConstraints = {})
public class MenuServingTime implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2193488985772229779L;
	// Fields

	private int id;
	private String name;
	private String description;
	private Set<MenuType> menuTypes = new HashSet<MenuType>(0);

	// Constructors

	/** default constructor */
	public MenuServingTime() {
	}

	/** minimal constructor */
	public MenuServingTime(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public MenuServingTime(int id, String name, String description,
			Set<MenuType> menuTypes) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.menuTypes = menuTypes;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, insertable = true, updatable = true)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", unique = false, nullable = true, insertable = true, updatable = true)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "menuServingTime")
	@XmlTransient
	public Set<MenuType> getMenuTypes() {
		return this.menuTypes;
	}

	public void setMenuTypes(Set<MenuType> menuTypes) {
		this.menuTypes = menuTypes;
	}

}
