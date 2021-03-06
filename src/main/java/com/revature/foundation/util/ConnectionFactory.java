package com.revature.foundation.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory connectionFactory;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Properties props = new Properties();

    private ConnectionFactory() {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            props.load(loader.getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

    public Connection getConnection() throws SQLException {
        //System.out.println(props.getProperty("db-url")+ props.getProperty("db-username")+ props.getProperty("db-password"));
        Connection conn = DriverManager.getConnection(props.getProperty("db-url"), props.getProperty("db-username"), props.getProperty("db-password"));
        if (conn == null) {
            throw new RuntimeException("Could not establish connection with the database!");
        }

        return conn;

    }

}
