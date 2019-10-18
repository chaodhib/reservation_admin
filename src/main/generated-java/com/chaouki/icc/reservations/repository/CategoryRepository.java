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

import com.chaouki.icc.reservations.domain.Category;
import com.jaxio.jpa.querybyexample.GenericRepository;

/**
 * {@link GenericRepository} for {@link Category} 
 */
@Named
@Singleton
public class CategoryRepository extends GenericRepository<Category, Integer> {

    public CategoryRepository() {
        super(Category.class);
    }

    @Override
    public Category getNew() {
        return new Category();
    }

    @Override
    public Category getNewWithDefaults() {
        return getNew().withDefaults();
    }
}