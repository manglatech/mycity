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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "restaurent_menu", catalog = "findmycity", uniqueConstraints = {})
@NamedQueries({ @NamedQuery(name = "getRestaurentMenu", query = "select rm from RestaurentMenu as rm "
		+ "where rm.restaurent.id=:id ") })
@XmlRootElement
public class RestaurentMenu implements java.io.Serializable {

	private static final long serialVersionUID = -4101944854719419080L;
	private int id;
	private MenuType menuType;
	private Restaurent restaurent;
	private Set<MenuItemMapping> menuItemMappings = new HashSet<MenuItemMapping>(
			0);

	// Constructors

	/** default constructor */
	public RestaurentMenu() {
	}

	/** minimal constructor */
	public RestaurentMenu(int id, MenuType menuType, Restaurent restaurent) {
		this.id = id;
		this.menuType = menuType;
		this.restaurent = restaurent;
	}

	/** full constructor */
	public RestaurentMenu(int id, MenuType menuType, Restaurent restaurent,
			Set<MenuItemMapping> menuItemMappings) {
		this.id = id;
		this.menuType = menuType;
		this.restaurent = restaurent;
		this.menuItemMappings = menuItemMappings;
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
	@JoinColumn(name = "MENU_TYPE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public MenuType getMenuType() {
		return this.menuType;
	}

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "RESTAURENT_ID", unique = false, nullable = false, insertable = true, updatable = true)
	@XmlTransient
	public Restaurent getRestaurent() {
		return this.restaurent;
	}

	public void setRestaurent(Restaurent restaurent) {
		this.restaurent = restaurent;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "restaurentMenu")
	public Set<MenuItemMapping> getMenuItemMappings() {
		return this.menuItemMappings;
	}

	public void setMenuItemMappings(Set<MenuItemMapping> menuItemMappings) {
		this.menuItemMappings = menuItemMappings;
	}

}
