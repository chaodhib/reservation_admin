/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/SearchForm.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.chaouki.icc.reservations.web.domain;

import static com.jaxio.jpa.querybyexample.PropertySelector.newPropertySelector;

import javax.inject.Named;

import com.chaouki.icc.reservations.domain.Artists;
import com.chaouki.icc.reservations.domain.Artists_;
import com.chaouki.icc.reservations.web.domain.support.GenericSearchForm;
import com.chaouki.icc.reservations.web.faces.ConversationContextScoped;
import com.jaxio.jpa.querybyexample.PropertySelector;
import com.jaxio.jpa.querybyexample.SearchParameters;

/**
 * View Helper to search {@link Artists}.
 * It exposes a {@link Artists} instance so it can be used in search by-example-query.
 */
@Named
@ConversationContextScoped
public class ArtistsSearchForm extends GenericSearchForm<Artists, Integer, ArtistsSearchForm> {
    private static final long serialVersionUID = 1L;
    protected Artists artists = new Artists();
    protected PropertySelector<Artists, String> firstnameSelector = newPropertySelector(Artists_.firstname);
    protected PropertySelector<Artists, String> lastnameSelector = newPropertySelector(Artists_.lastname);

    public Artists getArtists() {
        return artists;
    }

    @Override
    protected Artists getEntity() {
        return getArtists();
    }

    @Override
    public ArtistsSearchForm newInstance() {
        return new ArtistsSearchForm();
    }

    @Override
    public SearchParameters toSearchParameters() {
        SearchParameters sp = searchParameters();
        sp.property(firstnameSelector, lastnameSelector);
        return sp;
    }

    @Override
    public void resetWithOther(ArtistsSearchForm other) {
        this.artists = other.getArtists();
        this.firstnameSelector = other.getFirstnameSelector();
        this.lastnameSelector = other.getLastnameSelector();
    }

    // Property selectors
    public PropertySelector<Artists, String> getFirstnameSelector() {
        return firstnameSelector;
    }

    public PropertySelector<Artists, String> getLastnameSelector() {
        return lastnameSelector;
    }
}
