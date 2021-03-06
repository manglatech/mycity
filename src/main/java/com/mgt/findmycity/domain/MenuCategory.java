package com.mgt.findmycity.domain;

// Generated Feb 10, 2012 3:23:57 PM by Hibernate Tools 3.1.0.beta4

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
@Table(name = "menu_category", catalog = "findmycity", uniqueConstraints = {})
public class MenuCategory implements java.io.Serializable {

	private static final long serialVersionUID = -6194197451283114730L;

	private int id;
	private String name;
	private String description;
	private Set<MenuItem> menuItems = new HashSet<MenuItem>(0);

	public MenuCategory() {
	}

	public MenuCategory(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public MenuCategory(int id, String name, String description,
			Set<MenuItem> menuItems) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.menuItems = menuItems;
	}

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

	@Column(name = "DESCRIPTION", unique = false, nullable = false, insertable = true, updatable = true)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "menuCategory")
	public Set<MenuItem> getMenuItems() {
		return this.menuItems;
	}

	public void setMenuItems(Set<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

}
