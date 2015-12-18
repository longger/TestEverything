package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)	// 元注解，并不是注解
/*
 * @interface表示是声明了一个注解类，注解类里面的内容应该就是一个参数，带着一个值
 * @Target(ElementType.METHOD) 用来指定注解修饰类的哪个成员
 */
public @interface MyAnnotation {		// 定义一个注解类
	String name() ;	//这不是方法，这是一个属性成员，是注解的成员变量，没有默认值
	String author() default "long";
	int[] array() default {1,2,3,4};
	// 枚举类型、class类型应该都可以实现
}
