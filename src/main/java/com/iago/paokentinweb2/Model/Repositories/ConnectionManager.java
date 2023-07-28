package com.iago.paokentinweb2.Model.Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL = "jdbc:mysql://192.168.0.7:3306/paokentin";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private static Connection conn = null;

    static Connection getCurrentConnection() throws SQLException {

        if (conn == null) {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }
            //try {
                //Class.forName("com.mysql.cl.jdbc.Driver");
            //} catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
            //    e.printStackTrace();
            //  }


        return conn;

    }

    static Connection getNewConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
