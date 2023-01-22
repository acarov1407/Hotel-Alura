package com.alura.reservaciones.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	private final String url = "jdbc:mysql://localhost:3306/hotel_control?useTimeZone=true&serverTimeZone=UTC";
	private final String user = "root";
	private final String pass = "ptTShah2021@";
	
	private DataSource datasource;
	
	public ConnectionFactory() {
		ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl(this.url);
		pooledDataSource.setUser(this.user);
		pooledDataSource.setPassword(this.pass);
		pooledDataSource.setMaxPoolSize(10);
		
		this.datasource = pooledDataSource;
	}
	
	public Connection createConnection() {
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
