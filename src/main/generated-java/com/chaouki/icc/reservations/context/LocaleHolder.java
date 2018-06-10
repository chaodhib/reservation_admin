/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/main/java/context/LocaleHolder.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.chaouki.icc.reservations.context;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

public final class LocaleHolder {

    private LocaleHolder() {
    }

    public static Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

    public static void setLocale(Locale locale) {
        LocaleContextHolder.setLocale(locale);
    }

    public static void resetLocaleContext() {
        LocaleContextHolder.resetLocaleContext();
    }
}