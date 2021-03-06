/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/test/java/service/RepositoryIT.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.chaouki.icc.reservations.repository;

import static com.google.common.collect.Sets.newHashSet;
import static org.fest.assertions.Assertions.assertThat;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.chaouki.icc.reservations.domain.Types;

/**
 * Integration test on TypesRepository
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class TypesRepositoryIT {
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(TypesRepositoryIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private TypesRepository typesRepository;

    @Inject
    private TypesGenerator typesGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        Types types = typesGenerator.getTypes();

        // add it to a Set before saving (force equals/hashcode)
        Set<Types> set = newHashSet(types, types);
        assertThat(set).hasSize(1);

        typesRepository.save(types);
        entityManager.flush();

        // reload it from cache and check equality
        Types model = new Types();
        model.setId(types.getId());
        assertThat(types).isEqualTo(typesRepository.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // pk are equals...
        assertThat(types.getId()).isEqualTo(typesRepository.get(model).getId());

        // but since you do not use a business key, equality is lost.
        assertThat(types).isNotEqualTo(typesRepository.get(model));
    }

}