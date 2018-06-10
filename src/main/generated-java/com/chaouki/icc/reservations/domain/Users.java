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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.jaxio.jpa.querybyexample.Identifiable;

@Entity
@Table(name = "\"users\"")
public class Users implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(Users.class);

    // Raw attributes
    private Integer id;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String langue;

    // Many to one
    private Roles role;
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

    public Users id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [login] ------------------------

    @NotEmpty
    @Size(max = 30)
    @Column(name = "login", nullable = false, length = 30)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Users login(String login) {
        setLogin(login);
        return this;
    }
    // -- [password] ------------------------

    @NotEmpty
    @Size(max = 255)
    @Column(name = "\"password\"", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users password(String password) {
        setPassword(password);
        return this;
    }
    // -- [firstname] ------------------------

    @NotEmpty
    @Size(max = 60)
    @Column(name = "firstname", nullable = false, length = 60)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Users firstname(String firstname) {
        setFirstname(firstname);
        return this;
    }
    // -- [lastname] ------------------------

    @NotEmpty
    @Size(max = 60)
    @Column(name = "lastname", nullable = false, length = 60)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Users lastname(String lastname) {
        setLastname(lastname);
        return this;
    }
    // -- [email] ------------------------

    @Email
    @NotEmpty
    @Size(max = 100)
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users email(String email) {
        setEmail(email);
        return this;
    }
    // -- [langue] ------------------------

    @NotEmpty
    @Size(max = 2)
    @Column(name = "langue", nullable = false, length = 2)
    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public Users langue(String langue) {
        setLangue(langue);
        return this;
    }

    // -----------------------------------------------------------------
    // Many to One support
    // -----------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: Users.role ==> Roles.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @JoinColumn(name = "role_id", nullable = false)
    @ManyToOne(cascade = { PERSIST, MERGE }, fetch = LAZY)
    public Roles getRole() {
        return role;
    }

    /**
     * Set the {@link #role} without adding this Users instance on the passed {@link #role}
     */
    public void setRole(Roles role) {
        this.role = role;
    }

    public Users role(Roles role) {
        setRole(role);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Users withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Users && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Users instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("login", getLogin()) //
                .add("password", "XXXX") //
                .add("firstname", getFirstname()) //
                .add("lastname", getLastname()) //
                .add("email", getEmail()) //
                .add("langue", getLangue()) //
                .toString();
    }
}