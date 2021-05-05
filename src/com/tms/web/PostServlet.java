package com.tms.web;

import com.tms.dao.CountryDAO;
import com.tms.dao.PostDAO;
import com.tms.model.Country;
import com.tms.model.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PostServlet",urlPatterns = {("/list_post"),("/new_post"),("/insert_post"),("/delete_post"),("/edit_post"),("/update_post")})
public class PostServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private PostDAO postDAO;
    public void init(){this.postDAO=new PostDAO();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/new_post":
                try {
                    showNewForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/insert_post":
                try {
                    insertPost(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete_post":
                try {
                    deletePost(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit_post":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/update_post":
                try {
                    updatePost(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listPost(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("postform.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException, ClassNotFoundException {
        HttpSession session=request.getSession();
        try {
            String PostName = request.getParameter("PostName");
            Post newPost = new Post(PostName);

            if(PostName=="")
            {
                request.getSession().setAttribute("notnullMessage", "PostName Null!");
                session.removeAttribute("alertMessage");
                session.removeAttribute("existMessage");
                response.sendRedirect("postform.jsp");
            }
            else
            {
                //String LoginName=request.getParameter("UserLoginName");
                if((PostDAO.existPost(PostName)) == false)
                {
                    PostDAO.insertPost(newPost);
                    if (newPost != null) {
                        //UserDAO.existUser(UserName, UserLoginName);
                        request.getSession().setAttribute("successMessage", "Saved Successfully!");
                        session.removeAttribute("updateMessage");
                        session.removeAttribute("deleteMessage");
                        response.sendRedirect("list_post");
                    }
                    else
                    {
                        request.getSession().setAttribute("alertMessage", "WrongCountry!");
                        session.removeAttribute("notnullMessage");
                        session.removeAttribute("existMessage");
                        response.sendRedirect("postform.jsp");
                    }
                }
                else
                {
                    request.getSession().setAttribute("existMessage", "AlreadyExist!");
                    session.removeAttribute("notnullMessage");
                    session.removeAttribute("alertMessage");
                    response.sendRedirect("postform.jsp");
                }
            }
        }catch (SQLException e){ e.printStackTrace();
        }
    }

    private void deletePost(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Post_id=Integer.parseInt(request.getParameter("Post_id"));
        if(postDAO.deletePost(Post_id)==true){
            request.getSession().setAttribute("deleteMessage", "Deleted Success!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_post");
        }
        else {
            request.getSession().setAttribute("deleteMessage", "Not Deleted!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_post");
        }
    }

    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int Post_id=Integer.parseInt(request.getParameter("Post_id"));
        Post existingPost = postDAO.selectPostById(Post_id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("postform.jsp");
        request.setAttribute("post", existingPost);
        dispatcher.forward(request,response);
    }

    private void updatePost(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Post_id=Integer.parseInt(request.getParameter("Post_id"));
        String PostName=request.getParameter("PostName");
        Post post =new Post(Post_id,PostName);
        postDAO.updatePost(post);
        if(post != null)
        {
            request.getSession().setAttribute("updateMessage", "Update Successfully!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_post");

        }
        else {
            request.getSession().setAttribute("updateMessage", "Not Updated!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_post");
        }
    }

    private void listPost(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Post> post =new ArrayList<Post>();
        String SearchPost=request.getParameter("SearchPost");
        post = postDAO.selectAllPosts(SearchPost);
        request.setAttribute("listPost", post);
        RequestDispatcher dispatcher=request.getRequestDispatcher("postlist.jsp");
        dispatcher.forward(request,response);
    }



}
