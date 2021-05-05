package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.UserRoll;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRollDAO {
    private static final String INSERT_USERROLL_SQL="INSERT INTO tbl_userroll(UserRollName) VALUES(?)";
    private static final String SELECT_USERROLL_BY_ID="select UserRoll_id,UserRollName from tbl_userroll where UserRoll_id=?";
    private static final String SELECT_ALL_USERROLLS="select *from tbl_userroll";
    private static final String DELETE_USERROLL_SQL="delete from tbl_userroll where UserRoll_id=?;";
    private static final String UPDATE_USERROLL_SQL="update tbl_userroll set UserRollName=? where UserRoll_id=?;";

    public UserRollDAO(){}

    public static boolean insertUserRoll(UserRoll ur) throws SQLException {
        boolean statusUR=false;
        try(
                //Connection conn=getConnection();
            Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_USERROLL_SQL)){
            ps.setString(1,ur.getUserRollName());
            statusUR=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return statusUR;
    }

    public static boolean existUserRoll(String userRollName) {
        boolean Count=false;
        try
        {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String existquery = "select *from tbl_userroll where  UserRollName='" + userRollName + "'";
            rs = st.executeQuery(existquery);
            rs.next();
            Count = rs.getBoolean(1);
            System.out.println(Count);
        }catch (SQLException | ClassNotFoundException ex){ex.printStackTrace();}
        return Count;
    }

    /*Update UserRoll*/
    public boolean updateUserRoll(UserRoll ur) throws SQLException, ClassNotFoundException {
        boolean rowURUpdated;
        try(
                //Connection conn=getConnection();
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(UPDATE_USERROLL_SQL);){
            ps.setString(1,ur.getUserRollName());
            ps.setInt(2, ur.getUserRoll_id());
            rowURUpdated=ps.executeUpdate()>0;
        }
        return rowURUpdated;
    }

    /*Select UserRoll By id*/
    public UserRoll getUserRollById(int UserRoll_id) throws SQLException {
        UserRoll userRoll=null;
        try(
                //Connection conn=getConnection();                                /*Step 1: establishing a connection*/
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_USERROLL_BY_ID);){    /*Step 2: Create a statement using connection object*/
            ps.setInt(1,UserRoll_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();                                 /*Step 3: Execute the query or update query*/
            while (rs.next()){                                              /*Step 4 process the result set object*/
                String UserRollName=rs.getString("UserRollName");
                userRoll=new UserRoll(UserRoll_id,UserRollName);
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return userRoll;
    }




    /*Select All UserRolls*/
    public List<UserRoll> getAllUserRolls(String SearchUserRoll) throws SQLException {
        List<UserRoll> userRolls=new ArrayList<UserRoll>();
        try{
                //Connection conn=getConnection();                                    /*Step 1: establishing a connection*/
            Connection conn=DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String query = null;
            if(SearchUserRoll !=null)
            {
                query="select *from tbl_userroll where UserRollName like '%"+SearchUserRoll+"%'";
            }
            else
            {
                query="select *from tbl_userroll";
            }
                                                                                   /*Step 2: Create a statement using connection object*/
            System.out.println(st);
            rs=st.executeQuery(query);                                     /*Step 3: Execute the query or update query*/
            while (rs.next()){                                                  /*Step 4 process the result set object*/
                int UserRoll_id=rs.getInt("UserRoll_id");
                String UserRollName=rs.getString("UserRollName");
                userRolls.add(new UserRoll(UserRoll_id,UserRollName));
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return userRolls;
    }

/*
    public List<UserRoll> getAllUserRolls(String SearchUserRoll) throws SQLException {
        List<UserRoll> userRolls=new ArrayList<UserRoll>();
        try(
                //Connection conn=getConnection();
                Connection conn=DBConnection.createConnection();
                PreparedStatement ps=conn.prepareStatement(SELECT_ALL_USERROLLS)){
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int UserRoll_id=rs.getInt("UserRoll_id");
                String UserRollName=rs.getString("UserRollName");
                userRolls.add(new UserRoll(UserRoll_id,UserRollName));
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return userRolls;
    }
    */

    /*Delete UserRoll*/
    public boolean deleteUserRoll(int UserRoll_id) throws SQLException, ClassNotFoundException {
        boolean URDeleted;
        try(
                //Connection conn=getConnection();
                Connection conn=DBConnection.createConnection();
                PreparedStatement ps=conn.prepareStatement(DELETE_USERROLL_SQL);){
            ps.setInt(1,UserRoll_id);
            URDeleted=ps.executeUpdate()>0;
        }
        return URDeleted;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


}
