package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyReflection {

	public static void main(String[] args) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		MyAnnotationTest myAnnotationTest = new MyAnnotationTest();
		Class<MyAnnotationTest> c = MyAnnotationTest.class;
		Method method = c.getMethod("dosomething", new Class[] {});

		if (MyAnnotationTest.class.isAnnotationPresent(MyAnnotation.class)) {
			System.out.println("have annotation!");
		}
		if (method.isAnnotationPresent(MyAnnotation.class)) {
			method.invoke(myAnnotationTest, null);// 调用dosomething方法
			// 获取方法上的注解信息
			MyAnnotation myAnnotation = method
					.getAnnotation(MyAnnotation.class);
			String name = myAnnotation.name();
			System.out.println("name==" + name);
			String author = myAnnotation.author();
			System.out.println("author==" + author);
			int[] array = myAnnotation.array();
			System.out.println("array.length" + array.length);
		}

		// 得到dosomething上所有方法的注解
		Annotation[] annotations = method.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println("all " + annotation.annotationType().getName());
		}
	}

}
