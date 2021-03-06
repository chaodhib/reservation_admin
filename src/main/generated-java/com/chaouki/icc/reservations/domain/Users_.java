/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/main/java/domain/EntityMeta_.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.chaouki.icc.reservations.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Users.class)
public abstract class Users_ {

    // Raw attributes
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, String> login;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> firstname;
    public static volatile SingularAttribute<Users, String> lastname;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> langue;

    // Many to one
    public static volatile SingularAttribute<Users, Roles> role;
}