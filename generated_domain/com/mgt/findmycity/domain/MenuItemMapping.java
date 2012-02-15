package com.mgt.findmycity.domain;
// Generated Feb 14, 2012 10:55:37 AM by Hibernate Tools 3.1.0.beta4

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


/**
 * MenuItemMapping generated by hbm2java
 */
@Entity
@Table(name="menu_item_mapping"
    ,catalog="findmycity"
, uniqueConstraints = {  }
)

public class MenuItemMapping  implements java.io.Serializable {


    // Fields    

     private int id;
     private RestaurentMenu restaurentMenu;
     private MenuItem menuItem;
     private Integer price;
     private Set<MenuItemAddOnMapping> menuItemAddOnMappings = new HashSet<MenuItemAddOnMapping>(0);


    // Constructors

    /** default constructor */
    public MenuItemMapping() {
    }

	/** minimal constructor */
    public MenuItemMapping(int id, RestaurentMenu restaurentMenu, MenuItem menuItem) {
        this.id = id;
        this.restaurentMenu = restaurentMenu;
        this.menuItem = menuItem;
    }
    
    /** full constructor */
    public MenuItemMapping(int id, RestaurentMenu restaurentMenu, MenuItem menuItem, Integer price, Set<MenuItemAddOnMapping> menuItemAddOnMappings) {
        this.id = id;
        this.restaurentMenu = restaurentMenu;
        this.menuItem = menuItem;
        this.price = price;
        this.menuItemAddOnMappings = menuItemAddOnMappings;
    }
    

   
    // Property accessors
    @Id
    @Column(name="ID", unique=true, nullable=false, insertable=true, updatable=true)

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne(cascade={},
        fetch=FetchType.LAZY)
    
        @JoinColumn(name="RESTAURENT_MENU_ID", unique=false, nullable=false, insertable=true, updatable=true)

    public RestaurentMenu getRestaurentMenu() {
        return this.restaurentMenu;
    }
    
    public void setRestaurentMenu(RestaurentMenu restaurentMenu) {
        this.restaurentMenu = restaurentMenu;
    }
    @ManyToOne(cascade={},
        fetch=FetchType.LAZY)
    
        @JoinColumn(name="MENU_ITEM_ID", unique=false, nullable=false, insertable=true, updatable=true)

    public MenuItem getMenuItem() {
        return this.menuItem;
    }
    
    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
    @Column(name="PRICE", unique=false, nullable=true, insertable=true, updatable=true)

    public Integer getPrice() {
        return this.price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="menuItemMapping")

    public Set<MenuItemAddOnMapping> getMenuItemAddOnMappings() {
        return this.menuItemAddOnMappings;
    }
    
    public void setMenuItemAddOnMappings(Set<MenuItemAddOnMapping> menuItemAddOnMappings) {
        this.menuItemAddOnMappings = menuItemAddOnMappings;
    }
   








}