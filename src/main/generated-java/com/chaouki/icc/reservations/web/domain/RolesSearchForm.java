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

import com.chaouki.icc.reservations.domain.Roles;
import com.chaouki.icc.reservations.domain.Roles_;
import com.chaouki.icc.reservations.web.domain.support.GenericSearchForm;
import com.chaouki.icc.reservations.web.faces.ConversationContextScoped;
import com.jaxio.jpa.querybyexample.PropertySelector;
import com.jaxio.jpa.querybyexample.SearchParameters;

/**
 * View Helper to search {@link Roles}.
 * It exposes a {@link Roles} instance so it can be used in search by-example-query.
 */
@Named
@ConversationContextScoped
public class RolesSearchForm extends GenericSearchForm<Roles, Integer, RolesSearchForm> {
    private static final long serialVersionUID = 1L;
    protected Roles roles = new Roles();
    protected PropertySelector<Roles, String> roleSelector = newPropertySelector(Roles_.role);

    public Roles getRoles() {
        return roles;
    }

    @Override
    protected Roles getEntity() {
        return getRoles();
    }

    @Override
    public RolesSearchForm newInstance() {
        return new RolesSearchForm();
    }

    @Override
    public SearchParameters toSearchParameters() {
        SearchParameters sp = searchParameters();
        sp.property(roleSelector);
        return sp;
    }

    @Override
    public void resetWithOther(RolesSearchForm other) {
        this.roles = other.getRoles();
        this.roleSelector = other.getRoleSelector();
    }

    // Property selectors
    public PropertySelector<Roles, String> getRoleSelector() {
        return roleSelector;
    }
}
