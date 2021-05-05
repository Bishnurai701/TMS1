package com.tms.dao;
import com.tms.db.DBConnection;
import com.tms.model.Country;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {
    private static final String INSERT_COUNTRY_SQL = "INSERT INTO tbl_country" + "(CountryCode,CountryName) VALUES" + "(?,?);";
    private static final String SELECT_COUNTRY_BY_ID = "select Country_id,CountryCode,CountryName from tbl_country where Country_id=?";
    private static final String SELECT_ALL_COUNTRY = "SELECT Country_id,CountryCode, CountryName from tbl_country";
    private static final String DELETE_COUNTRY_SQL = "delete from tbl_country where Country_id=?;";
    private static final String UPDATE_COUNTRY_SQL = "update tbl_country set CountryCode=?,CountryName=? where Country_id=?;";

    public CountryDAO(){}

    /*Create or insert Country*/
    public static boolean insertCountry(Country c)throws SQLException{
        boolean scop_c=false;
        try
        {
            Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_COUNTRY_SQL);
            ps.setInt(1,c.getCountryCode());
            ps.setString(2,c.getCountryName());
            scop_c=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return scop_c;
    }

    /* check whether exist CountryName */
    public static  boolean existCountry(int countryCode,String countryName)throws ClassNotFoundException,SQLException{
        boolean Count_c=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            Statement st=null;
            st=conn.createStatement();
            ResultSet rs=null;
            String existquery="select *from tbl_country where CountryCode='"+countryCode+"' && CountruName='"+countryName+"'";
            rs=st.executeQuery(existquery);
            rs.next();
            Count_c=rs.getBoolean(1);
            System.out.println(Count_c);
        }catch (SQLException e){e.printStackTrace();}
        return Count_c;
    }

    /* update CountryName*/
    public boolean updateCountry(Country c)throws SQLException{
        boolean update_c=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(UPDATE_COUNTRY_SQL);
            ps.setInt(1,c.getCountryCode());
            ps.setString(2,c.getCountryName());
            ps.setInt(3,c.getCountry_id());
            update_c=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return update_c;
    }

    /* selected by ID*/
    public Country selectCountryById(int Country_id)throws  SQLException{
        Country c=null;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_COUNTRY_BY_ID);
            ps.setInt(1,Country_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int CountryCode=rs.getInt("CountryCode");
                String CountryName=rs.getString("CountryName");
                c=new Country(Country_id,CountryCode,CountryName);
            }
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return c;
    }

    /*Select All CountryNames and Search Name*/
    public List<Country> selectAllCountrys(String SearchCountry) throws SQLException, ClassNotFoundException {
        List<Country> country = new ArrayList<Country>();
        try {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String query = null;
            if (SearchCountry !=null) {
                query = "select *from tbl_country where CountryCode like '%" + SearchCountry + "%' || CountryName like '%"+SearchCountry+"%'";
            } else {
                query = "select *from tbl_country ORDER BY Country_id";
            }
            System.out.println(st);
            rs = st.executeQuery(query);
            while (rs.next()) {
                int Country_id = rs.getInt("Country_id");
                int CountryCode=rs.getInt("CountryCode");
                String CountryName = rs.getString("CountryName");
                country.add(new Country(Country_id, CountryCode,CountryName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }

    /* Delete CountryName*/
    public boolean deleteCountry(int Country_id)throws SQLException{
        boolean delete_c=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_COUNTRY_SQL);
            ps.setInt(1,Country_id);
            delete_c=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return delete_c;
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


    public int getNoOfRecords()throws SQLException {
        boolean count = false;
        try {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String countquery = "select count(*) from tbl_country";
            rs = st.executeQuery(countquery);
            rs.next();
            count = rs.getBoolean(1);
            System.out.println(count);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return getNoOfRecords();
    }


}


