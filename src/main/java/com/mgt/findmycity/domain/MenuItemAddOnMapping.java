package com.mgt.findmycity.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "menu_item_add_on_mapping", catalog = "findmycity", uniqueConstraints = {})
public class MenuItemAddOnMapping implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7419840450119907259L;
	private int id;
	private MenuItemAddOn menuItemAddOn;
	private MenuItemMapping menuItemMapping;
	private String price;

	// Constructors

	/** default constructor */
	public MenuItemAddOnMapping() {
	}

	/** full constructor */
	public MenuItemAddOnMapping(int id, MenuItemAddOn menuItemAddOn,
			MenuItemMapping menuItemMapping, String price) {
		this.id = id;
		this.menuItemAddOn = menuItemAddOn;
		this.menuItemMapping = menuItemMapping;
		this.price = price;
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
	@JoinColumn(name = "MENU_ITEM_ADD_ON_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public MenuItemAddOn getMenuItemAddOn() {
		return this.menuItemAddOn;
	}

	public void setMenuItemAddOn(MenuItemAddOn menuItemAddOn) {
		this.menuItemAddOn = menuItemAddOn;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ITEM_MAPPING_ID", unique = false, nullable = false, insertable = true, updatable = true)
	@XmlTransient
	public MenuItemMapping getMenuItemMapping() {
		return this.menuItemMapping;
	}

	public void setMenuItemMapping(MenuItemMapping menuItemMapping) {
		this.menuItemMapping = menuItemMapping;
	}

	@Column(name = "PRICE", unique = false, nullable = false, insertable = true, updatable = true, length = 45)
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
