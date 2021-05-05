package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.Faculty;
import com.tms.model.University;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAO {
    private static final String INSERT_FACULTY_SQL = "INSERT INTO tbl_faculty" + "(FacultyName) VALUES" + "(?);";
    private static final String SELECT_FACULTY_BY_ID = "select Faculty_id,FacultyName from tbl_faculty where Faculty_id=?";
    private static final String SELECT_ALL_FACULTY = "SELECT Faculty_id, FacultyName from tbl_faculty";
    private static final String DELETE_FACULTY_SQL = "delete from tbl_faculty where Faculty_id=?;";
    private static final String UPDATE_FACULTY_SQL = "update tbl_faculty set FacultyName=? where Faculty_id=?;";
    public FacultyDAO(){}


    /*Create or insert Item:By BR Khaling*/
    public static boolean insertFaculty(Faculty faculty)throws SQLException {
        boolean scop_faculty=false;
        try
        {
            Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_FACULTY_SQL);
            ps.setString(1,faculty.getFacultyName());
            scop_faculty=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return scop_faculty;
    }

    /* check whether exist ItemName */
    public static  boolean existFaculty(String facultyName)throws ClassNotFoundException,SQLException{
        boolean Count_faculty=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            Statement st=null;
            st=conn.createStatement();
            ResultSet rs=null;
            String existquery="select *from tbl_faculty where FacultyName='"+facultyName+"'";
            rs=st.executeQuery(existquery);
            rs.next();
            Count_faculty=rs.getBoolean(1);
            System.out.println(Count_faculty);
        }catch (SQLException e){e.printStackTrace();}
        return Count_faculty;
    }

    /* update ItemName :BY BR Khaling*/
    public boolean updateFaculty(Faculty faculty)throws SQLException{
        boolean update_faculty=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(UPDATE_FACULTY_SQL);
            ps.setString(1,faculty.getFacultyName());
            ps.setInt(2,faculty.getFaculty_id());
            update_faculty=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return update_faculty;
    }

    /* selected by ID*/
    public Faculty selectFacultyById(int Faculty_id)throws  SQLException{
        Faculty faculty=null;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_FACULTY_BY_ID);
            ps.setInt(1,Faculty_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String FacultyName=rs.getString("FacultyName");
                faculty=new Faculty(Faculty_id,FacultyName);
            }
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return faculty;
    }
    /*Select All ItemName and Search ItemsNam*/
    public List<Faculty> selectAllFacultys(String SearchFaculty) throws SQLException, ClassNotFoundException {
        List<Faculty> faculty = new ArrayList<Faculty>();
        try {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String query = null;
            if (SearchFaculty != null) {
                query = "select *from tbl_faculty where FacultyName like '%" + SearchFaculty + "%'";
            } else {
                query = "select *from tbl_faculty ORDER BY Faculty_id";
            }
            System.out.println(st);
            rs = st.executeQuery(query);
            while (rs.next()) {
                int Faculty_id = rs.getInt("Faculty_id");
                String FacultyName = rs.getString("FacultyName");
                faculty.add(new Faculty(Faculty_id, FacultyName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faculty;
    }

    /* Delete ItemsName*/
    public boolean deleteFaculty(int Faculty_id)throws SQLException{
        boolean delete_faculty=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_FACULTY_SQL);
            ps.setInt(1,Faculty_id);
            delete_faculty=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return delete_faculty;
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
