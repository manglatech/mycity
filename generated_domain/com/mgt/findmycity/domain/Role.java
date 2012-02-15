package com.mgt.findmycity.domain;
// Generated Feb 14, 2012 10:55:37 AM by Hibernate Tools 3.1.0.beta4

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
 * Role generated by hbm2java
 */
@Entity
@Table(name="role"
    ,catalog="findmycity"
, uniqueConstraints = {  }
)

public class Role  implements java.io.Serializable {


    // Fields    

     private int roleId;
     private String roleName;
     private Set<UserRole> userRoles = new HashSet<UserRole>(0);


    // Constructors

    /** default constructor */
    public Role() {
    }

	/** minimal constructor */
    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }
    
    /** full constructor */
    public Role(int roleId, String roleName, Set<UserRole> userRoles) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.userRoles = userRoles;
    }
    

   
    // Property accessors
    @Id
    @Column(name="role_id", unique=true, nullable=false, insertable=true, updatable=true)

    public int getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    @Column(name="role_name", unique=false, nullable=false, insertable=true, updatable=true, length=26)

    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="role")

    public Set<UserRole> getUserRoles() {
        return this.userRoles;
    }
    
    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
   








}
