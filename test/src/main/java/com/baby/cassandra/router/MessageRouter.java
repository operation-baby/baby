package com.baby.cassandra.router;

import org.apache.camel.Message;

import com.baby.cassandra.entity.Employee;
import com.baby.cassandra.services.CassandraService;

public class MessageRouter {

	private CassandraService service;

	public void onMessage(Message message) {
		System.out.println("Recieved the message");
		Employee emp = message.getBody(Employee.class);
		this.service.processMessage(emp);
		System.out.println("Message processed successfully");
	}
	
	
}
