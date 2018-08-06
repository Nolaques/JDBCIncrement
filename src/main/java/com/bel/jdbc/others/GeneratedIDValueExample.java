package com.bel.jdbc.others;

import com.bel.jdbc.connection.ConnectionUtils;

import java.sql.*;

public class GeneratedIDValueExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //connect to database
        Connection conn = ConnectionUtils.getMyConnection();

        //employees(id, full_name,gender,hire_date)
        //ID: Auto Increase
        String sql = "Insert into Employees "
                + " (full_name,gender,hire_date) "
                + " values "
                + " (?,?,?)";

        //create object PreparedStatement
        PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pstm.setString(1, "Bel");
        pstm.setString(2, "M");
        pstm.setDate(3, new java.sql.Date(System.currentTimeMillis()));

        //execute
        pstm.execute();

        ResultSet rs = pstm.getGeneratedKeys();

        int idValue = 0;
        if (rs.next()) {
            //ID value
        }

        System.out.println("ID value: " + idValue);
    }
}
