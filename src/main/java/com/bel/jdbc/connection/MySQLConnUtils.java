package com.bel.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {

        //connect to MySQL
    public static Connection getMySQLConnection() throws SQLException,
            ClassNotFoundException{
        String hostName = -;
        String dbName = -;
        String userName = -;
        String password = -;

        return getMySQLConnection(hostName, dbName, userName, password);

    }

    public static Connection getMySQLConnection(String hostName,String dbName,
                                                String userName, String password)
                                    throws SQLException, ClassNotFoundException{

        //declare class driver for MySQL DB
        Class.forName("com.mysql.jdbc.Driver");

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
}
