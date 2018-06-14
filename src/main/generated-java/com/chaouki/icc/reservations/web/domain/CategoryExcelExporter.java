/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/ExcelExporter.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.chaouki.icc.reservations.web.domain;

import javax.inject.Inject;
import javax.inject.Named;

import com.chaouki.icc.reservations.domain.Category;
import com.chaouki.icc.reservations.web.domain.support.GenericExcelExporter;
import com.chaouki.icc.reservations.web.faces.ConversationContextScoped;

/**
 * Exports to excel document {@link Category} search criteria and result. 
 */
@Named
@ConversationContextScoped
public class CategoryExcelExporter extends GenericExcelExporter<Category> {
    @Inject
    protected CategorySearchForm sf;

    public CategoryExcelExporter() {
        super("category_name");
    }

    @Override
    protected void fillResultItem(int row, Category item) {
        int col = 0;
        setValue(row, col++, item.getName());
    }

    @Override
    public void fillSearchCriteria(int row) {
        useCriteriaSheet();

        setSelector(row++, 0, "category_name", sf.getNameSelector());
    }
}