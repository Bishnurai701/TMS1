package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public boolean Userlogin(Login l)throws ClassNotFoundException {
        boolean status=false;
        try
        {
            Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement("select *from tbl_user where UserLoginName=? and Password=?");
            ps.setString(1,l.getUserLoginName());
            ps.setString(2,l.getPassword());
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
        }catch (SQLException e){
            printSQLException(e);
        }
        return status;
    }


    private void printSQLException(SQLException ex){
        for (Throwable e:ex){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState"+((SQLException) e).getSQLState());
                System.err.println("Error Code:"+((SQLException) e).getErrorCode());
                System.err.println("Message"+e.getMessage());
                Throwable th=ex.getCause();
                while (th !=null){
                    System.out.println("Cause:"+th);
                    th=th.getCause();
                }
            }
        }
    }



}
