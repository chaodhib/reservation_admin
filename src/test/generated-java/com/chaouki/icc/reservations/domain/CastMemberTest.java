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
 * Basic tests for CastMember
 */
@SuppressWarnings("unused")
public class CastMemberTest {

    // test unique primary key
    @Test
    public void newInstanceHasNoPrimaryKey() {
        CastMember model = new CastMember();
        assertThat(model.isIdSet()).isFalse();
    }

    @Test
    public void isIdSetReturnsTrue() {
        CastMember model = new CastMember();
        model.setId(ValueGenerator.getUniqueInteger());
        assertThat(model.getId()).isNotNull();
        assertThat(model.isIdSet()).isTrue();
    }

    //-------------------------------------------------------------
    // Many to One:  CastMember.artist ==> Artists.id
    //-------------------------------------------------------------

    @Test
    public void manyToOne_setArtist() {
        CastMember many = new CastMember();

        // init
        Artists one = new Artists();
        one.setId(ValueGenerator.getUniqueInteger());
        many.setArtist(one);

        // make sure it is propagated properly
        assertThat(many.getArtist()).isEqualTo(one);

        // now set it to back to null
        many.setArtist(null);

        // make sure null is propagated properly
        assertThat(many.getArtist()).isNull();
    }

    @Test
    public void manyToOne_setType() {
        CastMember many = new CastMember();

        // init
        Types one = new Types();
        one.setId(ValueGenerator.getUniqueInteger());
        many.setType(one);

        // make sure it is propagated properly
        assertThat(many.getType()).isEqualTo(one);

        // now set it to back to null
        many.setType(null);

        // make sure null is propagated properly
        assertThat(many.getType()).isNull();
    }

    @Test
    public void manyToOne_setShow() {
        CastMember many = new CastMember();

        // init
        Shows one = new Shows();
        one.setId(ValueGenerator.getUniqueInteger());
        many.setShow(one);

        // make sure it is propagated properly
        assertThat(many.getShow()).isEqualTo(one);

        // now set it to back to null
        many.setShow(null);

        // make sure null is propagated properly
        assertThat(many.getShow()).isNull();
    }

    /*
    public void equalsUsingPk() {
        CastMember model1 = new CastMember();
        CastMember model2 = new CastMember();
    
        Integer id = ValueGenerator.getUniqueInteger();
        model1.setId(id);
        model2.setId(id);
        assertThat(model1.isIdSet()).isTrue();
        assertThat(model2.isIdSet()).isTrue();
        assertThat(model1.hashCode()).isEqualTo(model2.hashCode());
        assertThat(model1).isEqualTo(model2);
        assertThat(model2).isEqualTo(model1);
    }
     */
}