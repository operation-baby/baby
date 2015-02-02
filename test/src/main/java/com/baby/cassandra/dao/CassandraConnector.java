package com.baby.cassandra.dao;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

public class CassandraConnector {

	private Cluster cluster;
	private Session session;
	
	public void init(){
		
	}

	public void connect(final String node, final int port)

	{

		this.cluster = Cluster.builder().addContactPoint(node).withPort(port)
				.build();

		final Metadata metadata = cluster.getMetadata();

		System.out
				.println("Connected to cluster: " + metadata.getClusterName());

		for (final Host host : metadata.getAllHosts())

		{

			System.out.println("Datacenter: " + host.getDatacenter()
					+ "; Host: " + host.getAddress() + "; Rack: "
					+ host.getRack());

		}

		session = cluster.connect();

	}

	/**
	 * 
	 * Provide my Session.
	 * 
	 * 
	 * 
	 * @return My session.
	 */

	public Session getSession() {

		return this.session;

	}

	/** Close cluster. */

	public void close()

	{

		cluster.close();

	}

	public static void main(final String[] args)

	{

		final CassandraConnector client = new CassandraConnector();

		final String ipAddress = args.length > 0 ? args[0] : "localhost";

		final int port = args.length > 1 ? Integer.parseInt(args[1]) : 9042;

		System.out.println("Connecting to IP Address " + ipAddress + ":" + port
				+ "...");

		client.connect(ipAddress, port);

		client.close();

	}
}
