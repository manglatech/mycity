package com.mgt.findmycity.domain;
// Generated Feb 1, 2012 11:09:16 AM by Hibernate Tools 3.1.0.beta4

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * UserRoleId generated by hbm2java
 */
@Embeddable

public class UserRoleId  implements java.io.Serializable {


    // Fields    

     private int userId;
     private int roleId;


    // Constructors

    /** default constructor */
    public UserRoleId() {
    }

    
    /** full constructor */
    public UserRoleId(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
    

   
    // Property accessors
    @Column(name="user_id", unique=false, nullable=false, insertable=true, updatable=true)

    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Column(name="role_id", unique=false, nullable=false, insertable=true, updatable=true)

    public int getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UserRoleId) ) return false;
		 UserRoleId castOther = ( UserRoleId ) other; 
         
		 return (this.getUserId()==castOther.getUserId())
 && (this.getRoleId()==castOther.getRoleId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getUserId();
         result = 37 * result + this.getRoleId();
         return result;
   }   





}
