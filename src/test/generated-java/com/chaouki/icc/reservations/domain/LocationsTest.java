/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/test/java/domain/ModelTest.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.chaouki.icc.reservations.domain;

import static org.fest.assertions.Assertions.assertThat;

import java.io.*;
import java.util.*;

import org.junit.Test;

import com.chaouki.icc.reservations.util.ValueGenerator;

/**
 * Basic tests for Locations
 */
@SuppressWarnings("unused")
public class LocationsTest {

    // test unique primary key
    @Test
    public void newInstanceHasNoPrimaryKey() {
        Locations model = new Locations();
        assertThat(model.isIdSet()).isFalse();
    }

    @Test
    public void isIdSetReturnsTrue() {
        Locations model = new Locations();
        model.setId(ValueGenerator.getUniqueInteger());
        assertThat(model.getId()).isNotNull();
        assertThat(model.isIdSet()).isTrue();
    }

    //-------------------------------------------------------------
    // Many to One:  Locations.locality ==> Locality.id
    //-------------------------------------------------------------

    @Test
    public void manyToOne_setLocality() {
        Locations many = new Locations();

        // init
        Locality one = new Locality();
        one.setId(ValueGenerator.getUniqueInteger());
        many.setLocality(one);

        // make sure it is propagated properly
        assertThat(many.getLocality()).isEqualTo(one);

        // now set it to back to null
        many.setLocality(null);

        // make sure null is propagated properly
        assertThat(many.getLocality()).isNull();
    }

    @Test
    public void equalsUsingBusinessKey() {
        Locations model1 = new Locations();
        Locations model2 = new Locations();
        String slug = ValueGenerator.getUniqueString(60);
        model1.setSlug(slug);
        model2.setSlug(slug);
        assertThat(model1).isEqualTo(model2);
        assertThat(model2).isEqualTo(model1);
        assertThat(model1.hashCode()).isEqualTo(model2.hashCode());
    }
}