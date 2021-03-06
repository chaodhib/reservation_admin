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

import com.chaouki.icc.reservations.domain.Category;
import com.chaouki.icc.reservations.domain.Category_;
import com.chaouki.icc.reservations.web.domain.support.GenericSearchForm;
import com.chaouki.icc.reservations.web.faces.ConversationContextScoped;
import com.jaxio.jpa.querybyexample.PropertySelector;
import com.jaxio.jpa.querybyexample.SearchParameters;

/**
 * View Helper to search {@link Category}.
 * It exposes a {@link Category} instance so it can be used in search by-example-query.
 */
@Named
@ConversationContextScoped
public class CategorySearchForm extends GenericSearchForm<Category, Integer, CategorySearchForm> {
    private static final long serialVersionUID = 1L;
    protected Category category = new Category();
    protected PropertySelector<Category, String> nameSelector = newPropertySelector(Category_.name);

    public Category getCategory() {
        return category;
    }

    @Override
    protected Category getEntity() {
        return getCategory();
    }

    @Override
    public CategorySearchForm newInstance() {
        return new CategorySearchForm();
    }

    @Override
    public SearchParameters toSearchParameters() {
        SearchParameters sp = searchParameters();
        sp.property(nameSelector);
        return sp;
    }

    @Override
    public void resetWithOther(CategorySearchForm other) {
        this.category = other.getCategory();
        this.nameSelector = other.getNameSelector();
    }

    // Property selectors
    public PropertySelector<Category, String> getNameSelector() {
        return nameSelector;
    }
}
