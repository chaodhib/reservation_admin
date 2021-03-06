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

import com.chaouki.icc.reservations.domain.Locality;
import com.chaouki.icc.reservations.domain.Locations;
import com.chaouki.icc.reservations.domain.Locations_;
import com.chaouki.icc.reservations.web.domain.support.GenericSearchForm;
import com.chaouki.icc.reservations.web.faces.ConversationContextScoped;
import com.jaxio.jpa.querybyexample.PropertySelector;
import com.jaxio.jpa.querybyexample.SearchParameters;

/**
 * View Helper to search {@link Locations}.
 * It exposes a {@link Locations} instance so it can be used in search by-example-query.
 */
@Named
@ConversationContextScoped
public class LocationsSearchForm extends GenericSearchForm<Locations, Integer, LocationsSearchForm> {
    private static final long serialVersionUID = 1L;
    protected Locations locations = new Locations();
    protected PropertySelector<Locations, String> slugSelector = newPropertySelector(Locations_.slug);
    protected PropertySelector<Locations, String> designationSelector = newPropertySelector(Locations_.designation);
    protected PropertySelector<Locations, String> addressSelector = newPropertySelector(Locations_.address);
    protected PropertySelector<Locations, String> websiteSelector = newPropertySelector(Locations_.website);
    protected PropertySelector<Locations, String> phoneSelector = newPropertySelector(Locations_.phone);
    protected PropertySelector<Locations, Locality> localitySelector = newPropertySelector(Locations_.locality);

    public Locations getLocations() {
        return locations;
    }

    @Override
    protected Locations getEntity() {
        return getLocations();
    }

    @Override
    public LocationsSearchForm newInstance() {
        return new LocationsSearchForm();
    }

    @Override
    public SearchParameters toSearchParameters() {
        SearchParameters sp = searchParameters();
        sp.property(slugSelector, designationSelector, addressSelector, websiteSelector, phoneSelector);
        sp.property(localitySelector);
        return sp;
    }

    @Override
    public void resetWithOther(LocationsSearchForm other) {
        this.locations = other.getLocations();
        this.slugSelector = other.getSlugSelector();
        this.designationSelector = other.getDesignationSelector();
        this.addressSelector = other.getAddressSelector();
        this.websiteSelector = other.getWebsiteSelector();
        this.phoneSelector = other.getPhoneSelector();
        this.localitySelector = other.getLocalitySelector();
    }

    // Property selectors
    public PropertySelector<Locations, String> getSlugSelector() {
        return slugSelector;
    }

    public PropertySelector<Locations, String> getDesignationSelector() {
        return designationSelector;
    }

    public PropertySelector<Locations, String> getAddressSelector() {
        return addressSelector;
    }

    public PropertySelector<Locations, String> getWebsiteSelector() {
        return websiteSelector;
    }

    public PropertySelector<Locations, String> getPhoneSelector() {
        return phoneSelector;
    }

    // Relation selectors
    public PropertySelector<Locations, Locality> getLocalitySelector() {
        return localitySelector;
    }
}
