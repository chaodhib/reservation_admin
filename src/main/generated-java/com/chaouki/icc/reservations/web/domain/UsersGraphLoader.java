/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/GraphLoader.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.chaouki.icc.reservations.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.chaouki.icc.reservations.domain.Users;
import com.chaouki.icc.reservations.repository.UsersRepository;
import com.jaxio.jpa.querybyexample.EntityGraphLoader;

/**
 * Preloads the {@link Users} associations required by the view layer.
 * 
 * Do not use other GraphLoaders in this GraphLoader. 
 */
@Named
@Singleton
public class UsersGraphLoader extends EntityGraphLoader<Users, Integer> {
    // required by cglib to create a proxy around the object as we are using the @Transactional annotation
    protected UsersGraphLoader() {
        super();
    }

    @Inject
    public UsersGraphLoader(UsersRepository usersRepository) {
        super(usersRepository);
    }

    @Override
    public void loadGraph(Users users) {
        loadSingular(users.getRole());
    }
}