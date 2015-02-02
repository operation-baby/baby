package com.baby.cassandra.router.test;

import java.util.UUID;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import com.baby.cassandra.entity.Employee;

public class MessageRouterTest {

	@Test
	public void sendMessage() throws Exception {
		// created ConnectionFactory object for creating connection
		ConnectionFactory factory = new ActiveMQConnectionFactory("admin",
				"admin", "tcp://localhost:61616");
		// Establish the connection
		Connection connection = (Connection) factory.createConnection();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("test");
		// Added as a producer
		MessageProducer producer = session.createProducer(queue);
		// Create and send the message
		ObjectMessage msg = session.createObjectMessage();

		Employee emp = new Employee();
		emp.setEmployeeId(UUID.randomUUID().toString());
		emp.setAge((int) ((Math.random() * 100) % 100));
		emp.setDept("CIB");
		emp.setFirstName("Aniket");
		emp.setLastName("Divekar");
		msg.setObject(emp);
		producer.send(msg);
	}

	@Test
	public void consumeMessage() throws Exception {
		// created ConnectionFactory object for creating connection
		ConnectionFactory factory = new ActiveMQConnectionFactory("admin",
				"admin", "tcp://localhost:61616");
		// Establish the connection
		Connection connection = (Connection) factory.createConnection();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("test");
		MessageConsumer consumer = session.createConsumer(queue);

		ObjectMessage message = (ObjectMessage) consumer.receive();

		Employee emp = (Employee) message.getObject();
		System.out.println(emp);

	}
}
