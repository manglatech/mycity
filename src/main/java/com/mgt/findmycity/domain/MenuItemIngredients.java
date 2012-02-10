package com.mgt.findmycity.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "menu_item_ingredients", catalog = "findmycity")
public class MenuItemIngredients implements java.io.Serializable {

	private static final long serialVersionUID = 8754342665822631075L;
	private MenuItemIngredientsId id;
	private Ingredients ingredients;
	private MenuItem menuItem;

	public MenuItemIngredients() {
	}

	public MenuItemIngredients(MenuItemIngredientsId id,
			Ingredients ingredients, MenuItem menuItem) {
		this.id = id;
		this.ingredients = ingredients;
		this.menuItem = menuItem;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "ingredientId", column = @Column(name = "INGREDIENT_ID", unique = false, nullable = false, insertable = true, updatable = true)),
			@AttributeOverride(name = "menuItemId", column = @Column(name = "MENU_ITEM_ID", unique = false, nullable = false, insertable = true, updatable = true)) })
	public MenuItemIngredientsId getId() {
		return this.id;
	}

	public void setId(MenuItemIngredientsId id) {
		this.id = id;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "INGREDIENT_ID", unique = false, nullable = false, insertable = false, updatable = false)
	public Ingredients getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(Ingredients ingredients) {
		this.ingredients = ingredients;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ITEM_ID", unique = false, nullable = false, insertable = false, updatable = false)
	public MenuItem getMenuItem() {
		return this.menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

}
