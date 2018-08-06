package com.bel.jdbc.others;

import com.bel.jdbc.connection.ConnectionUtils;

import java.sql.*;

public class GeneratedIDValueExample2 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection conn = ConnectionUtils.getMyConnection();

        //employees (id,full_name,gender,hire_date)
        //ID:auto increase
        String sql = "Insert into Employees "
                + " (full_name, gender, hire_date) "
                + " values "
                + " (?,?,?)";

        //create preparedStatement object
        PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pstm.setString(1, "John");
        pstm.setString(2, "M");
        pstm.setDate(3, new java.sql.Date(System.currentTimeMillis()));

        //execute
        pstm.execute();

        ResultSet rs = pstm.getGeneratedKeys();

        int idValue = 0;
        if (rs.next()){
            //value of ID
            //column names in some DB are care sensitive (Postgres column names are always lowercase)
            idValue = rs.getInt("ID");
//            idValue = rs.getInt(1);
        }

        System.out.println("ID value: " + idValue);

    }
}
