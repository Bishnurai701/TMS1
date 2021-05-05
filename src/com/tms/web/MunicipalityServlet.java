package com.tms.web;

import com.tms.dao.MunicipalityDAO;
import com.tms.model.Municipality;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MunicipalityServlet",urlPatterns = {("/list_municipality"),("/new_municipality"),("/insert_municipality"),("/delete_municipality"),("/edit_municipality"),("/update_municipality")})
public class MunicipalityServlet extends HttpServlet {
   private static final long serialVersionUID=1L;
   private MunicipalityDAO municipalityDAO;
   public void init(){this.municipalityDAO=new MunicipalityDAO();}


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/new_municipality":
                try {
                    showNewForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/insert_municipality":
                try {
                    insertMunicipality(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete_municipality":
                try {
                    deleteMunicipality(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit_municipality":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/update_municipality":
                try {
                    updateMunicipality(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listMunicipality(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("municipalityform.jsp");
        dispatcher.forward(request, response);
    }

    private void insertMunicipality(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException, ClassNotFoundException {
        //HttpSession session=request.getSession();
        try {

            String MunicipalityName = request.getParameter("MunicipalityName");
            Municipality newMunicipality = new Municipality(MunicipalityName);

            if(MunicipalityName=="")
            {
                request.getSession().setAttribute("notnullMessage", "MunicipalityName Null!");
                response.sendRedirect("municipalityform.jsp");
            }
            else
            {
                //String LoginName=request.getParameter("UserLoginName");
                if((MunicipalityDAO.existMunicipality(MunicipalityName)) == false)
                {
                    MunicipalityDAO.insertMunicipality(newMunicipality);
                    if (newMunicipality != null) {
                        //UserDAO.existUser(UserName, UserLoginName);
                        request.getSession().setAttribute("successMessage", "Saved Successfully!");
                        response.sendRedirect("list_municipality");
                    }
                    else
                    {
                        request.getSession().setAttribute("alertMessage", "WrongMunicipality!");
                        response.sendRedirect("municipalityform.jsp");
                    }
                }
                else
                {
                    request.getSession().setAttribute("existMessage", "AlreadyExist!");
                    response.sendRedirect("municipalityform.jsp");
                }
            }
        }catch (SQLException e){ e.printStackTrace();

        }
    }


    private void deleteMunicipality(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        int Municipality_id=Integer.parseInt(request.getParameter("Municipality_id"));
        if(municipalityDAO.deleteMunicipality(Municipality_id)==true){
            request.getSession().setAttribute("deleteMessage", "Deleted Success!");
            response.sendRedirect("list_municipality");
        }
        else {
            request.getSession().setAttribute("deleteMessage", "Not Deleted!");
            response.sendRedirect("list_municipality");
        }
    }

    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int Municipality_id=Integer.parseInt(request.getParameter("Municipality_id"));
        Municipality existingMunicipality= municipalityDAO.selectMunicipalityById(Municipality_id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("municipalityform.jsp");
        request.setAttribute("municipality",existingMunicipality);
        dispatcher.forward(request,response);
    }

    private void updateMunicipality(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        int Municipality_id=Integer.parseInt(request.getParameter("Municipality_id"));
        String MunicipalityName=request.getParameter("MunicipalityName");
        Municipality municipality=new Municipality(Municipality_id,MunicipalityName);
        municipalityDAO.updateMunicipality(municipality);
        if(municipality != null)
        {
            request.getSession().setAttribute("updateMessage", "Update Successfully!");
            response.sendRedirect("list_municipality");

        }
        else {
            request.getSession().setAttribute("updateMessage", "Not Updated!");
            response.sendRedirect("list_municipality");
        }
    }

    private void listMunicipality(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Municipality> lists_municipality=new ArrayList<Municipality>();

        String SearchMunicipality=request.getParameter("SearchMunicipality");
        lists_municipality=municipalityDAO.selectAllMunicipalitys(SearchMunicipality);
        request.setAttribute("listMunicipality",lists_municipality);
        RequestDispatcher dispatcher=request.getRequestDispatcher("municipalitylist.jsp");
        dispatcher.forward(request,response);
    }



}
