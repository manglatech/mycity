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
@Table(name = "ingredients", catalog = "findmycity", uniqueConstraints = {})
public class Ingredients implements java.io.Serializable {

	private static final long serialVersionUID = -6049024607523671175L;
	private int id;
	private String name;
	private String description;
	private Set<MenuItemIngredients> menuItemIngredientses = new HashSet<MenuItemIngredients>(
			0);

	public Ingredients() {
	}

	public Ingredients(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Ingredients(int id, String name, String description,
			Set<MenuItemIngredients> menuItemIngredientses) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.menuItemIngredientses = menuItemIngredientses;
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

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "ingredients")
	public Set<MenuItemIngredients> getMenuItemIngredientses() {
		return this.menuItemIngredientses;
	}

	public void setMenuItemIngredientses(
			Set<MenuItemIngredients> menuItemIngredientses) {
		this.menuItemIngredientses = menuItemIngredientses;
	}

}
