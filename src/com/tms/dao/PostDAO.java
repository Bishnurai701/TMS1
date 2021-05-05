package com.tms.dao;
import com.tms.db.DBConnection;
import com.tms.model.Post;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    private static final String INSERT_POST_SQL = "INSERT INTO tbl_post" + "(PostName) VALUES" + "(?);";
    private static final String SELECT_POST_BY_ID = "select Post_id,PostName from tbl_post where Post_id=?";
    private static final String SELECT_ALL_POST = "SELECT Post_id,PostName from tbl_post";
    private static final String DELETE_POST_SQL = "delete from tbl_post where Post_id=?;";
    private static final String UPDATE_POST_SQL = "update tbl_post set PostName=? where Post_id=?;";

    public PostDAO(){}

    /*Create or insert Post:By BR Khaling*/
    public static boolean insertPost(Post p)throws SQLException {
        boolean scop_p=false;
        try
        {
            Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_POST_SQL);
            ps.setString(1,p.getPostName());
            scop_p=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return scop_p;
    }

    /* check whether exist POstName :By BR Khaling */
    public static  boolean existPost(String postName)throws ClassNotFoundException,SQLException{
        boolean Count_p=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            Statement st=null;
            st=conn.createStatement();
            ResultSet rs=null;
            String existquery="select *from tbl_post where PostName='"+postName+"'";
            rs=st.executeQuery(existquery);
            rs.next();
            Count_p=rs.getBoolean(1);
            System.out.println(Count_p);
        }catch (SQLException e){e.printStackTrace();}
        return Count_p;
    }
    /* update PostName :BY BR Khaling*/
    public boolean updatePost(Post p)throws SQLException{
        boolean update_p=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(UPDATE_POST_SQL);
            ps.setString(1,p.getPostName());
            ps.setInt(2,p.getPost_id());
            update_p=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return update_p;
    }

    /* selected by ID*/
    public Post selectPostById(int Post_id)throws  SQLException{
        Post post=null;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_POST_BY_ID);
            ps.setInt(1,Post_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String PostName=rs.getString("PostName");
                post=new Post(Post_id,PostName);
            }
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return post;
    }

    /*Select All PostName and Search Post*/
    public List<Post> selectAllPosts(String SearchPost) throws SQLException, ClassNotFoundException {
        List<Post> post = new ArrayList<Post>();
        try {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String query = null;
            if (SearchPost !=null) {
                query = "select *from tbl_post where PostName like '%" + SearchPost + "%' ";
            } else {
                query = "select *from tbl_post ORDER BY Post_id";
            }
            System.out.println(st);
            rs = st.executeQuery(query);
            while (rs.next()) {
                int Post_id = rs.getInt("Post_id");
                String PostName = rs.getString("PostName");
                post.add(new Post(Post_id, PostName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }


    /* Delete PostName :BY BR Khaling*/
    public boolean deletePost(int Post_id)throws SQLException{
        boolean delete_p=false;
        try
        {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_POST_SQL);
            ps.setInt(1,Post_id);
            delete_p=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return delete_p;
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
