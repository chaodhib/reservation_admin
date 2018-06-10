/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/test/java/service/ModelGenerator.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.chaouki.icc.reservations.repository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.chaouki.icc.reservations.domain.Localities;
import com.chaouki.icc.reservations.domain.Locations;
import com.chaouki.icc.reservations.util.ValueGenerator;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Named
@Singleton
public class LocationsGenerator {

    /**
     * Returns a new Locations instance filled with random values.
     */
    public Locations getLocations() {
        Locations locations = new Locations();

        // simple attributes follows
        locations.setSlug(ValueGenerator.getUniqueString(60));
        locations.setDesignation("a");
        locations.setAddress("a");
        locations.setWebsite("a");
        locations.setPhone("a");
        // mandatory relation
        Localities locality = localitiesGenerator.getLocalities();
        localitiesRepository.save(locality);
        locations.setLocality(locality);
        return locations;
    }

    @Inject
    private LocalitiesRepository localitiesRepository;
    @Inject
    private LocalitiesGenerator localitiesGenerator;
}