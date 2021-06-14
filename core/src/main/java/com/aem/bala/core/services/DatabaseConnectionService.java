//package com.aem.bala.core.services;
//
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.day.commons.datasource.poolservice.DataSourceNotFoundException;
//import com.day.commons.datasource.poolservice.DataSourcePool;
//import com.mysql.jdbc.Connection;
//
//@Component(service = DatabaseConnectionService.class, immediate = true)
//
//public class DatabaseConnectionService {
//
//	private Logger Log = LoggerFactory.getLogger(DatabaseConnectionService.class);
//	@Reference
//	DataSourcePool source;
//
//	public Connection getConnection() {
//		String datasourceName = "sample";
//		DataSource dataSource = null;
//		Connection con = null;
//		try {
//			Log.info(" connectiong to database", source);
//
//			dataSource = (DataSource) source.getDataSource(datasourceName);
//			con = (Connection) dataSource.getConnection();
//			Log.info("connection Sucess " , con);
//		} catch (DataSourceNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			Log.error("error in connectiong to database", e);
//		}
//
//		return con;
//
//	}
//
//}
