package com.bel.jdbc.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {

    public static Connection getMyConnection() throws SQLException, ClassNotFoundException{

        return MySQLConnUtils.getMySQLConnection();
    }

    //test connect
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        System.out.println("Connection...");

        //get connection object
        Connection conn = ConnectionUtils.getMyConnection();
        System.out.println("Get connection " + conn);
        System.out.println("Done!");
    }
}
