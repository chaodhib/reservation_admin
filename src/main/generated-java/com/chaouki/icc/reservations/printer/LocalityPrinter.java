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

import com.chaouki.icc.reservations.domain.Locality;
import com.chaouki.icc.reservations.domain.Locality_;
import com.chaouki.icc.reservations.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link Locality} 
 *
 * @see GenericPrinter
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class LocalityPrinter extends GenericPrinter<Locality> {
    public LocalityPrinter() {
        super(Locality.class, Locality_.locality2);
    }

    @Override
    public String print(Locality locality, Locale locale) {
        if (locality == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, locality.getLocality2());
        return ret.toString();
    }
}