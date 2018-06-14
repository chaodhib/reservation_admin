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

import com.chaouki.icc.reservations.domain.Category;
import com.chaouki.icc.reservations.printer.CategoryPrinter;
import com.chaouki.icc.reservations.repository.CategoryRepository;
import com.chaouki.icc.reservations.web.domain.support.GenericController;
import com.chaouki.icc.reservations.web.permission.CategoryPermission;

/**
 * Stateless controller for {@link Category} conversation start.
 */
@Named
@Singleton
public class CategoryController extends GenericController<Category, Integer> {
    public static final String CATEGORY_EDIT_URI = "/domain/categoryEdit.faces";
    public static final String CATEGORY_SELECT_URI = "/domain/categorySelect.faces";

    @Inject
    public CategoryController(CategoryRepository categoryRepository, CategoryPermission categoryPermission, CategoryPrinter categoryPrinter) {
        super(categoryRepository, categoryPermission, categoryPrinter, CATEGORY_SELECT_URI, CATEGORY_EDIT_URI);
    }
}