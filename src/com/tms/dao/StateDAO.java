package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.State;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StateDAO {

    private static final String INSERT_STATE_SQL = "INSERT INTO tbl_state" + "(StateName) VALUES" + "(?);";
    private static final String SELECT_STATE_BY_ID = "select State_id,StateName from tbl_state where State_id=?";
    private static final String SELECT_ALL_STATES = "SELECT State_id, StateName from tbl_state";
    private static final String DELETE_STATE_SQL = "delete from tbl_state where State_id=?;";
    private static final String UPDATE_STATE_SQL = "update tbl_state set StateName=? where State_id=?;";

    public StateDAO(){}

    /*Create or insert State :By BR Khaling*/
    public static boolean insertState(State s)throws SQLException {
        boolean scop_s=false;
        try
        {
            Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_STATE_SQL);
            ps.setString(1,s.getStateName());
            scop_s=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return scop_s;
    }

    /* check whether exist stateName :By BR Khaling*/
    public static  boolean existState(String stateName)throws ClassNotFoundException,SQLException{
        boolean Count_s=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            Statement st=null;
            st=conn.createStatement();
            ResultSet rs=null;
            String existquery="select *from tbl_state where StateName='"+stateName+"'";
            rs=st.executeQuery(existquery);
            rs.next();
            Count_s=rs.getBoolean(1);
            System.out.println(Count_s);
        }catch (SQLException e){e.printStackTrace();}
        return Count_s;
    }

    /* update StateName :By BR Khaling*/
    public boolean updateState(State s)throws SQLException{
        boolean update_s=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(UPDATE_STATE_SQL);
            ps.setString(1,s.getStateName());
            ps.setInt(2,s.getState_id());
            update_s=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return update_s;
    }

    /* selected by ID*/
    public State selectStateById(int State_id)throws  SQLException{
        State s=null;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_STATE_BY_ID);
            ps.setInt(1,State_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String StateName=rs.getString("StateName");
                s=new State(State_id,StateName);
            }
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return s;
    }

    /*Select All StateNames and Search Name :By BR Khaling*/
    public List<State> selectAllStates(String SearchState) throws SQLException, ClassNotFoundException {
        List<State> states = new ArrayList<State>();
        try {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String query = null;
            if (SearchState != null) {
                query = "select *from tbl_state where StateName like '%" + SearchState + "%'";
            } else {
                query = "select *from tbl_state ORDER BY State_id";
            }
            System.out.println(st);
            rs = st.executeQuery(query);
            while (rs.next()) {
                int State_id = rs.getInt("State_id");
                String StateName = rs.getString("StateName");
                states.add(new State(State_id, StateName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  states;
    }

    /* Delete StateName :By BR Khaling*/
    public boolean deleteState(int State_id)throws SQLException{
        boolean delete_s=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_STATE_SQL);
            ps.setInt(1,State_id);
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
