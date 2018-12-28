package com.yl.demo.learning.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuditLog {
    String operationType() default "";
    String operationDesc() default "";
    String operationTime() default "";
    String operatorId() default "";
    String operatorName() default "";
    String operatorEmail() default "";
    String operatorRole() default "";
}
