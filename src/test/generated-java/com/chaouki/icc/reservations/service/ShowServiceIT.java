package com.chaouki.icc.reservations.service;

import com.chaouki.icc.reservations.domain.Locality;
import com.chaouki.icc.reservations.domain.Locations;
import com.chaouki.icc.reservations.domain.Shows;
import com.chaouki.icc.reservations.repository.ShowsRepository;
import com.jaxio.jpa.querybyexample.SearchParameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
public class ShowServiceIT {

    @Inject
    private ShowService showService;

    @Inject
    private ShowsRepository showsRepository;

    @Test
    public void importShows() {
        int initialCount = showsRepository.findCount(new SearchParameters());

        ArrayList<Shows> showsList = new ArrayList<>();
        Shows shows = new Shows();
        shows.setPrice(54.1);
        shows.setPosterUrl("https://www.w3schools.com/Html/html_urlencode.asp");
        shows.setBookable(true);
        shows.setSlug("slug");
        shows.setTitle("title");

        Locations location = new Locations();
        Locality locality = new Locality();
        locality.setPostalCode("ABCDEFGH");
        locality.setLocality2("LOCALITY");
        location.setLocality(locality);
        location.setWebsite("website");
        location.setPhone("phone");
        location.setDesignation("desgination");
        location.setAddress("address");
        location.setSlug("slug");
        shows.setLocation(location);
        showsList.add(shows);

        Integer changed = showService.importShows(showsList);

        int afterCount = showsRepository.findCount(new SearchParameters());
        Assert.assertThat(afterCount, is(initialCount + changed));
    }
}