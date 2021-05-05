package com.tms.web;

import com.tms.dao.UserRollDAO;
import com.tms.db.DBConnection;
import com.tms.model.User;
import com.tms.model.UserRoll;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "/UserRollServlet",urlPatterns = {"/listroll","/newroll","/insertroll","/deleteroll","/editroll","/updateroll"})
public class UserRollServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserRollDAO userRollDAO;


    public void init() {
        this.userRollDAO = new UserRollDAO();
    }

    public void init1() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        DBConnection connection = new DBConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/newroll":
                showNewFormUserRoll(request,response);
                break;
            case "/insertroll":
                try {
                    insertUserRoll(request,response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "/deleteroll":
                try {
                    deleteUserRoll(request,response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/editroll":
                try {
                    showEditFormUserRoll(request,response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;
            case "/updateroll":
                try {
                    updateUserRoll(request,response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listUserRoll(request,response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }


    private void showNewFormUserRoll(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        RequestDispatcher dispatcher=request.getRequestDispatcher("userrollform.jsp");
        dispatcher.forward(request,response);
    }

    private void insertUserRoll(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ParseException {
        try {
            String UserRollName = request.getParameter("UserRollName");
            UserRoll newUserRoll = new UserRoll(UserRollName);
            if(UserRollName==""){
                request.getSession().setAttribute("notnullMessage", "UserRoll Null");
                response.sendRedirect("userrollform.jsp");
            }
            else
            {
                if(UserRollDAO.existUserRoll(UserRollName) == false)
                {
                    UserRollDAO.insertUserRoll(newUserRoll);
                    if(newUserRoll != null){
                        request.getSession().setAttribute("successMessage", "Save Successfully!");
                        response.sendRedirect("listroll");
                    }
                    else
                    {
                        request.getSession().setAttribute("alertMessage", "WrongUserGroup!");
                        response.sendRedirect("userrollform.jsp");
                    }
                }
                else
                {
                    request.getSession().setAttribute("existMessage", "AlreadyExist!");
                    response.sendRedirect("userrollform.jsp");
                }
            }
        }catch (IOException ex){ex.printStackTrace();}
    }

    private void deleteUserRoll(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        int UserRoll_id=Integer.parseInt(request.getParameter("UserRoll_id"));
        userRollDAO.deleteUserRoll(UserRoll_id);
        response.sendRedirect("listroll");
    }

    private void showEditFormUserRoll(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        int UserRoll_id=Integer.parseInt(request.getParameter("UserRoll_id"));
        UserRoll existingUserRoll= userRollDAO.getUserRollById(UserRoll_id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("userrollform.jsp");
        request.setAttribute("userroll",existingUserRoll);
        dispatcher.forward(request,response);

    }

    private void updateUserRoll(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        int UserRoll_id=Integer.parseInt(request.getParameter("UserRoll_id"));
        String UserRollName=request.getParameter("UserRollName");
        UserRoll userroll=new UserRoll(UserRoll_id,UserRollName);
        userRollDAO.updateUserRoll(userroll);
        response.sendRedirect("listroll");
    }

    private void listUserRoll(HttpServletRequest request,HttpServletResponse response)throws SQLException,IOException,ServletException{
        List<UserRoll> listroll=new ArrayList<UserRoll>();
        String SearchUserRoll=request.getParameter("SearchUserRoll");
        listroll=userRollDAO.getAllUserRolls(SearchUserRoll);
        request.setAttribute("listUserRoll",listroll);
        RequestDispatcher dispatcher=request.getRequestDispatcher("userrolllist.jsp");
        dispatcher.forward(request,response);
    }


}
