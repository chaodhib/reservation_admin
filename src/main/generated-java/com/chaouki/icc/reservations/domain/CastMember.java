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
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.jaxio.jpa.querybyexample.Identifiable;

@Entity
@Table(name = "cast_member")
public class CastMember implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CastMember.class);

    // Raw attributes
    private Integer id;

    // Many to one
    private Artists artist;
    private Types type;
    private Shows show;
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

    public CastMember id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isIdSet() {
        return id != null;
    }

    // -----------------------------------------------------------------
    // Many to One support
    // -----------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: CastMember.artist ==> Artists.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @JoinColumn(name = "artist_id", nullable = false)
    @ManyToOne(cascade = { PERSIST, MERGE }, fetch = EAGER)
    public Artists getArtist() {
        return artist;
    }

    /**
     * Set the {@link #artist} without adding this CastMember instance on the passed {@link #artist}
     */
    public void setArtist(Artists artist) {
        this.artist = artist;
    }

    public CastMember artist(Artists artist) {
        setArtist(artist);
        return this;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: CastMember.type ==> Types.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @JoinColumn(name = "type_id", nullable = false)
    @ManyToOne(cascade = { PERSIST, MERGE }, fetch = EAGER)
    public Types getType() {
        return type;
    }

    /**
     * Set the {@link #type} without adding this CastMember instance on the passed {@link #type}
     */
    public void setType(Types type) {
        this.type = type;
    }

    public CastMember type(Types type) {
        setType(type);
        return this;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: CastMember.show ==> Shows.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @JoinColumn(name = "show_id", nullable = false)
    @ManyToOne(cascade = { PERSIST, MERGE }, fetch = EAGER)
    public Shows getShow() {
        return show;
    }

    /**
     * Set the {@link #show} without adding this CastMember instance on the passed {@link #show}
     */
    public void setShow(Shows show) {
        this.show = show;
    }

    public CastMember show(Shows show) {
        setShow(show);
        return this;
    }

    /**
     * Apply the default values.
     */
    public CastMember withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof CastMember && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this CastMember instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .toString();
    }
}