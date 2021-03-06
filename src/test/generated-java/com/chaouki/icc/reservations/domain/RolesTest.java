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
 * Basic tests for Roles
 */
@SuppressWarnings("unused")
public class RolesTest {

    // test unique primary key
    @Test
    public void newInstanceHasNoPrimaryKey() {
        Roles model = new Roles();
        assertThat(model.isIdSet()).isFalse();
    }

    @Test
    public void isIdSetReturnsTrue() {
        Roles model = new Roles();
        model.setId(ValueGenerator.getUniqueInteger());
        assertThat(model.getId()).isNotNull();
        assertThat(model.isIdSet()).isTrue();
    }

    /*
    public void equalsUsingPk() {
        Roles model1 = new Roles();
        Roles model2 = new Roles();
    
        Integer id = ValueGenerator.getUniqueInteger();
        model1.setId(id);
        model2.setId(id);
    
        model1.setRole("a");
        model2.setRole("a");
        assertThat(model1.isIdSet()).isTrue();
        assertThat(model2.isIdSet()).isTrue();
        assertThat(model1.hashCode()).isEqualTo(model2.hashCode());
        assertThat(model1).isEqualTo(model2);
        assertThat(model2).isEqualTo(model1);
    }
     */
}