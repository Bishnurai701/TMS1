package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.Section;
import com.tms.model.University;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversityDAO {
    private static final String INSERT_UNIVERSITY_SQL = "INSERT INTO tbl_university" + "(UniversityName) VALUES" + "(?);";
    private static final String SELECT_UNIVERSITY_BY_ID = "select University_id,UniversityName from tbl_university where University_id=?";
    private static final String SELECT_ALL_UNIVERSITY = "SELECT University_id, UniversityName from tbl_university";
    private static final String DELETE_UNIVERSITY_SQL = "delete from tbl_university where University_id=?;";
    private static final String UPDATE_UNIVERSITY_SQL = "update tbl_university set UniversityName=? where University_id=?;";

    public UniversityDAO(){}

    /*Create or insert Item:By BR Khaling*/
    public static boolean insertUniversity(University university)throws SQLException {
        boolean scop_university=false;
        try
        {
            Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_UNIVERSITY_SQL);
            ps.setString(1,university.getUniversityName());
            scop_university=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return scop_university;
    }

    /* check whether exist ItemName */
    public static  boolean existUniversity(String universityName)throws ClassNotFoundException,SQLException{
        boolean Count_university=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            Statement st=null;
            st=conn.createStatement();
            ResultSet rs=null;
            String existquery="select *from tbl_university where UniversityName='"+universityName+"'";
            rs=st.executeQuery(existquery);
            rs.next();
            Count_university=rs.getBoolean(1);
            System.out.println(Count_university);
        }catch (SQLException e){e.printStackTrace();}
        return Count_university;
    }

    /* update ItemName :BY BR Khaling*/
    public boolean updateUniversity(University university)throws SQLException{
        boolean update_university=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(UPDATE_UNIVERSITY_SQL);
            ps.setString(1,university.getUniversityName());
            ps.setInt(2,university.getUniversity_id());
            update_university=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return update_university;
    }
    /* selected by ID*/
    public University selectUniversityById(int University_id)throws  SQLException{
        University university=null;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_UNIVERSITY_BY_ID);
            ps.setInt(1,University_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String UniversityName=rs.getString("UniversityName");
                university=new University(University_id,UniversityName);
            }
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return university;
    }

    /*Select All ItemName and Search ItemsNam*/
    public List<University> selectAllUniversitys(String SearchUniversity) throws SQLException, ClassNotFoundException {
        List<University> university = new ArrayList<University>();
        try {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String query = null;
            if (SearchUniversity != null) {
                query = "select *from tbl_university where UniversityName like '%" + SearchUniversity + "%'";
            } else {
                query = "select *from tbl_university ORDER BY University_id";
            }
            System.out.println(st);
            rs = st.executeQuery(query);
            while (rs.next()) {
                int University_id = rs.getInt("University_id");
                String UniversityName = rs.getString("UniversityName");
                university.add(new University(University_id, UniversityName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return university;
    }

    /* Delete ItemsName*/
    public boolean deleteUniversity(int University_id)throws SQLException{
        boolean delete_university=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_UNIVERSITY_SQL);
            ps.setInt(1,University_id);
            delete_university=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return delete_university;
    }
    /*customizable exception*/
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
