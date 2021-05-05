package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.Country;
import com.tms.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    private static final String INSERT_DEPARTMENT_SQL = "INSERT INTO tbl_department" + "(DepartmentName) VALUES" + "(?);";
    private static final String SELECT_DEPARTMENT_BY_ID = "select Department_id,DepartmentName from tbl_department where Department_id=?";
    private static final String SELECT_ALL_DEPARTMENT = "SELECT Department_id, DepartmentName from tbl_department";
    private static final String DELETE_DEPARTMENT_SQL = "delete from tbl_department where Department_id=?;";
    private static final String UPDATE_DEPARTMENT_SQL = "update tbl_department set DepartmentName=? where Department_id=?;";

    public DepartmentDAO(){}

    /*Create or insert Department:By BR Khaling*/
    public static boolean insertDepartment(Department d)throws SQLException {
        boolean scop_d=false;
        try
        {
            Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_DEPARTMENT_SQL);
            ps.setString(1,d.getDepartmentName());
            scop_d=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return scop_d;
    }
    /* check whether exist DepartmentName */
    public static  boolean existDepartment(String departmentName)throws ClassNotFoundException,SQLException{
        boolean Count_d=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            Statement st=null;
            st=conn.createStatement();
            ResultSet rs=null;
            String existquery="select *from tbl_department where DepartmentName='"+departmentName+"'";
            rs=st.executeQuery(existquery);
            rs.next();
            Count_d=rs.getBoolean(1);
            System.out.println(Count_d);
        }catch (SQLException e){e.printStackTrace();}
        return Count_d;
    }

    /* update DepartmentName :BY BR Khaling*/
    public boolean updateDepartment(Department d)throws SQLException{
        boolean update_d=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(UPDATE_DEPARTMENT_SQL);
            ps.setString(1,d.getDepartmentName());
            ps.setInt(2,d.getDepartment_id());
            update_d=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return update_d;
    }

    /* selected by ID*/
    public Department selectDepartmentById(int Department_id)throws  SQLException{
        Department department=null;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_DEPARTMENT_BY_ID);
            ps.setInt(1,Department_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String DepartmentName=rs.getString("DepartmentName");
                department=new Department(Department_id,DepartmentName);
            }
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return department;
    }

    /*Select All DepartmentNames and Search Name*/
    public List<Department> selectAllDepartments(String SearchDepartment) throws SQLException, ClassNotFoundException {
        List<Department> department = new ArrayList<Department>();
        try {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String query = null;
            if (SearchDepartment != null) {
                query = "select *from tbl_department where DepartmentName like '%" + SearchDepartment + "%'";
            } else {
                query = "select *from tbl_department ORDER BY Department_id";
            }
            System.out.println(st);
            rs = st.executeQuery(query);
            while (rs.next()) {
                int Department_id = rs.getInt("Department_id");
                String DepartmentName = rs.getString("DepartmentName");
                department.add(new Department(Department_id, DepartmentName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    /* Delete DepartmentName*/
    public boolean deleteDepartment(int Department_id)throws SQLException{
        boolean delete_d=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_DEPARTMENT_SQL);
            ps.setInt(1,Department_id);
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
