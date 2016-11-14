package com.company.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by rajpurev on 5/17/16.
 */


/*
    This @interface tells Java this is a custom annotation.

    Method declarations must not have any parameters or a throws clause.
    Return types are restricted to primitives, String, Class, enums, annotations,
    and arrays of the preceding types.

 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {

    public boolean enabled() default false;

}
