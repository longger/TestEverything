package com.thrift.demo;

import org.apache.thrift.TException;

public class HelloWorldImpl implements HelloWorldService.Iface{

	@Override
	public String sayHello(String username) throws TException {
		// TODO Auto-generated method stub
		return ""+username+"hello world";
	}

}
