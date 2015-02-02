package com.baby.cassandra.dao;

import org.springframework.data.cassandra.core.CassandraOperations;

import com.baby.cassandra.entity.Employee;

public class CassandraDao {

	private CassandraOperations cassandraTemplate;

	public void insert(Employee emp) {
		this.cassandraTemplate.insert(emp);
	}

	public void update(Employee emp) {
		this.cassandraTemplate.update(emp);
	}

	/**
	 * @return the cassandraTemplate
	 */
	public CassandraOperations getCassandraTemplate() {
		return cassandraTemplate;
	}

	/**
	 * @param cassandraTemplate
	 *            the cassandraTemplate to set
	 */
	public void setCassandraTemplate(CassandraOperations cassandraTemplate) {
		this.cassandraTemplate = cassandraTemplate;
	}

}
