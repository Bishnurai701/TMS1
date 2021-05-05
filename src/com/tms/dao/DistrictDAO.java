package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.Country;
import com.tms.model.District;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DistrictDAO {
    private static final String INSERT_DISTRICT_SQL = "INSERT INTO tbl_district" + "(DistrictName) VALUES" + "(?);";
    private static final String SELECT_DISTRICT_BY_ID = "select District_id,DistrictName from tbl_district where District_id=?";
    private static final String SELECT_ALL_DISTRICT = "SELECT District_id, DistrictName from tbl_district";
    private static final String DELETE_DISTRICT_SQL = "delete from tbl_district where District_id=?;";
    private static final String UPDATE_DISTRICT_SQL = "update tbl_district set DistrictName=? where District_id=?;";
    public DistrictDAO(){}


    /*Create or insert District:By BR Khaling*/
    public static boolean insertDistrict(District d)throws SQLException {
        boolean scop_d=false;
        try
        {
            Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_DISTRICT_SQL);
            ps.setString(1,d.getDistrictName());
            scop_d=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return scop_d;
    }

    /* check whether exist DistrictName :By BR Khaling*/
    public static  boolean existDistrict(String districtName)throws ClassNotFoundException,SQLException{
        boolean Count_d=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            Statement st=null;
            st=conn.createStatement();
            ResultSet rs=null;
            String existquery="select *from tbl_district where DistrictName='"+districtName+"'";
            rs=st.executeQuery(existquery);
            rs.next();
            Count_d=rs.getBoolean(1);
            System.out.println(Count_d);
        }catch (SQLException e){e.printStackTrace();}
        return Count_d;
    }

    /* update DistrictName :By BR Khaling*/
    public boolean updateDistrict(District d)throws SQLException{
        boolean update_d=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(UPDATE_DISTRICT_SQL);
            ps.setString(1,d.getDistrictName());
            ps.setInt(2,d.getDistrict_id());
            update_d=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return update_d;
    }

    /* selected by ID :BY BR Khaling*/
    public District selectDistrictById(int District_id)throws  SQLException{
        District d=null;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_DISTRICT_BY_ID);
            ps.setInt(1,District_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String DistrictName=rs.getString("DistrictName");
                d=new District(District_id,DistrictName);
            }
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return d;
    }

    /*Select All DistrictNames and Search Name :BY BR Khaling*/
    public List<District> selectAllDistricts(String SearchDistrict) throws SQLException, ClassNotFoundException {
        List<District> district = new ArrayList<District>();
        try {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String query = null;
            if (SearchDistrict != null) {
                query = "select *from tbl_district where  DistrictName like '%"+SearchDistrict+"%'";
            } else {
                query = "select *from tbl_district ORDER BY District_id";
            }
            System.out.println(st);
            rs = st.executeQuery(query);
            while (rs.next()) {
                int District_id = rs.getInt("District_id");
                String DistrictName = rs.getString("DistrictName");
                district.add(new District(District_id,DistrictName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return district;
    }
    /* Delete DistrictName :By BR Khaling*/
    public boolean deleteDistrict(int District_id)throws SQLException{
        boolean delete_d=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_DISTRICT_SQL);
            ps.setInt(1,District_id);
            delete_d=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return delete_d;
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
