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
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "MasterMaintananceServlet")
public class MasterMaintananceServlet extends HttpServlet {

private static final long serialVersionUID=1L;
private PostDAO postDAO;

public void init(){this.postDAO=new PostDAO();}





    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    
}
