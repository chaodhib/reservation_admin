/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/support/GenericEnumController.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.chaouki.icc.reservations.web.domain.support;

import static com.google.common.collect.Lists.newArrayList;
import static org.apache.commons.lang.StringUtils.containsIgnoreCase;

import java.util.List;

import com.jaxio.jpa.querybyexample.LabelizedEnum;

public abstract class GenericEnumController<T extends Enum<? extends Enum<?>> & LabelizedEnum> {

    private final T[] values;

    public GenericEnumController(T[] values) {
        this.values = values;
    }

    public List<T> complete(String text) {
        List<T> ret = newArrayList();
        for (T value : values) {
            if (containsIgnoreCase(value.name(), text) || containsIgnoreCase(value.getLabel(), text)) {
                ret.add(value);
            }
        }
        return ret;
    }
}