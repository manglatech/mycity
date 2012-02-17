package com.mgt.findmycity.domain;
// Generated Feb 17, 2012 3:11:56 PM by Hibernate Tools 3.1.0.beta4

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Delivery generated by hbm2java
 */
@Entity
@Table(name="delivery"
    ,catalog="findmycity"
, uniqueConstraints = {  }
)

public class Delivery  implements java.io.Serializable {


    // Fields    

     private int restaurentId;
     private Restaurent restaurent;
     private Integer minTime;
     private Integer maxTime;
     private Integer minAmount;
     private Integer maxAmount;
     private Integer charge;
     private String toTime;
     private String fromTime;


    // Constructors

    /** default constructor */
    public Delivery() {
    }

	/** minimal constructor */
    public Delivery(int restaurentId, Restaurent restaurent) {
        this.restaurentId = restaurentId;
        this.restaurent = restaurent;
    }
    
    /** full constructor */
    public Delivery(int restaurentId, Restaurent restaurent, Integer minTime, Integer maxTime, Integer minAmount, Integer maxAmount, Integer charge, String toTime, String fromTime) {
        this.restaurentId = restaurentId;
        this.restaurent = restaurent;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.charge = charge;
        this.toTime = toTime;
        this.fromTime = fromTime;
    }
    

   
    // Property accessors
    @Id
    @Column(name="RESTAURENT_ID", unique=true, nullable=false, insertable=true, updatable=true)

    public int getRestaurentId() {
        return this.restaurentId;
    }
    
    public void setRestaurentId(int restaurentId) {
        this.restaurentId = restaurentId;
    }
    @ManyToOne(cascade={},
        fetch=FetchType.LAZY)
    
        @JoinColumn(name="RESTAURENT_ID", unique=true, nullable=false, insertable=false, updatable=false)

    public Restaurent getRestaurent() {
        return this.restaurent;
    }
    
    public void setRestaurent(Restaurent restaurent) {
        this.restaurent = restaurent;
    }
    @Column(name="MIN_TIME", unique=false, nullable=true, insertable=true, updatable=true)

    public Integer getMinTime() {
        return this.minTime;
    }
    
    public void setMinTime(Integer minTime) {
        this.minTime = minTime;
    }
    @Column(name="MAX_TIME", unique=false, nullable=true, insertable=true, updatable=true)

    public Integer getMaxTime() {
        return this.maxTime;
    }
    
    public void setMaxTime(Integer maxTime) {
        this.maxTime = maxTime;
    }
    @Column(name="MIN_AMOUNT", unique=false, nullable=true, insertable=true, updatable=true)

    public Integer getMinAmount() {
        return this.minAmount;
    }
    
    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }
    @Column(name="MAX_AMOUNT", unique=false, nullable=true, insertable=true, updatable=true)

    public Integer getMaxAmount() {
        return this.maxAmount;
    }
    
    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }
    @Column(name="CHARGE", unique=false, nullable=true, insertable=true, updatable=true)

    public Integer getCharge() {
        return this.charge;
    }
    
    public void setCharge(Integer charge) {
        this.charge = charge;
    }
    @Column(name="TO_TIME", unique=false, nullable=true, insertable=true, updatable=true, length=4)

    public String getToTime() {
        return this.toTime;
    }
    
    public void setToTime(String toTime) {
        this.toTime = toTime;
    }
    @Column(name="FROM_TIME", unique=false, nullable=true, insertable=true, updatable=true, length=4)

    public String getFromTime() {
        return this.fromTime;
    }
    
    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }
   








}
