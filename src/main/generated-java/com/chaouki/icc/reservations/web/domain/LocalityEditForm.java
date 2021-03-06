/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/EditForm.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.chaouki.icc.reservations.web.domain;

import javax.inject.Inject;
import javax.inject.Named;

import com.chaouki.icc.reservations.domain.Locality;
import com.chaouki.icc.reservations.repository.LocalityRepository;
import com.chaouki.icc.reservations.web.domain.support.GenericEditForm;
import com.chaouki.icc.reservations.web.faces.ConversationContextScoped;

/**
 * View Helper/Controller to edit {@link Locality}.
 */
@Named
@ConversationContextScoped
public class LocalityEditForm extends GenericEditForm<Locality, Integer> {
    @Inject
    protected LocalityController localityController;

    @Inject
    public LocalityEditForm(LocalityRepository localityRepository) {
        super(localityRepository);
    }

    /**
     * The entity to edit/view.
     */
    public Locality getLocality() {
        return getEntity();
    }

    public String print() {
        return localityController.print(getLocality());
    }
}
