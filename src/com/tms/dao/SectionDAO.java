package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.Department;
import com.tms.model.Section;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SectionDAO {
    private static final String INSERT_SECTION_SQL = "INSERT INTO tbl_section" + "(SectionName) VALUES" + "(?);";
    private static final String SELECT_SECTION_BY_ID = "select Section_id,SectionName from tbl_section where Section_id=?";
    private static final String SELECT_ALL_SECTION = "SELECT Section_id, SectionName from tbl_section";
    private static final String DELETE_SECTION_SQL = "delete from tbl_section where Section_id=?;";
    private static final String UPDATE_SECTION_SQL = "update tbl_section set SectionName=? where Section_id=?;";
    public SectionDAO(){}

    /*Create or insert Item:By BR Khaling*/
    public static boolean insertSection(Section s)throws SQLException {
        boolean scop_s=false;
        try
        {
            Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_SECTION_SQL);
            ps.setString(1,s.getSectionName());
            scop_s=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return scop_s;
    }
    /* check whether exist ItemName */
    public static  boolean existSection(String sectionName)throws ClassNotFoundException,SQLException{
        boolean Count_s=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            Statement st=null;
            st=conn.createStatement();
            ResultSet rs=null;
            String existquery="select *from tbl_section where SectionName='"+sectionName+"'";
            rs=st.executeQuery(existquery);
            rs.next();
            Count_s=rs.getBoolean(1);
            System.out.println(Count_s);
        }catch (SQLException e){e.printStackTrace();}
        return Count_s;
    }

    /* update ItemName :BY BR Khaling*/
    public boolean updateSection(Section s)throws SQLException{
        boolean update_s=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(UPDATE_SECTION_SQL);
            ps.setString(1,s.getSectionName());
            ps.setInt(2,s.getSection_id());
            update_s=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return update_s;
    }

    /* selected by ID*/
    public Section selectSectionById(int Section_id)throws  SQLException{
        Section section=null;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_SECTION_BY_ID);
            ps.setInt(1,Section_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String SectionName=rs.getString("SectionName");
                section=new Section(Section_id,SectionName);
            }
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return section;
    }

    /*Select All ItemName and Search ItemsNam*/
    public List<Section> selectAllSections(String SearchSection) throws SQLException, ClassNotFoundException {
        List<Section> section = new ArrayList<Section>();
        try {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String query = null;
            if (SearchSection != null) {
                query = "select *from tbl_section where SectionName like '%" + SearchSection + "%'";
            } else {
                query = "select *from tbl_section ORDER BY Section_id";
            }
            System.out.println(st);
            rs = st.executeQuery(query);
            while (rs.next()) {
                int Section_id = rs.getInt("Section_id");
                String SectionName = rs.getString("SectionName");
                section.add(new Section(Section_id, SectionName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return section;
    }

    /* Delete ItemsName*/
    public boolean deleteSection(int Section_id)throws SQLException{
        boolean delete_s=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_SECTION_SQL);
            ps.setInt(1,Section_id);
            delete_s=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return delete_s;
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
