package com.tms.web;

import com.tms.dao.DepartmentDAO;
import com.tms.dao.SectionDAO;
import com.tms.model.Department;
import com.tms.model.Section;

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

@WebServlet(name = "SectionServlet",urlPatterns = {("/list_section"),("/new_section"),("/insert_section"),("/delete_section"),("/edit_section"),("/update_section")})
public class SectionServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private SectionDAO sectionDAO;
    public void  init(){this.sectionDAO=new SectionDAO();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getServletPath();
        switch (action){
            case "/new_section":
                try {
                    showNewForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/insert_section":
                try {
                    insertSection(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete_section":
                try {
                    deleteSection(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit_section":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/update_section":
                try {
                    updateSection(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listSection(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("sectionform.jsp");
        dispatcher.forward(request, response);
    }

    private void insertSection(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException, ClassNotFoundException {
        HttpSession session=request.getSession();
        try {
            String SectionName = request.getParameter("SectionName");
            Section newSection = new Section(SectionName);

            if(SectionName=="")
            {
                request.getSession().setAttribute("notnullMessage", "CountryName Null!");
                session.removeAttribute("alertMessage");
                session.removeAttribute("existMessage");
                response.sendRedirect("sectionform.jsp");
            }
            else
            {
                //String LoginName=request.getParameter("UserLoginName");
                if((SectionDAO.existSection(SectionName)) == false)
                {
                    SectionDAO.insertSection(newSection);
                    if (newSection != null) {
                        //UserDAO.existUser(UserName, UserLoginName);
                        request.getSession().setAttribute("successMessage", "Saved Successfully!");
                        session.removeAttribute("updateMessage");
                        session.removeAttribute("deleteMessage");
                        response.sendRedirect("list_section");
                    }
                    else
                    {
                        request.getSession().setAttribute("alertMessage", "WrongCountry!");
                        session.removeAttribute("notnullMessage");
                        session.removeAttribute("existMessage");
                        response.sendRedirect("sectionform.jsp");
                    }
                }
                else
                {
                    request.getSession().setAttribute("existMessage", "AlreadyExist!");
                    session.removeAttribute("notnullMessage");
                    session.removeAttribute("alertMessage");
                    response.sendRedirect("sectionform.jsp");
                }
            }
        }catch (SQLException e){ e.printStackTrace();

        }
    }

    private void deleteSection(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Section_id=Integer.parseInt(request.getParameter("Section_id"));
        if(sectionDAO.deleteSection(Section_id)==true){
            request.getSession().setAttribute("deleteMessage", "Deleted Success!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_section");
        }
        else {
            request.getSession().setAttribute("deleteMessage", "Not Deleted!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_section");
        }
    }

    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int Section_id=Integer.parseInt(request.getParameter("Section_id"));
        Section existSection = sectionDAO.selectSectionById(Section_id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("sectionform.jsp");
        request.setAttribute("section", existSection);
        dispatcher.forward(request,response);
    }

    private void updateSection(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Section_id=Integer.parseInt(request.getParameter("Section_id"));
        String SectionName=request.getParameter("SectionName");
        Section section =new Section(Section_id,SectionName);
        sectionDAO.updateSection(section);
        if(section != null)
        {
            request.getSession().setAttribute("updateMessage", "Update Successfully!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_section");

        }
        else {
            request.getSession().setAttribute("updateMessage", "Not Updated!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_section");
        }
    }

    private void listSection(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Section> section =new ArrayList<Section>();
        String SearchSection=request.getParameter("SearchSection");
        section = sectionDAO.selectAllSections(SearchSection);
        request.setAttribute("listSection", section);
        RequestDispatcher dispatcher=request.getRequestDispatcher("sectionlist.jsp");
        dispatcher.forward(request,response);
    }





}
