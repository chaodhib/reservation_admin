/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/test/java/service/ModelGenerator.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.chaouki.icc.reservations.repository;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.chaouki.icc.reservations.domain.Representations;
import com.chaouki.icc.reservations.domain.Shows;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Named
@Singleton
public class RepresentationsGenerator {

    /**
     * Returns a new Representations instance filled with random values.
     */
    public Representations getRepresentations() {
        Representations representations = new Representations();

        // simple attributes follows
        representations.setWhen(new Date());
        // mandatory relation
        Shows show = showsGenerator.getShows();
        showsRepository.save(show);
        representations.setShow(show);
        return representations;
    }

    @Inject
    private ShowsRepository showsRepository;
    @Inject
    private ShowsGenerator showsGenerator;
}