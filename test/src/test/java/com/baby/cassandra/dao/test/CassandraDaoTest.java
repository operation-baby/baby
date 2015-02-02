package com.baby.cassandra.dao.test;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baby.cassandra.entity.Employee;
import com.baby.cassandra.services.CassandraService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/spring-config-test.xml")
public class CassandraDaoTest {

	@Autowired
	CassandraService service;

	@Test
	public void testInsert() {/*
							 * Cluster cluster =
							 * Cluster.builder().addContactPoint("localhost")
							 * .withPort(9042).build(); CassandraDao dao = new
							 * CassandraDao();
							 * 
							 * Session session = cluster.connect();
							 * System.out.println("keyspace " +
							 * session.getLoggedKeyspace()); CassandraOperations
							 * cassandraTemplate = new
							 * CassandraTemplate(session);
							 * 
							 * dao.setCassandraTemplate(cassandraTemplate);
							 */

		Employee emp = new Employee();
		emp.setEmployeeId(UUID.randomUUID().toString());
		emp.setAge((int) ((Math.random() * 100) % 100));
		emp.setDept("CIB");
		emp.setFirstName("Aniket");
		emp.setLastName("Divekar");

		this.service.processMessage(emp);

		// dao.insert(emp);

	}
}
