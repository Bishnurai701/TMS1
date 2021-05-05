package com.tms.web;

import com.tms.dao.CountryDAO;
import com.tms.model.Country;

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

@WebServlet(name = "CountryServlet",urlPatterns = {("/list_country"),("/new_country"),("/insert_country"),("/delete_country"),("/edit_country"),("/update_country")})
public class CountryServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
private CountryDAO countryDAO;
public void init(){this.countryDAO =new CountryDAO();}



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String action=request.getServletPath();
            switch (action){
                case "/new_country":
                    try {
                        showNewForm(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case "/insert_country":
                    try {
                        insertCountry(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case "/delete_country":
                    try {
                        deleteCountry(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case "/edit_country":
                    try {
                        showEditForm(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case "/update_country":
                    try {
                        updateCountry(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    try {
                        listCountry(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
            }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("countryform.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCountry(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException, ClassNotFoundException {
        HttpSession session=request.getSession();
        try {
            int CountryCode=Integer.parseInt(request.getParameter("CountryCode"));
            String CountryName = request.getParameter("CountryName");
            Country newCountry = new Country(CountryCode,CountryName);

            if(CountryCode==0 && CountryName=="")
            {
                request.getSession().setAttribute("notnullMessage", "CountryName Null!");
                session.removeAttribute("alertMessage");
                session.removeAttribute("existMessage");
                response.sendRedirect("countryform.jsp");
            }
            else
            {
                    //String LoginName=request.getParameter("UserLoginName");
                    if((CountryDAO.existCountry(CountryCode,CountryName)) == false)
                    {
                        CountryDAO.insertCountry(newCountry);
                        if (newCountry != null) {
                            //UserDAO.existUser(UserName, UserLoginName);
                            request.getSession().setAttribute("successMessage", "Saved Successfully!");
                            session.removeAttribute("updateMessage");
                            session.removeAttribute("deleteMessage");
                            response.sendRedirect("list_country");
                        }
                        else
                        {
                            request.getSession().setAttribute("alertMessage", "WrongCountry!");
                            session.removeAttribute("notnullMessage");
                            session.removeAttribute("existMessage");
                            response.sendRedirect("countryform.jsp");
                        }
                    }
                    else
                    {
                        request.getSession().setAttribute("existMessage", "AlreadyExist!");
                        session.removeAttribute("notnullMessage");
                        session.removeAttribute("alertMessage");
                        response.sendRedirect("countryform.jsp");
                    }
            }
        }catch (SQLException e){ e.printStackTrace();

        }
    }

    private void deleteCountry(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Country_id=Integer.parseInt(request.getParameter("Country_id"));
        if(countryDAO.deleteCountry(Country_id)==true){
            request.getSession().setAttribute("deleteMessage", "Deleted Success!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_country");
        }
        else {
            request.getSession().setAttribute("deleteMessage", "Not Deleted!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_country");
        }
    }

    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int Country_id=Integer.parseInt(request.getParameter("Country_id"));
        Country existingCountry = countryDAO.selectCountryById(Country_id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("countryform.jsp");
        request.setAttribute("country", existingCountry);
        dispatcher.forward(request,response);

    }

    private void updateCountry(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Country_id=Integer.parseInt(request.getParameter("Country_id"));
        int CountryCode=Integer.parseInt(request.getParameter("CountryCode"));
        String CountryName=request.getParameter("CountryName");
        Country country =new Country(Country_id,CountryCode,CountryName);
        countryDAO.updateCountry(country);
        if(country != null)
        {
            request.getSession().setAttribute("updateMessage", "Update Successfully!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_country");

        }
        else {
            request.getSession().setAttribute("updateMessage", "Not Updated!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_country");
        }
    }

    private void listCountry(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Country> country =new ArrayList<Country>();
        String SearchCountry=request.getParameter("SearchCountry");
        country = countryDAO.selectAllCountrys(SearchCountry);
        request.setAttribute("listCountry", country);
        RequestDispatcher dispatcher=request.getRequestDispatcher("countrylist.jsp");
        dispatcher.forward(request,response);
    }


}
