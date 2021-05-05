package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.UserGroup;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserGroupDAO {
    private static final String INSERT_USERS_GROUP_SQL="INSERT INTO tbl_usergroup"+"(UserGroupName) VALUES"+"(?);";
    private static final String SELECT_USER_GROUP_BY_ID="select UserGroup_id,UserGroupName from tbl_usergroup where UserGroup_id=?";
    private static final String SELECT_ALL_USERS_GROUP="select *from tbl_usergroup";
    private static final String DELETE_USERS_GROUP_SQL="delete from tbl_usergroup where UserGroup_id=?;";
    private static final String UPDATE_USERS_GROUP_SQL="update tbl_usergroup set UserGroupName=? where UserGroup_id=?;";

    public UserGroupDAO(){};

    public static boolean existUserGroup(String userGroupName) {
        boolean Count=false;
        try
        {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String existquery = "select *from tbl_usergroup where  UserGroupName='" + userGroupName + "'";
            rs = st.executeQuery(existquery);
            rs.next();
            Count = rs.getBoolean(1);
            System.out.println(Count);
        }catch (SQLException | ClassNotFoundException ex){ex.printStackTrace();}
        return Count;
    }

    /*
        protected Connection getConnection()throws SQLException {
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
    /*Create or Insert UserGroup*/
    public void insertUserGroup(UserGroup ug) throws SQLException {
        int status=0;
        try(
            //Connection conn=getConnection();
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_USERS_GROUP_SQL)){
            ps.setString(1,ug.getUserGroupName());
           // ps.setInt(2,ug.getUserAuthentication_id());
            //ps.setString(2,ug.getCreatedBy());
            //ps.setString(3,ug.getModifiedBy());
            //ps.setDate(2,ug.getCreatedDate());
            //ps.setDate(5, (Date) ug.getModifiedDate());

            status=ps.executeUpdate();

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }



    /*Update User*/
    public boolean updateUserGroup(UserGroup ug) throws SQLException, ClassNotFoundException {
        boolean rowUpdatedGroup;
        try(
                //Connection conn=getConnection();
                Connection conn=DBConnection.createConnection();
                PreparedStatement ps=conn.prepareStatement(UPDATE_USERS_GROUP_SQL);){
                ps.setString(1, ug.getUserGroupName());
                //ps.setInt(2,ug.getUserAuthentication_id());
                ps.setInt(2,ug.getUserGroup_id());
                rowUpdatedGroup=ps.executeUpdate()>0;
        }
        return rowUpdatedGroup;
    }


    /*Select UserGroup By id*/
    public UserGroup selectUserGroupId(int UserGroup_id) throws SQLException {
        UserGroup ug=null;
        try(
            //Connection conn=getConnection();                                                /*Step 1: establishing a connection*/
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_USER_GROUP_BY_ID);){          /*Step 2: Create a statement using connection object*/
            ps.setInt(1,UserGroup_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();                                                 /*Step 3: Execute the query or update query*/
            while (rs.next()){                                                              /*Step 4 process the result set object*/
                String UserGroupName=rs.getString("UserGroupName");
                ug=new UserGroup(UserGroup_id,UserGroupName);

                //ug.setCreatedBy(rs.getString("CreatedBy"));
                //ug.setModifiedBy(rs.getString("ModifiedBy"));
                //ug.setCreatedDate(rs.getDate("CreatedDate"));
                //ug.setModifiedDate(rs.getDate("ModifiedDate"));
                /*
                int UserGroup_id=rs.getInt("UserGroup_id");
                String UserGroupName=rs.getString("UserGroupName");
                //int UserAuthentication_id=rs.getInt("UserAuthentication_id");
                String CreatedBy=rs.getString("CreatedBy");
                String ModifiedBy=rs.getString("ModifiedBy");
                Date CreatedDate=rs.getDate("CreatedDate");
                Date ModifiedDate=rs.getDate("ModifiedDate");
                */
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
      return ug;
    }

    /*Select All UserGroup*/
    public List<UserGroup> selectAllUsersGroup(String SearchUserGroup) throws SQLException {
        List<UserGroup> usergroup=new ArrayList<UserGroup>();
        try{
                                                                                                /*Step 1: establishing a connection*/
                Connection conn=DBConnection.createConnection();
                Statement st = null;
                st = conn.createStatement();
                ResultSet rs = null;
                String query = null;
                if(SearchUserGroup !=null)
                {
                  query="select *from tbl_usergroup where UserGroupName like '%"+SearchUserGroup+"%'";
                }
                else
                {
                    query="select *from tbl_usergroup";
                }                                                               /*Step 2: Create a statement using connection object*/
            System.out.println(st);
             rs=st.executeQuery(query);                                         /*Step 3: Execute the query or update query*/
            while (rs.next()){                                                  /*Step 4 process the result set object*/
                int UserGroup_id=rs.getInt("UserGroup_id");
                String UserGroupName=rs.getString("UserGroupName");
                // int UserAuthentication_id=rs.getInt("UserAuthentication_id");
                //String CreatedBy=rs.getString("CreatedBy");
                //String ModifiedBy=rs.getString("ModifiedBy");
                //Date CreatedDate=rs.getDate("CreatedDate");
                //Date ModifiedDate=rs.getDate("ModifiedDate");
                usergroup.add(new UserGroup(UserGroup_id,UserGroupName));
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return usergroup;
    }

    /*
    public List<UserGroup> selectAllUsersGroup(String searchUserGroup) throws SQLException {
        List<UserGroup> usergroup=new ArrayList<UserGroup>();
        try(
            Connection conn=getConnection();
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_ALL_USERS_GROUP);){
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int UserGroup_id=rs.getInt("UserGroup_id");
                String UserGroupName=rs.getString("UserGroupName");
               // int UserAuthentication_id=rs.getInt("UserAuthentication_id");
                //String CreatedBy=rs.getString("CreatedBy");
                //String ModifiedBy=rs.getString("ModifiedBy");
                //Date CreatedDate=rs.getDate("CreatedDate");
                //Date ModifiedDate=rs.getDate("ModifiedDate");
                usergroup.add(new UserGroup(UserGroup_id,UserGroupName));
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return usergroup;
    }
    */

    /*Delete UserGroup*/
    public boolean deleteUserGroup(int UserGroup_id) throws SQLException, ClassNotFoundException {
        boolean rowUserGroupDeleted;
        try(
            //Connection conn=getConnection();
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_USERS_GROUP_SQL);){
            ps.setInt(1,UserGroup_id);
            rowUserGroupDeleted=ps.executeUpdate()>0;
        }
        return rowUserGroupDeleted;
    }

/*

    public List<UserGroup> list() throws SQLException, ClassNotFoundException {
        List<UserGroup> listUserGroupDrop=new ArrayList<>();
        try(Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement("select UserGroupName from tbl_usergroup");){
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
        while (rs.next()){
            int id=rs.getInt("UserGroup_id");
            String UserGroupName=rs.getString("UserGroupName");
            UserGroup UserGroup=new UserGroup(id,UserGroupName);
            listUserGroupDrop.add(UserGroup);
            }
        }catch (SQLException ex){ex.printStackTrace();}
        return listUserGroupDrop;
    }
*/



}
