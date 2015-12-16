package com.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import com.thrift.demo.HelloWorldImpl;
import com.thrift.demo.HelloWorldService;

public class HelloServer {
	
	public static final int port = 8090;
	
	public void startServer() throws TTransportException
	{
		System.out.println("helloworld server start......");
		TServerSocket serverSocket = new TServerSocket(port);
		TProcessor tProcessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());
		
		TServer.Args tArgs = new TServer.Args(serverSocket);
		tArgs.processor(tProcessor);
		tArgs.protocolFactory(new TBinaryProtocol.Factory());
		TServer server = new TSimpleServer(tArgs);
		server.serve();
		
	}
	
	public static void main(String args[]) throws TTransportException
	{
		HelloServer server = new HelloServer();
		server.startServer();
	}

}
