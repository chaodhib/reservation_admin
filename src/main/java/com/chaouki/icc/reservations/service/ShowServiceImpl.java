package com.chaouki.icc.reservations.service;

import com.chaouki.icc.reservations.domain.Locality;
import com.chaouki.icc.reservations.domain.Shows;
import com.chaouki.icc.reservations.domain.Shows_;
import com.chaouki.icc.reservations.repository.LocalityRepository;
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

    @PersistenceContext
    private EntityManager entityManager;

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
//        mergeLocality(newShow);
//        showsRepository.merge(newShow);
//    }

    private void addShow(Shows shows) {
        mergeLocality(shows);
        showsRepository.persist(shows);
    }

    private void mergeLocality(Shows shows) {
        Locality newLocality = shows.getLocation().getLocality();
        Locality savedLocality = localityRepository.getByPostalCode(StringUtils.left(newLocality.getPostalCode(), 6));
        if(savedLocality == null) {
            newLocality.setPostalCode(StringUtils.left(newLocality.getPostalCode(), 6)); // truncate to 6 characters
            localityRepository.save(newLocality);
            savedLocality = newLocality;
        }

        shows.getLocation().setLocality(savedLocality);
    }
}
