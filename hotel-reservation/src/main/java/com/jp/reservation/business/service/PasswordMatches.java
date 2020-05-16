package com.jp.reservation.business.service;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, ANNOTATION_TYPE })
public @interface PasswordMatches {

	String message() default "Password doesn't match";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
