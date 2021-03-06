/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/support/GenericSearchForm.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.chaouki.icc.reservations.web.domain.support;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.chaouki.icc.reservations.web.conversation.Conversation;
import com.chaouki.icc.reservations.web.conversation.ConversationContext;
import com.chaouki.icc.reservations.web.conversation.ConversationManager;
import com.chaouki.icc.reservations.web.util.MessageUtil;
import com.jaxio.jpa.querybyexample.Identifiable;
import com.jaxio.jpa.querybyexample.SearchParameters;

/**
 * Base Search Form for JPA entities.
 */
public abstract class GenericSearchForm<E extends Identifiable<PK>, PK extends Serializable, F extends GenericSearchForm<E, PK, F>> extends CommonAction<E>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private transient ConversationManager conversationManager;
    @Inject
    private transient MessageUtil messageUtil;

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        Conversation currentConversation = conversationManager.getCurrentConversation();
        if (currentConversation == null) {
            return;
        }

        ConversationContext<?> currentContext = currentConversation.getCurrentContext();
        if (currentContext != null && currentContext.getBean(getPrefilledFormName(), getClass()) != null) {
            resetWithOther((F) currentContext.getBean(getPrefilledFormName(), getClass()));
        }
    }

    public String getPrefilledFormName() {
        return "_" + this.getClass().getName() + "_prefilled_";
    }

    /**
     * Return the entity example used in this search form.
     */
    protected abstract E getEntity();

    /**
     * Convert all the search inputs into a new @{link SearchParameters}. 
     */
    public abstract SearchParameters toSearchParameters();

    /**
     * default search parameters
     */
    public SearchParameters searchParameters() {
        return new SearchParameters() //
                .limitBroadSearch() //
                .distinct() //
                .anywhere() //
                .caseInsensitive();
    }

    // Reset related

    public abstract F newInstance();

    public abstract void resetWithOther(F other);

    public void reset() {
        messageUtil.info("search_reseted");
        resetWithOther(newInstance());
    }
}
