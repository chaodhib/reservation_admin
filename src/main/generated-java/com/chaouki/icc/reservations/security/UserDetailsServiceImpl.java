/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/main/java/security/UserDetailsServiceImpl.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.chaouki.icc.reservations.security;

import static com.google.common.collect.Lists.newArrayList;
import static com.jaxio.jpa.querybyexample.PropertySelector.newPropertySelector;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.chaouki.icc.reservations.domain.Locality_;
import com.chaouki.icc.reservations.domain.Roles_;
import com.chaouki.icc.reservations.domain.Users;
import com.chaouki.icc.reservations.domain.Users_;
import com.chaouki.icc.reservations.repository.RolesRepository;
import com.chaouki.icc.reservations.repository.UsersRepository;
import com.jaxio.jpa.querybyexample.SearchParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.chaouki.icc.reservations.context.UserWithId;

/**
 * An implementation of Spring Security's {@link UserDetailsService}.
 * 
 * @see http://static.springsource.org/spring-security/site/reference.html
 */
@Singleton
@Named("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Inject
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SearchParameters searchParameters = new SearchParameters();
        searchParameters.property(newPropertySelector(Users_.login).selected(username));
        List<Users> matches = usersRepository.find(searchParameters);
        if(matches.isEmpty())
            return null;
        else if(matches.size() > 1)
            throw new IllegalStateException("more than one user with the same 'username'");

        Users users = matches.get(0);

        if(!"admin".equals(users.getRole().getRole()))
            return null;

        return new UserWithId(users.getLogin(), users.getPassword(), true, true, true, true, Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")), users.getId());
    }
}