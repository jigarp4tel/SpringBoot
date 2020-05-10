package com.jp.reservation.business.service;

import java.lang.annotation.*;

import javax.validation.Payload;

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.ANNOTATION_TYPE})
public @interface ValidEmail {
	
	String message() default "Invalid email";
	Class<?> [] groups () default{};
	Class<? extends Payload>[] payload() default {};
	
	

}
