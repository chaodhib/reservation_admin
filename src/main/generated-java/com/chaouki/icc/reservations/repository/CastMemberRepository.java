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

import com.chaouki.icc.reservations.domain.CastMember;
import com.jaxio.jpa.querybyexample.GenericRepository;

/**
 * {@link GenericRepository} for {@link CastMember} 
 */
@Named
@Singleton
public class CastMemberRepository extends GenericRepository<CastMember, Integer> {

    public CastMemberRepository() {
        super(CastMember.class);
    }

    @Override
    public CastMember getNew() {
        return new CastMember();
    }

    @Override
    public CastMember getNewWithDefaults() {
        return getNew().withDefaults();
    }
}