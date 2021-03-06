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

import com.chaouki.icc.reservations.domain.Artists;
import com.chaouki.icc.reservations.domain.Artists_;
import com.chaouki.icc.reservations.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link Artists} 
 *
 * @see GenericPrinter
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class ArtistsPrinter extends GenericPrinter<Artists> {
    public ArtistsPrinter() {
        super(Artists.class, Artists_.firstname, Artists_.lastname);
    }

    @Override
    public String print(Artists artists, Locale locale) {
        if (artists == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, artists.getFirstname());
        appendIfNotEmpty(ret, artists.getLastname());
        return ret.toString();
    }
}