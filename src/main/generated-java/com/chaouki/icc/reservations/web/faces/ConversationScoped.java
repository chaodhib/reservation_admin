/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/faces/ConversationScoped.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.chaouki.icc.reservations.web.faces;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.context.annotation.Scope;

/**
 * Beans in the 'conversation' scope reside in a {@link Conversation conversation}.
 * They are 'visible' only when the conversation is bound to the current thread of execution.
 */
@Scope("conversation")
@Retention(RetentionPolicy.RUNTIME)
public @interface ConversationScoped {
}
