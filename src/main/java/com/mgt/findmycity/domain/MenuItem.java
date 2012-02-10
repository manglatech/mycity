package com.mgt.findmycity.domain;

// Generated Feb 10, 2012 3:23:57 PM by Hibernate Tools 3.1.0.beta4

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

@Entity
@Table(name = "menu_item", catalog = "findmycity", uniqueConstraints = {})
public class MenuItem implements java.io.Serializable {

	private static final long serialVersionUID = -2717945173060045836L;
	private int menuItemId;
	private MenuCategory menuCategory;
	private Restaurent restaurent;
	private String itemName;
	private String itemDesc;
	private int price;
	private Set<MenuItemIngredients> menuItemIngredientses = new HashSet<MenuItemIngredients>(
			0);

	public MenuItem() {
	}

	public MenuItem(int menuItemId, Restaurent restaurent, String itemName,
			int price) {
		this.menuItemId = menuItemId;
		this.restaurent = restaurent;
		this.itemName = itemName;
		this.price = price;
	}

	public MenuItem(int menuItemId, MenuCategory menuCategory,
			Restaurent restaurent, String itemName, String itemDesc, int price,
			Set<MenuItemIngredients> menuItemIngredientses) {
		this.menuItemId = menuItemId;
		this.menuCategory = menuCategory;
		this.restaurent = restaurent;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.price = price;
		this.menuItemIngredientses = menuItemIngredientses;
	}

	@Id
	@Column(name = "MENU_ITEM_ID", unique = true, nullable = false, insertable = true, updatable = true)
	public int getMenuItemId() {
		return this.menuItemId;
	}

	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_CATEGORY_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public MenuCategory getMenuCategory() {
		return this.menuCategory;
	}

	public void setMenuCategory(MenuCategory menuCategory) {
		this.menuCategory = menuCategory;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "RESTAURENT_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public Restaurent getRestaurent() {
		return this.restaurent;
	}

	public void setRestaurent(Restaurent restaurent) {
		this.restaurent = restaurent;
	}

	@Column(name = "ITEM_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 45)
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "ITEM_DESC", unique = false, nullable = true, insertable = true, updatable = true)
	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	@Column(name = "PRICE", unique = false, nullable = false, insertable = true, updatable = true)
	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "menuItem")
	public Set<MenuItemIngredients> getMenuItemIngredientses() {
		return this.menuItemIngredientses;
	}

	public void setMenuItemIngredientses(
			Set<MenuItemIngredients> menuItemIngredientses) {
		this.menuItemIngredientses = menuItemIngredientses;
	}

}
