/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/test/java/service/ModelGenerator.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.chaouki.icc.reservations.repository;

import javax.inject.Named;
import javax.inject.Singleton;

import com.chaouki.icc.reservations.domain.Locality;
import com.chaouki.icc.reservations.util.ValueGenerator;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Named
@Singleton
public class LocalityGenerator {

    /**
     * Returns a new Locality instance filled with random values.
     */
    public Locality getLocality() {
        Locality locality = new Locality();

        // simple attributes follows
        locality.setPostalCode(ValueGenerator.getUniqueString(7));
        locality.setLocality2(ValueGenerator.getUniqueString(60));
        return locality;
    }

}