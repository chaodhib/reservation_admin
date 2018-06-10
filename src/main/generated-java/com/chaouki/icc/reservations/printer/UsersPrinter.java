/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/main/java/printer/Printer.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.chaouki.icc.reservations.printer;

import java.util.Locale;

import javax.inject.Named;
import javax.inject.Singleton;

import com.chaouki.icc.reservations.domain.Users;
import com.chaouki.icc.reservations.domain.Users_;
import com.chaouki.icc.reservations.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link Users} 
 *
 * @see GenericPrinter
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class UsersPrinter extends GenericPrinter<Users> {
    public UsersPrinter() {
        super(Users.class, Users_.firstname, Users_.lastname);
    }

    @Override
    public String print(Users users, Locale locale) {
        if (users == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, users.getFirstname());
        appendIfNotEmpty(ret, users.getLastname());
        return ret.toString();
    }
}