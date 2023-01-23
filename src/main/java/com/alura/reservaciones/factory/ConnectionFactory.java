package com.alura.reservaciones.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.alura.reservaciones.utilities.MyGUI;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	private final String url = "jdbc:mysql://localhost:3306/hotel_control?useTimeZone=true&serverTimeZone=UTC";
	private final String user = "root";
	private final String pass = "enterpass";
	
	private DataSource datasource;
	
	private MyGUI myGUI;
	
	public ConnectionFactory() {
		
		this.myGUI = new MyGUI(null);
		
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
			this.myGUI.showMessage("Ha ocurrido un error al intentar conectarse con la base de datos");
			throw new RuntimeException(e);
		}
	}
}
