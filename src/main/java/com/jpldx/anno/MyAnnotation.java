package com.jpldx.anno;

/**
 * @author chen.xudong
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value= RetentionPolicy.CLASS)
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD})
public @interface MyAnnotation
{
    String value() default "hello";
}
