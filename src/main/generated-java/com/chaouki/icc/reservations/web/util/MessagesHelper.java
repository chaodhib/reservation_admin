/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/util/MessagesHelper.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.chaouki.icc.reservations.web.util;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Iterables.getFirst;
import static com.google.common.collect.Iterables.toArray;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static java.util.Arrays.asList;
import static java.util.Collections.reverseOrder;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.chaouki.icc.reservations.util.ResourcesUtil;
import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 * Helper used from the <code>appcc:messages</code> composite component.
 */
@Named
@Singleton
public class MessagesHelper {

    @Inject
    protected ResourcesUtil resourcesUtil;

    public String getMaxSeverityNonGlobalMessages() {
        Severity maxSeverity = getFirst(getSeveritiesNonGlobalMessages(), FacesMessage.SEVERITY_INFO);
        return MessageUtil.toCssFriendly(maxSeverity);
    }

    public String getCssFriendlySeverity(Severity severity) {
        return MessageUtil.toCssFriendly(severity);
    }

    /**
     * @return sorted list of severities in descending order
     */
    public List<Severity> getSeveritiesGlobalMessages() {
        return getSeverities(asList(getGlobalMessages()));
    }

    /**
     * @return sorted list of severities in descending order
     */
    public List<Severity> getSeveritiesNonGlobalMessages() {
        return getSeverities(asList(getNonGlobalMessages()));
    }

    /**
     * @return descending sorted and distinct list of severities
     */
    protected List<Severity> getSeverities(Collection<Message> messages) {
        Collection<Severity> severities = transform(messages, messageFunction);
        List<Severity> sortedSeverities = newArrayList(newHashSet(severities));
        Collections.sort(sortedSeverities, reverseOrder(severityComparator));
        return sortedSeverities;
    }

    private static Function<Message, Severity> messageFunction = new Function<Message, Severity>() {
        @Override
        public Severity apply(Message input) {
            return input.getFacesMessage().getSeverity();
        }
    };

    private static Comparator<Severity> severityComparator = new Comparator<Severity>() {
        @Override
        public int compare(Severity s1, Severity s2) {
            return Integer.valueOf(s1.getOrdinal()).compareTo(s2.getOrdinal());
        }
    };

    public Message[] getGlobalMessages() {
        List<Message> res = newArrayList();
        Iterator<FacesMessage> msgs = FacesContext.getCurrentInstance().getMessages(null);
        while (msgs.hasNext()) {
            res.add(new Message(null, msgs.next()));
        }
        return toArray(res, Message.class);
    }

    public Message[] getGlobalMessages(Severity severity) {
        Collection<Message> res = filter(asList(getGlobalMessages()), newSeverityPredicate(severity));
        return toArray(res, Message.class);
    }

    public Message getSingleGlobalMessage(Severity severity) {
        Message[] messages = getGlobalMessages(severity);
        return messages != null && messages.length == 1 ? messages[0] : null;
    }

    private Predicate<Message> newSeverityPredicate(final Severity severity) {
        return new Predicate<Message>() {
            @Override
            public boolean apply(Message input) {
                return severity == input.getFacesMessage().getSeverity();
            }
        };
    }

    public Message[] getNonGlobalMessages() {
        List<Message> res = newArrayList();

        Iterator<String> ids = FacesContext.getCurrentInstance().getClientIdsWithMessages();
        while (ids.hasNext()) {
            String clientId = ids.next();
            if (clientId != null && !clientId.equals("null")) { /* the 'null' string is pretty disturbing */
                Iterator<FacesMessage> msgs = FacesContext.getCurrentInstance().getMessages(clientId);
                while (msgs.hasNext()) {
                    res.add(new Message(clientId, msgs.next()));
                }
            }
        }

        return toArray(res, Message.class);
    }

    public boolean hasGlobalMessages() {
        return FacesContext.getCurrentInstance().getMessages(null).hasNext();
    }

    public boolean hasMultipleGlobalMessages(Severity severity) {
        return getGlobalMessages(severity).length > 1;
    }

    public boolean hasSingleGlobalMessage(Severity severity) {
        return getGlobalMessages(severity).length == 1;
    }

    public boolean hasNonGlobalMessages() {
        Iterator<String> ids = FacesContext.getCurrentInstance().getClientIdsWithMessages();
        while (ids.hasNext()) {
            String clientId = ids.next();
            if (clientId != null && !clientId.equals("null")) { /* the 'null' string is pretty disturbing */
                return true;
            }
        }
        return false;
    }

    public boolean hasNoMessages() {
        return !(hasGlobalMessages() || hasNonGlobalMessages());
    }

    public boolean hasOnlyGlobalMessages() {
        return hasGlobalMessages() && !hasNonGlobalMessages();
    }

    public String getNonGlobalMessagesIntro() {
        return resourcesUtil.getPluralableProperty("form_error_status", nonGlobalMessagesCount());
    }

    public int nonGlobalMessagesCount() {
        int count = 0;
        Iterator<String> ids = FacesContext.getCurrentInstance().getClientIdsWithMessages();
        while (ids.hasNext()) {
            String clientId = ids.next();
            if (clientId != null && !clientId.equals("null")) { /* the 'null' string is pretty disturbing */
                count += FacesContext.getCurrentInstance().getMessageList(clientId).size();
            }
        }
        return count;
    }
}
