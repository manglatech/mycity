package com.mgt.findmycity.domain;
// Generated Feb 8, 2012 12:31:46 PM by Hibernate Tools 3.1.0.beta4

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Category generated by hbm2java
 */
@Entity
@Table(name="category"
    ,catalog="findmycity"
, uniqueConstraints = {  }
)

public class Category  implements java.io.Serializable {


    // Fields    

     private int categoryId;
     private String name;
     private String desc;
     private Set<RestaurentCategory> restaurentCategories = new HashSet<RestaurentCategory>(0);


    // Constructors

    /** default constructor */
    public Category() {
    }

	/** minimal constructor */
    public Category(int categoryId, String name, String desc) {
        this.categoryId = categoryId;
        this.name = name;
        this.desc = desc;
    }
    
    /** full constructor */
    public Category(int categoryId, String name, String desc, Set<RestaurentCategory> restaurentCategories) {
        this.categoryId = categoryId;
        this.name = name;
        this.desc = desc;
        this.restaurentCategories = restaurentCategories;
    }
    

   
    // Property accessors
    @Id
    @Column(name="CATEGORY_ID", unique=true, nullable=false, insertable=true, updatable=true)

    public int getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    @Column(name="NAME", unique=false, nullable=false, insertable=true, updatable=true, length=45)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    @Column(name="DESC", unique=false, nullable=false, insertable=true, updatable=true, length=45)

    public String getDesc() {
        return this.desc;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }
    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="category")

    public Set<RestaurentCategory> getRestaurentCategories() {
        return this.restaurentCategories;
    }
    
    public void setRestaurentCategories(Set<RestaurentCategory> restaurentCategories) {
        this.restaurentCategories = restaurentCategories;
    }
   








}
