package com.mgt.findmycity.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "menu_type", catalog = "findmycity", uniqueConstraints = {})
public class MenuType implements java.io.Serializable {

	private static final long serialVersionUID = -8070688157377966424L;
	private int id;
	private MenuServingTime menuServingTime;
	private String name;
	private String description;
	private Set<RestaurentMenu> restaurentMenus = new HashSet<RestaurentMenu>(0);

	// Constructors

	/** default constructor */
	public MenuType() {
	}

	/** minimal constructor */
	public MenuType(int id, MenuServingTime menuServingTime, String name) {
		this.id = id;
		this.menuServingTime = menuServingTime;
		this.name = name;
	}

	/** full constructor */
	public MenuType(int id, MenuServingTime menuServingTime, String name,
			String description, Set<RestaurentMenu> restaurentMenus) {
		this.id = id;
		this.menuServingTime = menuServingTime;
		this.name = name;
		this.description = description;
		this.restaurentMenus = restaurentMenus;
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

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_SERVING_TIME_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public MenuServingTime getMenuServingTime() {
		return this.menuServingTime;
	}

	public void setMenuServingTime(MenuServingTime menuServingTime) {
		this.menuServingTime = menuServingTime;
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

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "menuType")
	@XmlTransient
	public Set<RestaurentMenu> getRestaurentMenus() {
		return this.restaurentMenus;
	}

	public void setRestaurentMenus(Set<RestaurentMenu> restaurentMenus) {
		this.restaurentMenus = restaurentMenus;
	}

}
