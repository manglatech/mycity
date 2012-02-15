package com.mgt.findmycity.domain;
// Generated Feb 14, 2012 10:55:37 AM by Hibernate Tools 3.1.0.beta4

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * EntityType generated by hbm2java
 */
@Entity
@Table(name="entity_type"
    ,catalog="findmycity"
, uniqueConstraints = {  }
)

public class EntityType  implements java.io.Serializable {


    // Fields    

     private int id;
     private String name;
     private String description;


    // Constructors

    /** default constructor */
    public EntityType() {
    }

	/** minimal constructor */
    public EntityType(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    /** full constructor */
    public EntityType(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
    @Column(name="NAME", unique=false, nullable=false, insertable=true, updatable=true, length=45)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    @Column(name="DESCRIPTION", unique=false, nullable=true, insertable=true, updatable=true)

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
   








}