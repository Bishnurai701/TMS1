package com.tms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tms.dao.UserGroupDAO;



public class DBConnection {


    public DBConnection(String jdbcURL, String jdbcUsername, String jdbcPassword) {
    }

    public  static Connection  createConnection() throws SQLException, ClassNotFoundException {
        Connection connection=null;
        String jdbcURL = "jdbc:mysql://localhost:3306/db_tms?uselegacyDatetimeCode=false&serverTimezone=UTC";
        String jdbcUsername = "admin";
        String jdbcPassword = "admin";   // if (connection == null || connection.isClosed())
        try {
            if (connection == null || connection.isClosed())
            {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("DB Connected");
            }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        return connection;
    }


    public void disConnect() throws SQLException {
       Connection connection=null;
        if(connection!=null || connection.isClosed())
        {
            connection.close();
        }
    }

}
