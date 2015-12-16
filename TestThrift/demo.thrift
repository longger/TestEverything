#!/usr/local/bin/thrift -java
namespace java com.thrift.demo

struct person
{
  1: string name;
  2: i32 id;
}

service HelloWorldService{
	string sayHello(1:string username)
}
