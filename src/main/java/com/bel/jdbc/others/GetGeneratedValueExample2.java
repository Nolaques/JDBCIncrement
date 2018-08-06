package com.bel.jdbc.others;

import com.bel.jdbc.connection.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetGeneratedValueExample2 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection conn = ConnectionUtils.getMyConnection();

        //employees (id,full_name,gender,hire_date)
        //ID: auto increase
        //gender: default
        String sql = "Insert into Employees "
                + " (Full_name, Hire_Date) "
                + " values "
                + " (?, ?)";

        //create object PreparedStatement
        // and register out parameters with names ("id","gender","hire_date)
        PreparedStatement pstm = conn.prepareStatement(sql, new String[]{"id", "gender", "hire_date"});

        pstm.setString(1, "Jack");
        pstm.setDate(2, new java.sql.Date(System.currentTimeMillis()));

        //execute
        pstm.execute();

        ResultSet rs = pstm.getGeneratedKeys();

        int idValue = 0;
        String gender = null;
        java.sql.Date hireDate = null;
        if (rs.next()) {
            idValue = rs.getInt("ID");
            gender = rs.getString("Gender");
            hireDate = rs.getDate("hire_date");
            //
//            idValue = rs.getInt(1);
//            gender = rs.getString(2);
//            hireDate = rs.getDate(3);
        }
        System.out.println("ID value: " + idValue + " Gender: " + gender + ",Hiredate: " + hireDate);
    }
}
