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

import com.chaouki.icc.reservations.domain.Shows;
import com.chaouki.icc.reservations.domain.Shows_;
import com.chaouki.icc.reservations.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link Shows} 
 *
 * @see GenericPrinter
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class ShowsPrinter extends GenericPrinter<Shows> {
    public ShowsPrinter() {
        super(Shows.class, Shows_.slug, Shows_.title);
    }

    @Override
    public String print(Shows shows, Locale locale) {
        if (shows == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, shows.getSlug());
        appendIfNotEmpty(ret, shows.getTitle());
        return ret.toString();
    }
}