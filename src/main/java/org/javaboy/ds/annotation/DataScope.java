package org.javaboy.ds.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/18 0:02
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataScope {
    String deptAlias() default "";
    String userAlias() default "";
}
