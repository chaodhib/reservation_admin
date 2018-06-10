/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/main/java/domain/EntityMeta_.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.chaouki.icc.reservations.domain;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Representations.class)
public abstract class Representations_ {

    // Raw attributes
    public static volatile SingularAttribute<Representations, Integer> id;
    public static volatile SingularAttribute<Representations, Date> when;

    // Many to one
    public static volatile SingularAttribute<Representations, Shows> show;
    public static volatile SingularAttribute<Representations, Locations> location;
}