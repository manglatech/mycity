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
@Table(name = "photo")
@Cache(usage = NONSTRICT_READ_WRITE)
@JpaUnique
public class Photo implements Identifiable<Integer>, Serializable, Copyable<Photo> {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Photo.class);

    // Raw attributes
    private Integer id; // pk
    private String name;
    private String desc;
    private String location; // not null

    // ---------------------------
    // Constructors
    // ---------------------------

    public Photo() {
    }

    public Photo(Integer primaryKey) {
        setPrimaryKey(primaryKey);
    }

    // ---------------------------
    // Identifiable implementation
    // ---------------------------

    @Override
    @Transient
    @XmlTransient
    public Integer getPrimaryKey() {
        return getId();
    }

    @Override
    public void setPrimaryKey(Integer id) {
        setId(id);
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isPrimaryKeySet() {
        return isIdSet();
    }

    // -------------------------------
    // Getter & Setter
    // -------------------------------

    // -- [id] ------------------------

    @Column(name = "ID", nullable = false, unique = true, precision = 10)
    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Transient
    public boolean isIdSet() {
        return id != null;
    }

    // -- [name] ------------------------

    @Size(max = 26)
    @Column(name = "NAME", length = 26)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // -- [desc] ------------------------

    @Size(max = 100)
    @Column(name = "`DESC`", length = 100)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    // -- [location] ------------------------

    @NotEmpty
    @Size(max = 256)
    @Column(name = "LOCATION", nullable = false, length = 256)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
    public boolean equals(Object photo) {
        if (this == photo) {
            return true;
        }

        if (!(photo instanceof Photo)) {
            return false;
        }

        Photo other = (Photo) photo;
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
     * Construct a readable string representation for this Photo instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("photo.id=[").append(getId()).append("]\n");
        result.append("photo.name=[").append(getName()).append("]\n");
        result.append("photo.desc=[").append(getDesc()).append("]\n");
        result.append("photo.location=[").append(getLocation()).append("]\n");
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
    public Photo copy() {
        Photo photo = new Photo();
        copyTo(photo);
        return photo;
    }

    /**
     * Copy the current properties to the given object
     */
    @Override
    public void copyTo(Photo photo) {
        photo.setId(getId());
        photo.setName(getName());
        photo.setDesc(getDesc());
        photo.setLocation(getLocation());
    }
}