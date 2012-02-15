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
@Table(name = "menu_item_add_on", catalog = "findmycity", uniqueConstraints = {})
public class MenuItemAddOn implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 8286106814871040367L;
	private int id;
	private String name;
	private String description;
	private Set<MenuItemAddOnMapping> menuItemAddOnMappings = new HashSet<MenuItemAddOnMapping>(
			0);

	// Constructors

	/** default constructor */
	public MenuItemAddOn() {
	}

	/** minimal constructor */
	public MenuItemAddOn(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public MenuItemAddOn(int id, String name, String description,
			Set<MenuItemAddOnMapping> menuItemAddOnMappings) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.menuItemAddOnMappings = menuItemAddOnMappings;
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

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "menuItemAddOn")
	@XmlTransient
	public Set<MenuItemAddOnMapping> getMenuItemAddOnMappings() {
		return this.menuItemAddOnMappings;
	}

	public void setMenuItemAddOnMappings(
			Set<MenuItemAddOnMapping> menuItemAddOnMappings) {
		this.menuItemAddOnMappings = menuItemAddOnMappings;
	}

}
