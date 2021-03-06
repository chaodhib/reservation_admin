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
import static com.jaxio.jpa.querybyexample.Range.newRange;

import javax.inject.Named;

import com.chaouki.icc.reservations.domain.RepresentationUser;
import com.chaouki.icc.reservations.domain.RepresentationUser_;
import com.chaouki.icc.reservations.domain.Representations;
import com.chaouki.icc.reservations.domain.Users;
import com.chaouki.icc.reservations.web.domain.support.GenericSearchForm;
import com.chaouki.icc.reservations.web.faces.ConversationContextScoped;
import com.jaxio.jpa.querybyexample.PropertySelector;
import com.jaxio.jpa.querybyexample.Range;
import com.jaxio.jpa.querybyexample.SearchParameters;

/**
 * View Helper to search {@link RepresentationUser}.
 * It exposes a {@link RepresentationUser} instance so it can be used in search by-example-query.
 */
@Named
@ConversationContextScoped
public class RepresentationUserSearchForm extends GenericSearchForm<RepresentationUser, Integer, RepresentationUserSearchForm> {
    private static final long serialVersionUID = 1L;
    protected RepresentationUser representationUser = new RepresentationUser();
    protected Range<RepresentationUser, Integer> placesRange = newRange(RepresentationUser_.places);
    protected PropertySelector<RepresentationUser, Integer> placesSelector = newPropertySelector(RepresentationUser_.places);
    protected PropertySelector<RepresentationUser, Users> userSelector = newPropertySelector(RepresentationUser_.user);
    protected PropertySelector<RepresentationUser, Representations> representationSelector = newPropertySelector(RepresentationUser_.representation);

    public RepresentationUser getRepresentationUser() {
        return representationUser;
    }

    @Override
    protected RepresentationUser getEntity() {
        return getRepresentationUser();
    }

    @Override
    public RepresentationUserSearchForm newInstance() {
        return new RepresentationUserSearchForm();
    }

    @Override
    public SearchParameters toSearchParameters() {
        SearchParameters sp = searchParameters();
        sp.range(placesRange);
        sp.property(placesSelector);
        sp.property(userSelector, representationSelector);
        return sp;
    }

    @Override
    public void resetWithOther(RepresentationUserSearchForm other) {
        this.representationUser = other.getRepresentationUser();
        this.placesRange = other.getPlacesRange();
        this.placesSelector = other.getPlacesSelector();
        this.userSelector = other.getUserSelector();
        this.representationSelector = other.getRepresentationSelector();
    }

    // Ranges
    public Range<RepresentationUser, Integer> getPlacesRange() {
        return placesRange;
    }

    // Property selectors
    public PropertySelector<RepresentationUser, Integer> getPlacesSelector() {
        return placesSelector;
    }

    // Relation selectors
    public PropertySelector<RepresentationUser, Users> getUserSelector() {
        return userSelector;
    }

    public PropertySelector<RepresentationUser, Representations> getRepresentationSelector() {
        return representationSelector;
    }
}
