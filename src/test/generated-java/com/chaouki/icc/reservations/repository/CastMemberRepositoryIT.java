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

import com.chaouki.icc.reservations.domain.CastMember;

/**
 * Integration test on CastMemberRepository
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class CastMemberRepositoryIT {
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(CastMemberRepositoryIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private CastMemberRepository castMemberRepository;

    @Inject
    private CastMemberGenerator castMemberGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        CastMember castMember = castMemberGenerator.getCastMember();

        // add it to a Set before saving (force equals/hashcode)
        Set<CastMember> set = newHashSet(castMember, castMember);
        assertThat(set).hasSize(1);

        castMemberRepository.save(castMember);
        entityManager.flush();

        // reload it from cache and check equality
        CastMember model = new CastMember();
        model.setId(castMember.getId());
        assertThat(castMember).isEqualTo(castMemberRepository.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // pk are equals...
        assertThat(castMember.getId()).isEqualTo(castMemberRepository.get(model).getId());

        // but since you do not use a business key, equality is lost.
        assertThat(castMember).isNotEqualTo(castMemberRepository.get(model));
    }

}