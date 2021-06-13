package com.jpldx.test.java.reflection2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chenxudong
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) // 生命周期：运行时，保证反射能够获取
public @interface MyAnnotation {

    String value() default "unknown";

}
