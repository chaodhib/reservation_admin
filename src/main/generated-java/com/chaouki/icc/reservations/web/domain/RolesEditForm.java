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

import com.chaouki.icc.reservations.domain.Roles;
import com.chaouki.icc.reservations.repository.RolesRepository;
import com.chaouki.icc.reservations.web.domain.support.GenericEditForm;
import com.chaouki.icc.reservations.web.faces.ConversationContextScoped;

/**
 * View Helper/Controller to edit {@link Roles}.
 */
@Named
@ConversationContextScoped
public class RolesEditForm extends GenericEditForm<Roles, Integer> {
    @Inject
    protected RolesController rolesController;

    @Inject
    public RolesEditForm(RolesRepository rolesRepository) {
        super(rolesRepository);
    }

    /**
     * The entity to edit/view.
     */
    public Roles getRoles() {
        return getEntity();
    }

    public String print() {
        return rolesController.print(getRoles());
    }
}
