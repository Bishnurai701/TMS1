package com.tms.web;

import com.tms.dao.CountryDAO;
import com.tms.dao.DepartmentDAO;
import com.tms.model.Country;
import com.tms.model.Department;

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

@WebServlet(name = "DepartmentServlet",urlPatterns = {("/list_department"),("/new_department"),("/insert_department"),("/delete_department"),("/edit_department"),("/update_department")})
public class DepartmentServlet extends HttpServlet {
 private static final long serialVersionUID=1L;
 private DepartmentDAO departmentDAO;
 public void init(){this.departmentDAO=new DepartmentDAO();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getServletPath();
        switch (action){
            case "/new_department":
                try {
                    showNewForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/insert_department":
                try {
                    insertDepartment(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete_department":
                try {
                    deleteDepartment(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit_department":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/update_department":
                try {
                    updateDepartment(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listDepartment(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("departmentform.jsp");
        dispatcher.forward(request, response);
    }

    private void insertDepartment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException, ClassNotFoundException {
        HttpSession session=request.getSession();
        try {
            String DepartmentName = request.getParameter("DepartmentName");
            Department newDepartment = new Department(DepartmentName);

            if(DepartmentName=="")
            {
                request.getSession().setAttribute("notnullMessage", "CountryName Null!");
                session.removeAttribute("alertMessage");
                session.removeAttribute("existMessage");
                response.sendRedirect("departmentform.jsp");
            }
            else
            {
                //String LoginName=request.getParameter("UserLoginName");
                if((DepartmentDAO.existDepartment(DepartmentName)) == false)
                {
                    DepartmentDAO.insertDepartment(newDepartment);
                    if (newDepartment != null) {
                        //UserDAO.existUser(UserName, UserLoginName);
                        request.getSession().setAttribute("successMessage", "Saved Successfully!");
                        session.removeAttribute("updateMessage");
                        session.removeAttribute("deleteMessage");
                        response.sendRedirect("list_department");
                    }
                    else
                    {
                        request.getSession().setAttribute("alertMessage", "WrongCountry!");
                        session.removeAttribute("notnullMessage");
                        session.removeAttribute("existMessage");
                        response.sendRedirect("departmentform.jsp");
                    }
                }
                else
                {
                    request.getSession().setAttribute("existMessage", "AlreadyExist!");
                    session.removeAttribute("notnullMessage");
                    session.removeAttribute("alertMessage");
                    response.sendRedirect("departmentform.jsp");
                }
            }
        }catch (SQLException e){ e.printStackTrace();

        }
    }

    private void deleteDepartment(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Department_id=Integer.parseInt(request.getParameter("Department_id"));
        if(departmentDAO.deleteDepartment(Department_id)==true){
            request.getSession().setAttribute("deleteMessage", "Deleted Success!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_department");
        }
        else {
            request.getSession().setAttribute("deleteMessage", "Not Deleted!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_department");
        }
    }

    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int Department_id=Integer.parseInt(request.getParameter("Department_id"));
        Department existingDepartment = departmentDAO.selectDepartmentById(Department_id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("departmentform.jsp");
        request.setAttribute("department", existingDepartment);
        dispatcher.forward(request,response);
    }

    private void updateDepartment(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Department_id=Integer.parseInt(request.getParameter("Department_id"));
        String DepartmentName=request.getParameter("DepartmentName");
        Department department =new Department(Department_id,DepartmentName);
        departmentDAO.updateDepartment(department);
        if(department != null)
        {
            request.getSession().setAttribute("updateMessage", "Update Successfully!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_department");

        }
        else {
            request.getSession().setAttribute("updateMessage", "Not Updated!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_department");
        }
    }

    private void listDepartment(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Department> department =new ArrayList<Department>();
        String SearchDepartment=request.getParameter("SearchDepartment");
        department = departmentDAO.selectAllDepartments(SearchDepartment);
        request.setAttribute("listDepartment", department);
        RequestDispatcher dispatcher=request.getRequestDispatcher("departmentlist.jsp");
        dispatcher.forward(request,response);
    }



}
