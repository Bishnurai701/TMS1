package com.tms.web;


import com.tms.dao.UserDAO;
import com.tms.dao.UserGroupDAO;
import com.tms.dao.UserRollDAO;
import com.tms.model.User;
import com.tms.db.DBConnection;
import com.tms.model.UserGroup;
import com.tms.model.UserRoll;
import com.tms.model.User_Roll_Drop;


import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@WebServlet(name="/UserServlet",urlPatterns= {("/list_user"),("/new_user"),("/insert_user"),("/delete_user"),("/edit_user"),("/update_user")})  /*{("/list"),("/new"),("/insert"),("/delete"),("/edit"),("/update")}*/
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    private DBConnection dbConnection;
    public static final int PASSWORS_LENGTH=8;


    public void init() {
        this.userDAO = new UserDAO();
    }

    public void init1() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        dbConnection = new DBConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
        int UserGroup_id = Integer.parseInt(request.getParameter("UserGroup_id"));

        request.setAttribute("usergroup", UserGroup_id);

        try {
            listUserGroupDrop(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
*/
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getServletPath();
        switch (action) {
            case "/new_user":
                try {
                    showNewForm(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/insert_user":
                try {
                    insertUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete_user":
                try {
                    deleteUser(request, response);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit_user":
                try {
                    showEditForm(request, response);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/update_user":
                try {
                    updateUser(request, response);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listUser(request, response);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }

    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("userform.jsp");
        dispatcher.forward(request, response);
    }


    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException, ClassNotFoundException {
        //HttpSession session=request.getSession();
        try {

            String UserName = request.getParameter("UserName");
            String UserLoginName = request.getParameter("UserLoginName");
            String Password = request.getParameter("Password");
            int UserGroup_id = Integer.parseInt(request.getParameter("UserGroup_id"));
            //String UserGroup_id=request.getParameter("id");
            //String usergroup=Integer.toString(UserGroup_id);
            //int QRAndThump_id=Integer.parseInt("QRAndThump_id");
            //int Registration_id=Integer.parseInt("Registration_id");
            //String CreatedBy=request.getParameter("CreatedBy");
            //String ModifiedBy=request.getParameter("ModifiedBy");
            //Date ModifiedDate=Date.valueOf(request.getParameter("ModifiedDate"));
            //String urid=request.getParameter("UserRoll_id");
            int UserRoll_id = Integer.parseInt(request.getParameter("UserRoll_id"));
            int Status = Integer.parseInt(request.getParameter("Status"));
            if (Status == 1) {
                Status = 1;
            } else {
                Status = 0;
            }
            User newUser = new User(UserName, UserLoginName, Password, UserGroup_id, UserRoll_id, Status);

            if((UserName=="") && (UserLoginName=="") && (Password==""))
            {
                request.getSession().setAttribute("notnullMessage", "Not Null!");
                response.sendRedirect("userform.jsp");
            }
            else
            {
                if (UserServlet.is_valid_password(Password) == true)
                {
                    //String LoginName=request.getParameter("UserLoginName");
                    if((UserDAO.existUser(UserLoginName)) == false)
                    {
                        UserDAO.insertUser(newUser);
                        if (newUser != null) {
                            //UserDAO.existUser(UserName, UserLoginName);
                            request.getSession().setAttribute("successMessage", "Registered Successfully!");
                            response.sendRedirect("list_user");
                        }
                        else
                        {
                            request.getSession().setAttribute("alertMessage", "WrongPassword!");
                            response.sendRedirect("userform.jsp");
                        }
                    }
                    else
                    {
                        request.getSession().setAttribute("existMessage", "AlreadyExist!");
                        response.sendRedirect("userform.jsp");
                    }

                }
                else
                {
                    request.getSession().setAttribute("alertMessage", "WrongPassword!");
                    request.getSession().setAttribute("errorMessage", "| min2number required");
                    response.sendRedirect("userform.jsp");
                }
            }
        }catch (SQLException e){ e.printStackTrace();

        }
    }
    private static boolean is_valid_password(String Password)throws IOException{
        if(Password.length()<PASSWORS_LENGTH) return false;
        int charCount=0;
        int numCount=0;
        for(int i=0;i<Password.length();i++){
            char ch=Password.charAt(i);
            if(is_Numeric(ch))numCount++;
            else if(is_Letter(ch)) charCount++;
            else return false;
        }
        return (charCount>=2 && numCount>=2);
    }
    public static boolean is_Numeric(char ch){
        return (ch>='0' && ch<='9');
    }
    public static boolean is_Letter(char ch){
        ch=Character.toUpperCase(ch);
        return (ch>='A'&&ch<='Z');
    }

    private void deleteUser(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        int User_id=Integer.parseInt(request.getParameter("User_id"));
        userDAO.deleteUser(User_id);
        response.sendRedirect("list_user");
    }
    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int User_id=Integer.parseInt(request.getParameter("User_id"));
        User existingUser= userDAO.selectUserId(User_id);

        List<User> listGroupDrop = new ArrayList<User>();
        listGroupDrop = userDAO.droplistUG();
        request.setAttribute("listUserGroupDrop", listGroupDrop); //listUserGroupDrop


        List<User_Roll_Drop> listRollDrop = new ArrayList<User_Roll_Drop>();
        listRollDrop = userDAO.droplistUR();




        RequestDispatcher dispatcher=request.getRequestDispatcher("userform.jsp");
        request.setAttribute("listUserGroupDrop", listGroupDrop); //listUserGroupDrop
        request.setAttribute("listUserRollDrop", listRollDrop); //listUserRollDrop
        request.setAttribute("user",existingUser);
        dispatcher.forward(request,response);

    }
    private void updateUser(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        int User_id=Integer.parseInt(request.getParameter("User_id"));
        String UserName=request.getParameter("UserName");
        String UserLoginName=request.getParameter("UserLoginName");
        int UserGroup_id=Integer.parseInt(request.getParameter("UserGroup_id"));
        if(UserGroup_id != 0)
        {
            UserGroup_id=UserGroup_id;
        }

        //int QRAndThump_id=Integer.parseInt(request.getParameter("QRAndThump_id"));
        //int Registration_id=Integer.parseInt(request.getParameter("Registration_id"));
        //String CreatedBy=request.getParameter("CreatedBy");
        //String ModifiedBy=request.getParameter("ModifiedBy");
        //Date CreatedDate=Date.valueOf(request.getParameter("CreatedDate"));
        //Date ModifiedDate=Date.valueOf(request.getParameter("ModifiedDate"));
        int UserRoll_id= Integer.parseInt(request.getParameter("UserRoll_id"));
        if(UserRoll_id !=0)
        {
            UserRoll_id=UserRoll_id;
        }
        int Status=Integer.parseInt(request.getParameter("Status"));
        if(Status==1)
        {
            Status=1;
        }
        else
        {
            Status=0;
        }
        User user=new User(User_id,UserName,UserLoginName,UserGroup_id,UserRoll_id,Status);
        userDAO.updateUser(user);
        response.sendRedirect("list_user");
    }

    private void listUser(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<User> user=new ArrayList<User>();

        String SearchUser=request.getParameter("SearchUser");

        user=userDAO.selectAllUsers(SearchUser);
        request.setAttribute("listUser",user);
        RequestDispatcher dispatcher=request.getRequestDispatcher("userlist.jsp");
        dispatcher.forward(request,response);
    }


    public void listUserGroupDrop(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
            List<User> listGroupDrop=new ArrayList<User>();
            listGroupDrop=userDAO.droplistUG();
            request.setAttribute("listUserGroupDrop",listGroupDrop);


            List<User_Roll_Drop> listRollDrop=new ArrayList<User_Roll_Drop>();
            listRollDrop=userDAO.droplistUR();
            request.setAttribute("listUserRollDrop",listRollDrop);
            //UserDAO ugdao=new UserDAO();
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("userform.jsp");
            requestDispatcher.forward(request,response);

    }
    public void selectedUserGroupDrop(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        List<User> listGroupDrop=new ArrayList<User>();
        listGroupDrop=userDAO.droplistUG();
        request.setAttribute("listUserGroupDrop",listGroupDrop);
    }
/*
    public void listUserRollDrop(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException,SQLException,ClassNotFoundException{
        List<User_Roll_Drop> listRollDrop=new ArrayList<User_Roll_Drop>();
        listRollDrop=userDAO.droplistUR();
        //UserDAO ugdao=new UserDAO();
        request.setAttribute("listUserRollDrop",listRollDrop);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("userform.jsp");
        requestDispatcher.forward(request,response);

    }

*/
    private void SessionMessage(String msgClass,String msgMessage,boolean msgStatus){

    }


}
