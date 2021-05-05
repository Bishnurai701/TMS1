package com.tms.web;

import com.tms.dao.CountryDAO;
import com.tms.dao.DistrictDAO;
import com.tms.model.Country;
import com.tms.model.District;

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

@WebServlet(name = "DistrictServlet",urlPatterns = {("/list_district"),("/new_district"),("/insert_district"),("/delete_district"),("/edit_district"),("/update_district")})
public class DistrictServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private DistrictDAO districtDAO;
    public void init(){this.districtDAO=new DistrictDAO();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getServletPath();
        switch (action){
            case "/new_district":
                try {
                    showNewForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/insert_district":
                try {
                    insertDistrict(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete_district":
                try {
                    deleteDistrict(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit_district":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/update_district":
                try {
                    updateDistrict(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listDistrict(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("districtform.jsp");
        dispatcher.forward(request, response);
    }

    private void insertDistrict(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException, ClassNotFoundException {
        HttpSession session=request.getSession();
        try {
            String DistrictName = request.getParameter("DistrictName");
            District newDistrict = new District(DistrictName);

            if(DistrictName=="")
            {
                request.getSession().setAttribute("notnullMessage", "DistrictName Null!");
                session.removeAttribute("alertMessage");
                session.removeAttribute("existMessage");
                response.sendRedirect("districtform.jsp");
            }
            else
            {
                //String LoginName=request.getParameter("UserLoginName");
                if((DistrictDAO.existDistrict(DistrictName)) == false)
                {
                    DistrictDAO.insertDistrict(newDistrict);
                    if (newDistrict != null) {
                        //UserDAO.existUser(UserName, UserLoginName);
                        request.getSession().setAttribute("successMessage", "Saved Successfully!");
                        session.removeAttribute("updateMessage");
                        session.removeAttribute("deleteMessage");
                        response.sendRedirect("list_district");
                    }
                    else
                    {
                        request.getSession().setAttribute("alertMessage", "WrongCountry!");
                        session.removeAttribute("notnullMessage");
                        session.removeAttribute("existMessage");
                        response.sendRedirect("districtform.jsp");
                    }
                }
                else
                {
                    request.getSession().setAttribute("existMessage", "AlreadyExist!");
                    session.removeAttribute("notnullMessage");
                    session.removeAttribute("alertMessage");
                    response.sendRedirect("districtform.jsp");
                }
            }
        }catch (SQLException e){ e.printStackTrace();

        }
    }

    private void deleteDistrict(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int District_id=Integer.parseInt(request.getParameter("District_id"));
        if(districtDAO.deleteDistrict(District_id)==true){
            request.getSession().setAttribute("deleteMessage", "Deleted Success!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_district");
        }
        else {
            request.getSession().setAttribute("deleteMessage", "Not Deleted!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_district");
        }
    }

    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int District_id=Integer.parseInt(request.getParameter("District_id"));
        District existingDistrict = districtDAO.selectDistrictById(District_id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("districtform.jsp");
        request.setAttribute("district", existingDistrict);
        dispatcher.forward(request,response);
    }

    private void updateDistrict(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int District_id=Integer.parseInt(request.getParameter("District_id"));
        String DistrictName=request.getParameter("DistrictName");
        District district =new District(District_id,DistrictName);
        districtDAO.updateDistrict(district);
        if(district != null)
        {
            request.getSession().setAttribute("updateMessage", "Update Successfully!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_district");

        }
        else {
            request.getSession().setAttribute("updateMessage", "Not Updated!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_district");
        }
    }

    private void listDistrict(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<District> district =new ArrayList<District>();
        String SearchDistrict=request.getParameter("SearchDistrict");
        district = districtDAO.selectAllDistricts(SearchDistrict);
        request.setAttribute("listDistrict", district);
        RequestDispatcher dispatcher=request.getRequestDispatcher("districtlist.jsp");
        dispatcher.forward(request,response);
    }



}
