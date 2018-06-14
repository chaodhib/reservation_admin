package com.chaouki.icc.reservations.service;

import com.chaouki.icc.reservations.domain.Locality;
import com.chaouki.icc.reservations.domain.Locations;
import com.chaouki.icc.reservations.domain.Shows;
import com.chaouki.icc.reservations.domain.Shows_;
import com.chaouki.icc.reservations.repository.LocalityRepository;
import com.chaouki.icc.reservations.repository.LocationsRepository;
import com.chaouki.icc.reservations.repository.ShowsRepository;
import com.jaxio.jpa.querybyexample.SearchParameters;
import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.jaxio.jpa.querybyexample.PropertySelector.newPropertySelector;

@Singleton
@Named("showService")
public class ShowServiceImpl implements ShowService {

    @Inject
    private ShowsRepository showsRepository;

    @Inject
    private LocalityRepository localityRepository;

    @Inject
    private LocationsRepository locationsRepository;

    @Override
    @Transactional
    public Integer importShows(List<Shows> showsList) {
        Integer count = 0;
        for (Shows shows : showsList) {
            if (!showExistAlready(shows.getSlug())){
                addShow(shows);
                count++;
            } else {
//                mergeShow(shows);
            }
        }
        return count;
    }

    private boolean showExistAlready(String slug) {
        SearchParameters searchParameters = new SearchParameters();
        searchParameters.property(newPropertySelector(Shows_.slug).selected(slug));
        int count = showsRepository.findCount(searchParameters);
        return count > 0;
    }

    // not ready:
//    private void mergeShow(Shows newShow) {
//        SearchParameters searchParameters = new SearchParameters();
//        searchParameters.property(newPropertySelector(Shows_.slug).selected(newShow.getSlug()));
//        List<Shows> savedShows = showsRepository.find(searchParameters);
//        if(savedShows.size() != 1)
//            throw new IllegalStateException();
//
//        Integer id = savedShows.get(0).getId();
//        newShow.setId(id);
//        fetchOrSaveLocality(newShow);
//        showsRepository.merge(newShow);
//    }

    private void addShow(Shows shows) {
        fetchOrSaveLocality(shows);
        fetchOrSaveLocation(shows);
        showsRepository.persist(shows);
    }

    private void fetchOrSaveLocality(Shows shows) {
        Locality savedLocality = localityRepository.getByPostalCode(shows.getLocation().getLocality().getPostalCode());
        if(savedLocality == null) {
            Locality newLocality = shows.getLocation().getLocality();
            newLocality.setPostalCode(newLocality.getPostalCode());
            localityRepository.save(newLocality);
            savedLocality = newLocality;
        }

        shows.getLocation().setLocality(savedLocality);
    }

    private void fetchOrSaveLocation(Shows shows) {
        Locations savedLocation = locationsRepository.getBySlug(shows.getLocation().getSlug());
        if(savedLocation == null) {
            Locations newLocation = shows.getLocation();
            locationsRepository.save(newLocation);
            savedLocation = newLocation;
        }

        shows.setLocation(savedLocation);
    }
}
