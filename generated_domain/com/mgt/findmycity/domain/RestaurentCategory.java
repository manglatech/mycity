package com.mgt.findmycity.domain;
// Generated Feb 14, 2012 10:55:37 AM by Hibernate Tools 3.1.0.beta4

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * RestaurentCategory generated by hbm2java
 */
@Entity
@Table(name="restaurent_category"
    ,catalog="findmycity"
)

public class RestaurentCategory  implements java.io.Serializable {


    // Fields    

     private RestaurentCategoryId id;
     private Category category;
     private Restaurent restaurent;


    // Constructors

    /** default constructor */
    public RestaurentCategory() {
    }

    
    /** full constructor */
    public RestaurentCategory(RestaurentCategoryId id, Category category, Restaurent restaurent) {
        this.id = id;
        this.category = category;
        this.restaurent = restaurent;
    }
    

   
    // Property accessors
    @EmbeddedId
    @AttributeOverrides( {
        @AttributeOverride(name="restaurentId", column=@Column(name="RESTAURENT_ID", unique=false, nullable=false, insertable=true, updatable=true) ), 
        @AttributeOverride(name="categoryId", column=@Column(name="CATEGORY_ID", unique=false, nullable=false, insertable=true, updatable=true) ) } )

    public RestaurentCategoryId getId() {
        return this.id;
    }
    
    public void setId(RestaurentCategoryId id) {
        this.id = id;
    }
    @ManyToOne(cascade={},
        fetch=FetchType.LAZY)
    
        @JoinColumn(name="CATEGORY_ID", unique=false, nullable=false, insertable=false, updatable=false)

    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    @ManyToOne(cascade={},
        fetch=FetchType.LAZY)
    
        @JoinColumn(name="RESTAURENT_ID", unique=false, nullable=false, insertable=false, updatable=false)

    public Restaurent getRestaurent() {
        return this.restaurent;
    }
    
    public void setRestaurent(Restaurent restaurent) {
        this.restaurent = restaurent;
    }
   








}
