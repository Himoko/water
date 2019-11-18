package com.himoko.member.config;

import java.lang.annotation.*;

/**
 * description: 测试自定义注解
 * @author peng.zhang11@ucarinc.com
 * @date   2019/11/18 9:04
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

    public String name();

    int age() default 18;

    int[] array();
}
