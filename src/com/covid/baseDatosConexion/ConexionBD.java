package com.covid.baseDatosConexion;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class ConexionBD {
	private static BasicDataSource dataSource = null;
		
	private static DataSource getDataSource() {
		if (dataSource == null) {
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUsername("ana");
			dataSource.setPassword("anita2020");
			dataSource.setUrl("jdbc:mysql://localhost:3306/covidbasedatos?serverTimezone=UTC");
			dataSource.setInitialSize(20);
			dataSource.setMaxIdle(15);
			dataSource.setMaxTotal(20);
			dataSource.setMaxWaitMillis(50000);
		}
			
	return dataSource;
	}
		
	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}
}