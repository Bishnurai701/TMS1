package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.Municipality;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MunicipalityDAO {
    private static final String INSERT_MUNICIPALITY_SQL = "INSERT INTO tbl_municipality" + "(MunicipalityName) VALUES" + "(?);";
    private static final String SELECT_MUNICIPALITY_BY_ID = "select Municipality_id,MunicipalityName from tbl_municipality where Municipality_id=?";
    private static final String SELECT_ALL_MUNICIPALITYS = "SELECT Municipality_id, MunicipalityName from tbl_municipality";
    private static final String DELETE_MUNICIPALITY_SQL = "delete from tbl_municipality where Municipality_id=?;";
    private static final String UPDATE_MUNICIPALITY_SQL = "update tbl_municipality set MunicipalityName=? where Municipality_id=?;";
    public MunicipalityDAO(){}


    /*Create or insert Municipality :By BR Khaling*/
    public static boolean insertMunicipality(Municipality mt)throws SQLException {
        boolean scop_mt=false;
        try
        {
            Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_MUNICIPALITY_SQL);
            ps.setString(1,mt.getMunicipalityName());
            scop_mt=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return scop_mt;
    }

    /* check whether exist MunicipalityName:By BR Khaling */
    public static  boolean existMunicipality(String municipalityName)throws ClassNotFoundException,SQLException{
        boolean Count_mt=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            Statement st=null;
            st=conn.createStatement();
            ResultSet rs=null;
            String existquery="select *from tbl_municipality where MunicipalityName='"+municipalityName+"'";
            rs=st.executeQuery(existquery);
            rs.next();
            Count_mt=rs.getBoolean(1);
            System.out.println(Count_mt);
        }catch (SQLException e){e.printStackTrace();}
        return Count_mt;
    }


    /* update MunicipalityName :BY BR Khaling*/
    public boolean updateMunicipality(Municipality mt)throws SQLException{
        boolean update_mt=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(UPDATE_MUNICIPALITY_SQL);
            ps.setString(1,mt.getMunicipalityName());
            ps.setInt(2,mt.getMunicipality_id());
            update_mt=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return update_mt;
    }

    /* selected by ID*/
    public Municipality selectMunicipalityById(int Municipality_id)throws  SQLException{
        Municipality mt=null;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_MUNICIPALITY_BY_ID);
            ps.setInt(1,Municipality_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String MunicipalityName=rs.getString("MunicipalityName");
                mt=new Municipality(Municipality_id,MunicipalityName);
            }
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return mt;
    }

    /*Select All MunicipalityName and Search Name:BY BR Khaling*/
    public List<Municipality> selectAllMunicipalitys(String SearchMunicipality) throws SQLException, ClassNotFoundException {
        List<Municipality> municipalities = new ArrayList<Municipality>();
        try {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String query = null;
            if (SearchMunicipality != null) {
                query = "select *from tbl_municipality where MunicipalityName like '%" + SearchMunicipality + "%'";
            } else {
                query = "select *from tbl_municipality ORDER BY Municipality_id";
            }
            System.out.println(st);
            rs = st.executeQuery(query);
            while (rs.next()) {
                int Municipality_id = rs.getInt("Municipality_id");
                String MunicipalityName = rs.getString("MunicipalityName");
                municipalities.add(new Municipality(Municipality_id, MunicipalityName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  municipalities;
    }
    /* Delete MunicipalityName : BY BR Khaling*/
    public boolean deleteMunicipality(int Municipality_id)throws SQLException{
        boolean delete_mt=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_MUNICIPALITY_SQL);
            ps.setInt(1,Municipality_id);
            delete_mt=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return delete_mt;
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
