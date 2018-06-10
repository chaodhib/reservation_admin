/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/Controller.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.chaouki.icc.reservations.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.chaouki.icc.reservations.domain.Locations;
import com.chaouki.icc.reservations.domain.Locations_;
import com.chaouki.icc.reservations.printer.LocationsPrinter;
import com.chaouki.icc.reservations.repository.LocationsRepository;
import com.chaouki.icc.reservations.web.domain.support.GenericController;
import com.chaouki.icc.reservations.web.permission.LocationsPermission;
import com.jaxio.jpa.querybyexample.SearchParameters;

/**
 * Stateless controller for {@link Locations} conversation start.
 */
@Named
@Singleton
public class LocationsController extends GenericController<Locations, Integer> {
    public static final String LOCATIONS_EDIT_URI = "/domain/locationsEdit.faces";
    public static final String LOCATIONS_SELECT_URI = "/domain/locationsSelect.faces";

    @Inject
    public LocationsController(LocationsRepository locationsRepository, LocationsPermission locationsPermission, LocationsPrinter locationsPrinter) {
        super(locationsRepository, locationsPermission, locationsPrinter, LOCATIONS_SELECT_URI, LOCATIONS_EDIT_URI);
    }

    @Override
    protected SearchParameters defaultOrder(SearchParameters searchParameters) {
        return searchParameters.asc(Locations_.slug);
    }
}