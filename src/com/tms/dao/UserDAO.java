package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.User;
import com.tms.model.User_Roll_Drop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*this DAO class provides CRUD database operators for the table users in the database(uselegacyDatetimeCode=false)*/
public class UserDAO {
    //private String jdbcURL="jdbc:mysql://localhost:3309/db_tms?uselegacyDatetimeCode=false&serverTimezone=UTC";
    //private String jdbcUsername="admin";
    //private String jdbcPassword="admin";

    private static final String INSERT_USERS_SQL = "INSERT INTO tbl_user" + "(UserName,UserLoginName,Password,UserGroup_id,UserRoll_id,Status) VALUES" + "(?,?,?,?,?,?);";
    private static final String SELECT_USER_BY_ID = "select User_id,UserName,UserLoginName,UserGroup_id,UserRoll_id,Status from tbl_user where User_id=?";

    private static final String SELECT_ALL_USERS = "SELECT User_id, UserName, UserLoginName, UserGroupName, UserRollName,Status\n" +
                                                    "FROM tbl_user\n" +
                                                    "INNER JOIN tbl_usergroup USING (UserGroup_id)\n" +
                                                    "INNER JOIN tbl_userroll USING (UserRoll_id)\n" +
                                                    "ORDER BY  User_id;";
    private static final String DELETE_USERS_SQL = "delete from tbl_user where User_id=?;";
    private static final String UPDATE_USERS_SQL = "update tbl_user set UserName=?,UserLoginName=?,UserGroup_id=?,UserRoll_id=?,Status=? where User_id=?;";
    private static final String SELECT_USERGROUPNAME = "select UserGroup_id,UserGroupName from tbl_usergroup";
    private static final String SELECT_USERROLLNAME = "select UserRoll_id, UserRollName from tbl_userroll";

    public UserDAO() {
    }

    /*Database Connection method*/
/*
    protected Connection getConnection()throws SQLException{
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3309/db_tms?uselegacyDatetimeCode=false&serverTimezone=UTC","admin","admin");
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return conn;
    }

*/

    /*Create or Insert User*/
    public static boolean insertUser(User u) throws SQLException {
        boolean scop = false;
        try {
                //Connection conn=getConnection();
                    Connection conn = DBConnection.createConnection();
                    PreparedStatement ps = conn.prepareStatement(INSERT_USERS_SQL);
                    ps.setString(1, u.getUserName());
                    ps.setString(2, u.getUserLoginName());
                    ps.setString(3, u.getPassword());
                    ps.setInt(4, u.getUserGroup_id());
                    //ps.setInt(5,u.getQRAndThump_id());
                    //ps.setInt(6,u.getRegistration_id());
                    //ps.setString(7,u.getCreatedBy());
                    //ps.setString(8,u.getModifiedBy());
                    //ps.setDate(9, (Date) u.getCreatedDate());
                    //ps.setDate(10, (Date) u.getModifiedDate());
                    ps.setInt(5, u.getUserRoll_id());
                    ps.setInt(6, u.getStatus());
                    scop = ps.executeUpdate()>0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return scop;
    }
    /*exist users*/
    public static  boolean existUser(String LoginName) throws SQLException, ClassNotFoundException {
        boolean CountRow=false;
        try {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            //.String existquery="select COUNT(*) from tbl_user where  UserLoginName='"+LoginName+"'";
            String existquery = "select *from tbl_user where  UserLoginName='" + LoginName + "'";
            rs = st.executeQuery(existquery);
            rs.next();
            CountRow = rs.getBoolean(1);
            System.out.println(CountRow);
        }catch (SQLException ex){ex.printStackTrace();}
        return CountRow;
    }


    /*Update User*/
    public boolean updateUser(User u) throws SQLException, ClassNotFoundException {
        boolean rowUpdated;
        try (
                //Connection conn=getConnection();
                Connection conn = DBConnection.createConnection();
                PreparedStatement ps = conn.prepareStatement(UPDATE_USERS_SQL);) {
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getUserLoginName());
            ps.setInt(3, u.getUserGroup_id());
            // ps.setInt(5,u.getQRAndThump_id());
            //ps.setInt(6,u.getRegistration_id());
            ps.setInt(4, u.getUserRoll_id());
            ps.setInt(5, u.getStatus());
            ps.setInt(6, u.getUser_id());
            rowUpdated = ps.executeUpdate() > 0;
        }
        return rowUpdated;
    }


    /*Select User By id*/
    public User selectUserId(int User_id) throws SQLException {
        User u = null;
        try (
                //Connection conn=getConnection();                                /*Step 1: establishing a connection*/
                Connection conn = DBConnection.createConnection();
                PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID);) {    /*Step 2: Create a statement using connection object*/
            ps.setInt(1, User_id);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();                                 /*Step 3: Execute the query or update query*/
            while (rs.next()) {                                              /*Step 4 process the result set object*/
                String UserName = rs.getString("UserName");
                String UserLoginName = rs.getString("UserLoginName");
                int UserGroup_id = rs.getInt("UserGroup_id");
                //int QRAndThump_id=rs.getInt("QRAndThump_id");
                //int Registration_id=rs.getInt("Registration_id");
                // String CreatedBy=rs.getString("CreatedBy");
                //String ModifiedBy=rs.getString("ModifiedBy");
                //Date CreatedDate=rs.getDate("CreatedDate");
                // Date ModifiedDate=rs.getDate("ModifiedDate");
                int UserRoll_id = rs.getInt("UserRoll_id");
                int Status = rs.getInt("Status");
                u = new User(User_id, UserName, UserLoginName, UserGroup_id, UserRoll_id, Status);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return u;
    }


    /*Select All Users*/
    public List<User> selectAllUsers(String SearchUser) throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<User>();
            //Connection conn=getConnection();                                                                          /*Step 1: establishing a connection*/
        try {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String query = null;

            if (SearchUser != null) {
                query = "SELECT User_id, UserName, UserLoginName, UserGroupName, UserRollName,Status\n" +
                        "FROM tbl_user\n" +
                        "INNER JOIN tbl_usergroup USING (UserGroup_id)\n" +
                        "INNER JOIN tbl_userroll USING (UserRoll_id)" +
                        "where  UserName like '%" + SearchUser + "%' or UserLoginName like '%" + SearchUser + "%' or UserGroupName like '%"+SearchUser+"%' or UserRollName like '%"+SearchUser+"%' ";
            } else {
                query = "SELECT User_id, UserName, UserLoginName, UserGroupName, UserRollName,Status\n" +
                        "FROM tbl_user\n" +
                        "INNER JOIN tbl_usergroup USING (UserGroup_id)\n" +
                        "INNER JOIN tbl_userroll USING (UserRoll_id)\n" +
                        "ORDER by User_id";
            }

            System.out.println(st);
            rs = st.executeQuery(query);                                                                         /*Step 3: Execute the query or update query*/
            while (rs.next()) {                                                                                       /*Step 4 process the result set object*/
                int User_id = rs.getInt("User_id");
                String UserName = rs.getString("UserName");
                String UserLoginName = rs.getString("UserLoginName");
                String UserGroupName = rs.getString("UserGroupName");
                String UserRollName = rs.getString("UserRollName");
                int Status = rs.getInt("Status");
                users.add(new User(User_id, UserName, UserLoginName, UserGroupName, UserRollName, Status));
            }
        }catch (SQLException ex){ex.printStackTrace();}
                return users;
        }

    /*Delete User*/
    public boolean deleteUser(int User_id) throws SQLException, ClassNotFoundException {
        boolean rowDeleted;
        try(
            //Connection conn=getConnection();
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_USERS_SQL);){
           ps.setInt(1,User_id);
            rowDeleted=ps.executeUpdate()>0;
        }
        return rowDeleted;
    }

    public List<User> droplistUG() throws SQLException, ClassNotFoundException {
        List<User> listUserGroupDrop=new ArrayList<User>();
        try(Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_USERGROUPNAME);){
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int UserGroup_id=rs.getInt("UserGroup_id");
                String UserGroupName=rs.getString("UserGroupName");
                User usergrouplist=new User(UserGroup_id,UserGroupName);
                listUserGroupDrop.add(usergrouplist);
            }
        }catch (SQLException ex){ex.printStackTrace();}
        return listUserGroupDrop;
    }

    public List<User_Roll_Drop> droplistUR() throws SQLException,ClassNotFoundException{
        List<User_Roll_Drop> listUserRollDrop=new ArrayList<User_Roll_Drop>();
        try(Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_USERROLLNAME);){
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int UserRoll_id=rs.getInt("UserRoll_id");
                String UserRollName=rs.getString("UserRollName");
                User_Roll_Drop userrolllist=new User_Roll_Drop(UserRoll_id,UserRollName);
                listUserRollDrop.add(userrolllist);
            }
        }catch (SQLException ex){ex.printStackTrace();}
        return listUserRollDrop;
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
