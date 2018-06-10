/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/main/java/audit/AuditContextHolder.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.chaouki.icc.reservations.audit;

import static org.apache.commons.lang.StringUtils.trimToNull;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.chaouki.icc.reservations.context.UserContext;

/**
 * Enable/disable {@link PreUpdate} and {@link PrePersist} actions and/or force the username to be used.
 * Please note that you are in charge of reseting the context properties if you use them directly.
 */
public final class AuditContextHolder {
    private static final ThreadLocal<Boolean> audit = new ThreadLocal<Boolean>();
    private static final ThreadLocal<String> username = new ThreadLocal<String>();

    private AuditContextHolder() {
    }

    public static void setAudit(boolean auditing) {
        audit.set(auditing);
    }

    public static void setUsername(String user) {
        username.set(trimToNull(user));
    }

    /**
     * Whether audit is enable ? Defaults to true.
     */
    public static boolean audit() {
        return audit.get() == null ? true : audit.get();
    }

    /**
     * The username bound to this thread or if it is null the username returned by the {@link UserContext};
     */
    public static String username() {
        return username.get() == null ? UserContext.getUsername() : username.get();
    }

    public static void clear() {
        audit.remove();
        username.remove();
    }
}