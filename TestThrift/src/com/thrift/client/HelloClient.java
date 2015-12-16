package com.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import com.thrift.demo.HelloWorldService;

public class HelloClient {
	
	public static final String ip = "localhost";
	public static final int port = 8090;
	public static final int timeout = 3000;

	public String startClient(String username) throws TException
	{
		System.out.println("hello client start------");
		TTransport transport = null;
		transport = new TSocket(ip,port,timeout);
		TProtocol protocol = new TBinaryProtocol(transport);
		HelloWorldService.Client client = new HelloWorldService.Client(protocol);
		transport.open();
		String result = client.sayHello(username);
		return result;
	}
	
	public static void main(String[] args) throws TException {
		// TODO Auto-generated method stub
		
		HelloClient client = new HelloClient();
		System.out.println(client.startClient("tian"));
		
	}

}
