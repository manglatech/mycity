/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/main/java/project/domain/Entity.e.vm.java
 */
package com.mgt.mycity.domain;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.validator.constraints.NotEmpty;
import com.mgt.mycity.validation.JpaUnique;

@Entity
@Table(name = "role")
@Cache(usage = NONSTRICT_READ_WRITE)
@JpaUnique
public class Role implements Identifiable<Integer>, Serializable, Copyable<Role> {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Role.class);

    // Raw attributes
    private String roleName; // not null
    private Integer roleId; // pk

    // ---------------------------
    // Constructors
    // ---------------------------

    public Role() {
    }

    public Role(Integer primaryKey) {
        setPrimaryKey(primaryKey);
    }

    // ---------------------------
    // Identifiable implementation
    // ---------------------------

    @Override
    @Transient
    @XmlTransient
    public Integer getPrimaryKey() {
        return getRoleId();
    }

    @Override
    public void setPrimaryKey(Integer roleId) {
        setRoleId(roleId);
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isPrimaryKeySet() {
        return isRoleIdSet();
    }

    // -------------------------------
    // Getter & Setter
    // -------------------------------

    // -- [roleName] ------------------------

    @NotEmpty
    @Size(max = 26)
    @Column(name = "role_name", nullable = false, length = 26)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    // -- [roleId] ------------------------

    @Column(name = "role_id", nullable = false, unique = true, precision = 10)
    @GeneratedValue
    @Id
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Transient
    public boolean isRoleIdSet() {
        return roleId != null;
    }

    // -----------------------------------------
    // Set defaults values
    // -----------------------------------------

    /**
     * Set the default values.
     */
    public void initDefaultValues() {
    }

    // -----------------------------------------
    // equals and hashCode
    // -----------------------------------------

    // The first time equals or hashCode is called,
    // we check if the primary key is present or not.
    // If yes: we use it in equals/hashCode
    // If no: we use a VMID during the entire life of this
    // instance even if later on this instance is assigned
    // a primary key.

    @Override
    public boolean equals(Object role) {
        if (this == role) {
            return true;
        }

        if (!(role instanceof Role)) {
            return false;
        }

        Role other = (Role) role;
        return _getUid().equals(other._getUid());
    }

    @Override
    public int hashCode() {
        return _getUid().hashCode();
    }

    private Object _uid;

    private Object _getUid() {
        if (_uid == null) {
            if (isPrimaryKeySet()) {
                _uid = getPrimaryKey();
            } else {
                _uid = new java.rmi.dgc.VMID();
                log
                        .warn("DEVELOPER: hashCode has changed!."
                                + "If you encounter this message you should take the time to carefuly review equals/hashCode for: "
                                + getClass().getCanonicalName());
            }
        }
        return _uid;
    }

    // -----------------------------------------
    // toString
    // -----------------------------------------

    /**
     * Construct a readable string representation for this Role instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("role.roleName=[").append(getRoleName()).append("]\n");
        result.append("role.roleId=[").append(getRoleId()).append("]\n");
        return result.toString();
    }

    // -----------------------------------------
    // Copyable Implementation
    // (Support for REST web layer)
    // -----------------------------------------

    /**
     * Return a copy of the current object
     */
    @Override
    public Role copy() {
        Role role = new Role();
        copyTo(role);
        return role;
    }

    /**
     * Copy the current properties to the given object
     */
    @Override
    public void copyTo(Role role) {
        role.setRoleName(getRoleName());
        role.setRoleId(getRoleId());
    }
}