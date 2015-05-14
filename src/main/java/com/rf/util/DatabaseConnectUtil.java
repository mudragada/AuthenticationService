package com.rf.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.Set;

public class DatabaseConnectUtil {
	private final Properties login;
	public final String uri;
	public Connection getConnection() throws SQLException {
		System.out.println("DatabaseConnectUtil::getConnection - Attempting to getConnection() to " + uri);
		Connection dbConnection = DriverManager.getConnection(uri, login);
		dbConnection.setAutoCommit(true);
		return dbConnection;
	}
	public DatabaseConnectUtil() throws FileNotFoundException, IOException {
		//This isn't working yet..Will have to figure out
		this("database.properties");
	}
	public DatabaseConnectUtil(String configPath) throws IOException{
		//System.out.println("DatabaseConnectionUtil::Initializing database conn from configpath " + configPath);
		//Properties config = loadConfig(configPath);	
		uri = String.format("jdbc:mysql://%s:3306/%s",
				"localhost", "RFO");
		login = new Properties();
		login.put("user", "root");
		login.put("password", "");
	}
	private Properties loadConfig(String configPath)
			throws FileNotFoundException, IOException {

		// Specify which keys must be in properties file
		Set<String> required = new HashSet<>();
		required.add("username");
		required.add("password");
		required.add("database");
		required.add("hostname");

		// Load properties file
		Properties config = new Properties();
		// load config from file.
		config.load(new FileReader(configPath));

		// Check that required keys are present
		if (!config.keySet().containsAll(required)) {
			String error = "Must provide the following in properties file: ";
			throw new InvalidPropertiesFormatException(error + required);
		}

		return config;
	}


}
