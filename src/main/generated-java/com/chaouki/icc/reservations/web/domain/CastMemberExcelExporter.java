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

import com.chaouki.icc.reservations.domain.CastMember;
import com.chaouki.icc.reservations.web.domain.support.GenericExcelExporter;
import com.chaouki.icc.reservations.web.faces.ConversationContextScoped;

/**
 * Exports to excel document {@link CastMember} search criteria and result. 
 */
@Named
@ConversationContextScoped
public class CastMemberExcelExporter extends GenericExcelExporter<CastMember> {
    @Inject
    protected CastMemberSearchForm sf;

    public CastMemberExcelExporter() {
        super();
    }

    @Override
    protected void fillResultItem(int row, CastMember item) {
        int col = 0;
    }

    @Override
    public void fillSearchCriteria(int row) {
        useCriteriaSheet();

        setSelectedEntities(row++, 0, "castMember_artist", sf.getArtistSelector().getSelected());
        setSelectedEntities(row++, 0, "castMember_type", sf.getTypeSelector().getSelected());
        setSelectedEntities(row++, 0, "castMember_show", sf.getShowSelector().getSelected());
    }
}