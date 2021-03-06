/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/main/java/domain/Entity.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.chaouki.icc.reservations.domain;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.jaxio.jpa.querybyexample.Identifiable;

@Entity
@Table(name = "representations")
public class Representations implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(Representations.class);

    // Raw attributes
    private Integer id;
    private Date when;

    // Many to one
    private Shows show;
    private Locations location;
    // -- [id] ------------------------

    @Override
    @Column(name = "id", precision = 10)
    @GeneratedValue(strategy = IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Representations id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [when] ------------------------

    @NotNull
    @Column(name = "\"when\"", nullable = false, length = 26)
    @Temporal(TIMESTAMP)
    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public Representations when(Date when) {
        setWhen(when);
        return this;
    }

    // -----------------------------------------------------------------
    // Many to One support
    // -----------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: Representations.show ==> Shows.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @JoinColumn(name = "show_id", nullable = false)
    @ManyToOne(cascade = { PERSIST, MERGE }, fetch = LAZY)
    public Shows getShow() {
        return show;
    }

    /**
     * Set the {@link #show} without adding this Representations instance on the passed {@link #show}
     */
    public void setShow(Shows show) {
        this.show = show;
    }

    public Representations show(Shows show) {
        setShow(show);
        return this;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: Representations.location ==> Locations.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @JoinColumn(name = "location_id")
    @ManyToOne(cascade = { PERSIST, MERGE }, fetch = LAZY)
    public Locations getLocation() {
        return location;
    }

    /**
     * Set the {@link #location} without adding this Representations instance on the passed {@link #location}
     */
    public void setLocation(Locations location) {
        this.location = location;
    }

    public Representations location(Locations location) {
        setLocation(location);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Representations withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Representations && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Representations instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("when", getWhen()) //
                .toString();
    }
}