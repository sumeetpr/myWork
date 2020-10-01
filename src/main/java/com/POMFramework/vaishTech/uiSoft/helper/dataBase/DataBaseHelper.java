package com.POMFramework.vaishTech.uiSoft.helper.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.POMFramework.vaishTech.uiSoft.helper.logger.loggerHelper;

public class DataBaseHelper {
	
	private static Logger log = loggerHelper.getlogger(DataBaseHelper.class);
	private static String url = "jdbc:mysql://localhost:3306/world";
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String userName = "root";
	private static String password = "Asset@12";
	private static Connection connection;
	public static DataBaseHelper instance=null;
	
	
	public DataBaseHelper() {
		
		connection = getSingleInstanceConnection();
	}
	
	public static DataBaseHelper getInstance() {
		
		if(instance ==null) {
			
			instance = new DataBaseHelper();
		}
		
		return instance;
		
	}
	
	
	private Connection getSingleInstanceConnection() {
		
		try {
			
			Class.forName(driverName);
			try {
				connection = DriverManager.getConnection(url, userName, password);
				if(connection!=null) {
					log.info("Connected to database...");
				}
				}
			catch (SQLException e) {
				
				log.info("Failed to create database connection.");
			}
			
		} catch (Exception e) {
			
		}
		
		return connection;
	}

	
	public Connection getConnection() {
		
		return connection;
		
	}
	
	public static ResultSet getResultSet(String dbQuery) {
		
		instance = getInstance();
		connection = instance.getConnection();
		Statement stmt;
		try {
			stmt = connection.createStatement();
			log.info("Executing query"+ dbQuery);
			ResultSet resultSet = stmt.executeQuery(dbQuery);
			return resultSet;
	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
	

}
