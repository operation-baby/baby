package com.baby.cassandra.services;

import com.baby.cassandra.dao.CassandraDao;
import com.baby.cassandra.entity.Employee;

public class CassandraService {

	private CassandraDao dao;
	
	
	public void processMessage(Employee emp){
		this.dao.insert(emp);
	}

	/**
	 * @return the dao
	 */
	public CassandraDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(CassandraDao dao) {
		this.dao = dao;
	}

}
