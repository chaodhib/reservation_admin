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

import com.chaouki.icc.reservations.domain.RepresentationUser;
import com.jaxio.jpa.querybyexample.GenericRepository;

/**
 * {@link GenericRepository} for {@link RepresentationUser} 
 */
@Named
@Singleton
public class RepresentationUserRepository extends GenericRepository<RepresentationUser, Integer> {

    public RepresentationUserRepository() {
        super(RepresentationUser.class);
    }

    @Override
    public RepresentationUser getNew() {
        return new RepresentationUser();
    }

    @Override
    public RepresentationUser getNewWithDefaults() {
        return getNew().withDefaults();
    }
}