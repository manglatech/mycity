package com.mgt.findmycity.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MenuItemIngredientsId implements java.io.Serializable {

	private static final long serialVersionUID = 8560603154659406702L;
	private int ingredientId;
	private int menuItemId;

	public MenuItemIngredientsId() {
	}

	public MenuItemIngredientsId(int ingredientId, int menuItemId) {
		this.ingredientId = ingredientId;
		this.menuItemId = menuItemId;
	}

	@Column(name = "INGREDIENT_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public int getIngredientId() {
		return this.ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	@Column(name = "MENU_ITEM_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public int getMenuItemId() {
		return this.menuItemId;
	}

	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MenuItemIngredientsId))
			return false;
		MenuItemIngredientsId castOther = (MenuItemIngredientsId) other;

		return (this.getIngredientId() == castOther.getIngredientId())
				&& (this.getMenuItemId() == castOther.getMenuItemId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIngredientId();
		result = 37 * result + this.getMenuItemId();
		return result;
	}

}
