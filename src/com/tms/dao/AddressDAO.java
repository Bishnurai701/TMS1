package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {
    /* Address */
    private static final String INSERT_ADDRESS_SQL = "INSERT INTO tbl_address" + "(AddressType_id,Registration_id,Address_MunicipalityName,Municipality_id,StreetName,WardNo,Country_id,State_id,District_id,CityName) VALUES" + "(?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_ADDRESS_BY_ID = "select Address_id,AddressType_id,Registration_id,Address_MunicipalityName,Municipality_id,StreetName,WardNo,Country_id,State_id,District_id,CityName from tbl_address where Address_id=?";
    private static final String SELECT_ALL_ADDRESS = "SELECT Department_id, DepartmentName from tbl_department";
    private static final String DELETE_ADDRESS_SQL = "delete from tbl_address where Address_id=?;";
    private static final String UPDATE_ADDRESS_SQL = "update tbl_address set AddressType_id=?,Registration_id=?,Address_MunicipalityName=?,Municipality_id=?,StreetName=?,WardNo=?,Country_id=?,State_id=?,District_id=?,CityName=? where Address_id=?;";



    public static boolean insertAddress(Address address)throws IOException,ClassNotFoundException {
        boolean scope_address=false;
        try
        {
            Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_ADDRESS_SQL);
            ps.setInt(1,address.getAddressType_id());
            ps.setInt(2, address.getRegistration_id());
            ps.setString(3, address.getAddress_MunicipalityName());
            ps.setInt(4, address.getMunicipality_id());
            ps.setString(5, address.getStreetName());
            ps.setInt(6, address.getWardNo());
            ps.setInt(7, address.getCountry_id());
            ps.setInt(8, address.getState_id());
            ps.setInt(9, address.getDistrict_id());
            ps.setString(10,address.getCityName());
            scope_address=ps.executeUpdate()>0;
        }catch (SQLException e){e.printStackTrace();}
        return scope_address;
    }


    public List<Address> droplistCountryName() throws SQLException, IOException {
        List<Address> listCountryDrop = new ArrayList<Address>();
        try {
            Connection conn = DBConnection.createConnection();
            PreparedStatement ps = conn.prepareStatement("select Country_id,CountryName from tbl_country");
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Country_id = rs.getInt("Country_id");
                String CountryName = rs.getString("CountryName");
                Address countrylist = new Address(Country_id, CountryName);
                listCountryDrop.add(countrylist);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listCountryDrop;
    }

    public List<State> droplistStateName() throws IOException, SQLException {
        List<State> listStateDrop = new ArrayList<State>();
        try {
            Connection conn = DBConnection.createConnection();
            PreparedStatement ps = conn.prepareStatement("select State_id,StateName from tbl_state");
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int State_id = rs.getInt("State_id");
                String StateName = rs.getString("StateName");
                State statelist = new State(State_id, StateName);
                listStateDrop.add(statelist);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listStateDrop;
    }

    public List<District> droplistDistrictName() throws SQLException {
        List<District> listDistrictDrop = new ArrayList<District>();
        try {
            Connection conn = DBConnection.createConnection();
            PreparedStatement ps = conn.prepareStatement("select District_id,DistrictName from tbl_district");
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int District_id = rs.getInt("District_id");
                String DistrictName = rs.getString("DistrictName");
                District districtlist = new District(District_id, DistrictName);
                listDistrictDrop.add(districtlist);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listDistrictDrop;
    }

    public List<Municipality> droplistMunicipalityName() throws SQLException {
        List<Municipality> listMunicipalityDrop = new ArrayList<Municipality>();
        try {
            Connection conn = DBConnection.createConnection();
            PreparedStatement ps = conn.prepareStatement("select Municipality_id,MunicipalityName from tbl_municipality");
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Municipality_id = rs.getInt("Municipality_id");
                String MunicipalityName = rs.getString("MunicipalityName");
                Municipality municipalitylist = new Municipality(Municipality_id, MunicipalityName);
                listMunicipalityDrop.add(municipalitylist);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listMunicipalityDrop;
    }

    public List<Registration> droplistRegistrationName()throws IOException {
        List<Registration> listRegistrationDrop=new ArrayList<Registration>();
        try {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement("select Registration_id,FirstName from tbl_registration");
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int Registration_id=rs.getInt("Registration_id");
                String FirstName=rs.getString("FirstName");
                Registration registrationlist=new Registration(Registration_id,FirstName);
                listRegistrationDrop.add(registrationlist);
            }
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return listRegistrationDrop;
    }

    public boolean deleteAddress(int Address_id)throws IOException,ClassNotFoundException {
        boolean delete_address=false;
        try {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_ADDRESS_SQL);
            ps.setInt(1,Address_id);
            delete_address=ps.executeUpdate()>0;
        }catch (SQLException e){e.printStackTrace();}
        return delete_address;
    }

    public Address selectAddressById(int Address_id)throws IOException,ClassNotFoundException {
        Address address =null;
        try{
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_ADDRESS_BY_ID);
            ps.setInt(1,Address_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int AddressType_id=rs.getInt("AddressType_id");
                int Registration_id=rs.getInt("Registration_id");
                String Address_MunicipalityName=rs.getString("Address_MunicipalityName");
                int Municipality_id=rs.getInt("Municipality_id");
                String StreetName=rs.getString("StreetName");
                int WardNo=rs.getInt("WardNo");
                int Country_id=rs.getInt("Country_id");
                int State_id=rs.getInt("State_id");
                int District_id=rs.getInt("District_id");
                String CityName=rs.getString("CityName");
                address =new Address( Address_id,AddressType_id,Registration_id,Address_MunicipalityName,Municipality_id,StreetName,WardNo,Country_id,State_id,District_id,CityName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }


    public boolean updateAddress(Address address)throws IOException,ClassNotFoundException {
        boolean update_address=false;
        try{
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(UPDATE_ADDRESS_SQL);
            ps.setInt(1,address.getAddressType_id());
            ps.setInt(2, address.getRegistration_id());
            ps.setString(3, address.getAddress_MunicipalityName());
            ps.setInt(4, address.getMunicipality_id());
            ps.setString(5, address.getStreetName());
            ps.setInt(6, address.getWardNo());
            ps.setInt(7, address.getCountry_id());
            ps.setInt(8, address.getState_id());
            ps.setInt(9, address.getDistrict_id());
            ps.setString(10,address.getCityName());
            ps.setInt(11, address.getAddress_id());
            update_address=ps.executeUpdate()>0;
        }catch (SQLException e){e.printStackTrace();}
        return update_address;
    }

    public List<Address> selectAllAddress(String SearchAddress)throws IOException,ClassNotFoundException {
        List<Address> address=new ArrayList<Address>();
        try{
            Connection conn=DBConnection.createConnection();
            Statement st=null;
            st=conn.createStatement();
            ResultSet rs=null;
            String query=null;
            if(SearchAddress != null)
            {
                query="select Address_id,AddressTypeName, FirstName,Address_MunicipalityName,StreetName,WardNo,StateName, DistrictName,\n" +
                        "MunicipalityName,CountryName,CityName\n" +
                        "from tbl_address\n" +
                        "inner join tbl_addresstype using (AddressType_id)" +
                        "inner join tbl_registration using (Registration_id)" +
                        "inner join tbl_state using (State_id)\n" +
                        "inner join tbl_district using (District_id)\n" +
                        "inner join tbl_municipality using (Municipality_id)\n" +
                        "inner join  tbl_country using (Country_id)" +
                        "where FirstName like'%"+SearchAddress+"%' or StateName like '%"+SearchAddress+"%' or DistrictName like '%"+SearchAddress+"%' or " +
                        "Address_MunicipalityName like'%"+SearchAddress+"%' or  AddressTypeName like '%"+SearchAddress+"%' or CountryName like '%"+SearchAddress+"%' or" +
                        " DistrictName like '%"+SearchAddress+"%'";
            }
            else
            {
                query="select Address_id,AddressTypeName,FirstName, Address_MunicipalityName,StreetName,WardNo,StateName, DistrictName,\n" +
                        "MunicipalityName,CountryName,CityName\n" +
                        "from tbl_address\n" +
                        "inner join tbl_addresstype using (AddressType_id)" +
                        "inner join tbl_registration using (Registration_id)" +
                        "inner join tbl_state using (State_id)\n" +
                        "inner join tbl_district using (District_id)\n" +
                        "inner join tbl_municipality using (Municipality_id)\n" +
                        "inner join  tbl_country using (Country_id)";
            }
            System.out.println(st);
            rs=st.executeQuery(query);
            while (rs.next()){
                int Address_id=rs.getInt("Address_id");
                String AddressTypeName=rs.getString("AddressTypeName");
                String FirstName=rs.getString("FirstName");
                String Address_MunicipalityName=rs.getString("Address_MunicipalityName");
                String StreetName=rs.getString("StreetName");
                int WardNo=rs.getInt("WardNo");
                String StateName=rs.getString("StateName");
                String DistrictName=rs.getString("DistrictName");
                String MunicipalityName=rs.getString("MunicipalityName");
                String CountryName=rs.getString("CountryName");
                String CityName=rs.getString("CityName");
                address.add(new Address(Address_id,AddressTypeName,FirstName,Address_MunicipalityName,StreetName,WardNo,StateName,DistrictName,MunicipalityName,CountryName,CityName));
            }
        }catch (SQLException e){e.printStackTrace();}
        return address;
    }

    public List<AddressType> droplistAddressTypeName()throws IOException,ClassNotFoundException {
        List<AddressType> listAddressTypeDrop=new ArrayList<AddressType>();
        try{
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement("select AddressType_id,AddressTypeName from tbl_addresstype");
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int AddressType_id=rs.getInt("AddressType_id");
                String AddressTypeName=rs.getString("AddressTypeName");
                AddressType addressTypelist=new AddressType(AddressType_id,AddressTypeName);
                listAddressTypeDrop.add(addressTypelist);
            }
        }catch (SQLException e){e.printStackTrace();}
        return listAddressTypeDrop;
    }
}
