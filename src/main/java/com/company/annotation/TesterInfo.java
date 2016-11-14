package com.company.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by rajpurev on 5/17/16.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TesterInfo {

    public enum Priority{
        HIGH,MEDIUM,LOW
    }

    Priority priority() default Priority.MEDIUM;

    String[] tags() default "";

    String createdBy() default "TestAnnotation";

    String lastModified() default "17/05/2016";
}
