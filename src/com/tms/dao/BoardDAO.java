package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.Board;
import com.tms.model.Faculty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    private static final String INSERT_BOARD_SQL = "INSERT INTO tbl_board" + "(BoardName) VALUES" + "(?);";
    private static final String SELECT_BOARD_BY_ID = "select Board_id,BoardName from tbl_board where Board_id=?";
    private static final String SELECT_ALL_BOARD = "SELECT Board_id, BoardName from tbl_board";
    private static final String DELETE_BOARD_SQL = "delete from tbl_board where Board_id=?;";
    private static final String UPDATE_BOARD_SQL = "update tbl_board set BoardName=? where Board_id=?;";
    public BoardDAO(){}

    /*Create or insert Item:By BR Khaling*/
    public static boolean insertBoard(Board board)throws SQLException {
        boolean scop_board=false;
        try
        {
            Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_BOARD_SQL);
            ps.setString(1,board.getBoardName());
            scop_board=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return scop_board;
    }

    /* check whether exist ItemName */
    public static  boolean existBoard(String boardName)throws ClassNotFoundException,SQLException{
        boolean Count_board=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            Statement st=null;
            st=conn.createStatement();
            ResultSet rs=null;
            String existquery="select *from tbl_board where BoardName='"+boardName+"'";
            rs=st.executeQuery(existquery);
            rs.next();
            Count_board=rs.getBoolean(1);
            System.out.println(Count_board);
        }catch (SQLException e){e.printStackTrace();}
        return Count_board;
    }

    /* update ItemName :BY BR Khaling*/
    public boolean updateBoard(Board board)throws SQLException{
        boolean update_board=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(UPDATE_BOARD_SQL);
            ps.setString(1,board.getBoardName());
            ps.setInt(2,board.getBoard_id());
            update_board=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return update_board;
    }

    /* selected by ID*/
    public  Board selectBoardById(int Board_id)throws  SQLException{
        Board b=null;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_BOARD_BY_ID);
            ps.setInt(1,Board_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String BoardName=rs.getString("BoardName");
                b=new Board(Board_id,BoardName);
            }
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return b;
    }
    /*Select All ItemName and Search ItemsNam*/
    public List<Board> selectAllBoards(String SearchBoard) throws SQLException, ClassNotFoundException {
        List<Board> board = new ArrayList<Board>();
        try {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String query = null;
            if (SearchBoard != null) {
                query = "select *from tbl_board where BoardName like '%" + SearchBoard + "%'";
            } else {
                query = "select *from tbl_board ORDER BY Board_id";
            }
            System.out.println(st);
            rs = st.executeQuery(query);
            while (rs.next()) {
                int Board_id = rs.getInt("Board_id");
                String BoardName = rs.getString("BoardName");
                board.add(new Board(Board_id, BoardName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return board;
    }

    /* Delete ItemsName*/
    public boolean deleteBoard(int Board_id)throws SQLException{
        boolean delete_board=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_BOARD_SQL);
            ps.setInt(1,Board_id);
            delete_board=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return delete_board;
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
