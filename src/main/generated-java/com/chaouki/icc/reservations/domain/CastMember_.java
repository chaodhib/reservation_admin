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

@StaticMetamodel(CastMember.class)
public abstract class CastMember_ {

    // Raw attributes
    public static volatile SingularAttribute<CastMember, Integer> id;

    // Many to one
    public static volatile SingularAttribute<CastMember, Artists> artist;
    public static volatile SingularAttribute<CastMember, Types> type;
    public static volatile SingularAttribute<CastMember, Shows> show;
}