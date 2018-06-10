/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/main/java/validation/impl/FixedLengthValidator.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.chaouki.icc.reservations.validation.impl;

import static org.apache.commons.lang.StringUtils.isEmpty;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.chaouki.icc.reservations.validation.FixedLength;

public class FixedLengthValidator implements ConstraintValidator<FixedLength, String> {

    private FixedLength constraint;

    @Override
    public void initialize(FixedLength constraint) {
        this.constraint = constraint;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (isEmpty(value)) {
            return constraint.nullable();
        }
        return value.length() == constraint.length();
    }
}
