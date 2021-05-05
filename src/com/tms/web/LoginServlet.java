package com.tms.web;

import com.tms.dao.LoginDAO;
import com.tms.model.Login;
import com.tms.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private LoginDAO loginDAO;

    public void init(){
        loginDAO=new LoginDAO();
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String UserName=request.getParameter("UserName");
        String UserLoginName = request.getParameter("UserLoginName");
        String Password = request.getParameter("Password");
        Login login = new Login();
        login.setUserName(UserName);
        login.setUserLoginName(UserLoginName);
        login.setPassword(Password);
        try {
            if (loginDAO.Userlogin(login))
            {
                HttpSession oldsession = request.getSession(false);

                if(oldsession==null)
                {
                    response.sendRedirect("login.jsp");
                    HttpSession session=request.getSession();
                    Cookie alertMessage=new Cookie("alertMessage","Wrong!");
                    response.addCookie(alertMessage);
                }
                HttpSession newsession=request.getSession(true);
                newsession.setAttribute("UserLoginName", UserLoginName);
                newsession.setMaxInactiveInterval(30*60);
                Cookie loginname=new Cookie("loginname",UserLoginName);
               Cookie message=new Cookie("message","Successfully:");
               response.addCookie(message);
               response.addCookie(loginname);
               response.sendRedirect("index.jsp");
            }

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

}
