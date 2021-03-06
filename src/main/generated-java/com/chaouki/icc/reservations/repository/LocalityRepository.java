/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/main/java/repository/Repository.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.chaouki.icc.reservations.repository;

import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.transaction.annotation.Transactional;

import com.chaouki.icc.reservations.domain.Locality;
import com.jaxio.jpa.querybyexample.GenericRepository;

/**
 * {@link GenericRepository} for {@link Locality} 
 */
@Named
@Singleton
public class LocalityRepository extends GenericRepository<Locality, Integer> {

    public LocalityRepository() {
        super(Locality.class);
    }

    @Override
    public Locality getNew() {
        return new Locality();
    }

    @Override
    public Locality getNewWithDefaults() {
        return getNew().withDefaults();
    }

    /**
     * Return the persistent instance of {@link Locality} with the given unique property value postalCode,
     * or null if there is no such persistent instance.
     *
     * @param postalCode the unique value
     * @return the corresponding {@link Locality} persistent instance or null
     */
    @Transactional(readOnly = true)
    public Locality getByPostalCode(String postalCode) {
        return findUniqueOrNone(new Locality().postalCode(postalCode));
    }

    /**
     * Delete a {@link Locality} using the unique column postalCode
     *
     * @param postalCode the unique value
     */
    @Transactional
    public void deleteByPostalCode(String postalCode) {
        delete(getByPostalCode(postalCode));
    }

    /**
     * Return the persistent instance of {@link Locality} with the given unique property value locality2,
     * or null if there is no such persistent instance.
     *
     * @param locality2 the unique value
     * @return the corresponding {@link Locality} persistent instance or null
     */
    @Transactional(readOnly = true)
    public Locality getByLocality2(String locality2) {
        return findUniqueOrNone(new Locality().locality2(locality2));
    }

    /**
     * Delete a {@link Locality} using the unique column locality2
     *
     * @param locality2 the unique value
     */
    @Transactional
    public void deleteByLocality2(String locality2) {
        delete(getByLocality2(locality2));
    }
}