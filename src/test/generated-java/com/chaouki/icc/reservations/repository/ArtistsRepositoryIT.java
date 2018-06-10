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

import com.chaouki.icc.reservations.domain.Artists;

/**
 * Integration test on ArtistsRepository
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class ArtistsRepositoryIT {
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(ArtistsRepositoryIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private ArtistsRepository artistsRepository;

    @Inject
    private ArtistsGenerator artistsGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        Artists artists = artistsGenerator.getArtists();

        // add it to a Set before saving (force equals/hashcode)
        Set<Artists> set = newHashSet(artists, artists);
        assertThat(set).hasSize(1);

        artistsRepository.save(artists);
        entityManager.flush();

        // reload it from cache and check equality
        Artists model = new Artists();
        model.setId(artists.getId());
        assertThat(artists).isEqualTo(artistsRepository.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // pk are equals...
        assertThat(artists.getId()).isEqualTo(artistsRepository.get(model).getId());

        // but since you do not use a business key, equality is lost.
        assertThat(artists).isNotEqualTo(artistsRepository.get(model));
    }

}