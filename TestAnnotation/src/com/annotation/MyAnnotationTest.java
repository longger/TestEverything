package com.annotation;

public class MyAnnotationTest {
	
	// 实例化一个MyAnnotation类对象，添加到这个方法上
	@MyAnnotation(name="doSomething",author="long",array={1,2,3})
	public void dosomething()
	{
		System.out.println("do something!");
	}

}
