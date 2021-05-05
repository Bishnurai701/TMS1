package com.tms.web;

import com.tms.dao.FacultyDAO;
import com.tms.model.Faculty;
import com.tms.model.University;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FacultyServlet",urlPatterns = {("/list_faculty"),("/new_faculty"),("/insert_faculty"),("/delete_faculty"),("/edit_faculty"),("/update_faculty")})
public class FacultyServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private FacultyDAO facultyDAO;
    public void init(){this.facultyDAO=new FacultyDAO();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getServletPath();
        switch (action){
            case "/new_faculty":
                showNewFrom(request,response);
                break;
            case "/insert_faculty":
                try {
                    insertFaculty(request,response);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete_faculty":
                try {
                    deleteFaculty(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit_faculty":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/update_faculty":
                try {
                    updateFaculty(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listFaculty(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
private void showNewFrom(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher=request.getRequestDispatcher("facultyform.jsp");
    dispatcher.forward(request,response);
}
private void insertFaculty(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException,ClassNotFoundException{
    HttpSession session=request.getSession();
    try
    {
        String FacultyName=request.getParameter("FacultyName");
        Faculty newFaculty=new Faculty(FacultyName);
        if(FacultyName==""){
            request.getSession().setAttribute("notnullMessage", "FacultyName Null!");
            session.removeAttribute("alertMessage");
            session.removeAttribute("existMessage");
            response.sendRedirect("facultyform.jsp");
        }
        else
        {
            if(FacultyDAO.existFaculty(FacultyName)==false){
                FacultyDAO.insertFaculty(newFaculty);
                if(newFaculty != null){
                    request.getSession().setAttribute("successMessage", "Saved Successfully!");
                    session.removeAttribute("updateMessage");
                    session.removeAttribute("deleteMessage");
                    response.sendRedirect("list_faculty");
                }
                else
                {
                    request.getSession().setAttribute("alertMessage", "WrongFaculty!");
                    session.removeAttribute("notnullMessage");
                    session.removeAttribute("existMessage");
                    response.sendRedirect("facultyform.jsp");
                }
            }
            else
            {
                request.getSession().setAttribute("existMessage", "AlreadyExist!");
                session.removeAttribute("notnullMessage");
                session.removeAttribute("alertMessage");
                response.sendRedirect("facultyform.jsp");
            }
        }
    }catch (SQLException e){e.printStackTrace();}
}

    private void deleteFaculty(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Faculty_id=Integer.parseInt(request.getParameter("Faculty_id"));
        if(facultyDAO.deleteFaculty(Faculty_id)==true){
            request.getSession().setAttribute("deleteMessage", "Deleted Success!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_faculty");
        }
        else {
            request.getSession().setAttribute("deleteMessage", "Not Deleted!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_faculty");
        }
    }

    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int Faculty_id=Integer.parseInt(request.getParameter("Faculty_id"));
        Faculty existFaculty = facultyDAO.selectFacultyById(Faculty_id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("facultyform.jsp");
        request.setAttribute("faculty", existFaculty);
        dispatcher.forward(request,response);
    }


    private void updateFaculty(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Faculty_id=Integer.parseInt(request.getParameter("Faculty_id"));
        String FacultyName=request.getParameter("FacultyName");
        Faculty faculty =new Faculty(Faculty_id,FacultyName);
        facultyDAO.updateFaculty(faculty);
        if(faculty != null)
        {
            request.getSession().setAttribute("updateMessage", "Update Successfully!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_faculty");

        }
        else {
            request.getSession().setAttribute("updateMessage", "Not Updated!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_faculty");
        }
    }

    private void listFaculty(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Faculty> faculty =new ArrayList<Faculty>();
        String SearchFaculty=request.getParameter("SearchFaculty");
        faculty = facultyDAO.selectAllFacultys(SearchFaculty);
        request.setAttribute("listFaculty", faculty);
        RequestDispatcher dispatcher=request.getRequestDispatcher("facultylist.jsp");
        dispatcher.forward(request,response);
    }






}
