/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/EditForm.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.chaouki.icc.reservations.web.domain;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.chaouki.icc.reservations.domain.Roles;
import com.chaouki.icc.reservations.domain.Users;
import com.chaouki.icc.reservations.domain.Users_;
import com.chaouki.icc.reservations.repository.UsersRepository;
import com.chaouki.icc.reservations.web.domain.support.GenericEditForm;
import com.chaouki.icc.reservations.web.domain.support.GenericToOneAssociation;
import com.chaouki.icc.reservations.web.faces.ConversationContextScoped;

/**
 * View Helper/Controller to edit {@link Users}.
 */
@Named
@ConversationContextScoped
public class UsersEditForm extends GenericEditForm<Users, Integer> {
    @Inject
    protected UsersController usersController;
    @Inject
    protected RolesController rolesController;
    protected GenericToOneAssociation<Roles, Integer> role;

    @Inject
    public UsersEditForm(UsersRepository usersRepository, UsersGraphLoader usersGraphLoader) {
        super(usersRepository, usersGraphLoader);
    }

    /**
     * The entity to edit/view.
     */
    public Users getUsers() {
        return getEntity();
    }

    public String print() {
        return usersController.print(getUsers());
    }

    @PostConstruct
    void setupRoleActions() {
        role = new GenericToOneAssociation<Roles, Integer>(rolesController, Users_.role) {
            @Override
            protected Roles get() {
                return getUsers().getRole();
            }

            @Override
            protected void set(Roles roles) {
                getUsers().setRole(roles);
            }

            @NotNull
            @Override
            public Roles getSelected() {
                return super.getSelected();
            }
        };
    }

    public GenericToOneAssociation<Roles, Integer> getRole() {
        return role;
    }
}
