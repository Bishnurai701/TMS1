package com.tms.web;


import com.tms.dao.UniversityDAO;
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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UniversityServlet",urlPatterns = {("/list_university"),("/new_university"),("/insert_university"),("/delete_university"),("/edit_university"),("/update_university")})
public class UniversityServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private UniversityDAO universityDAO;
    public void init(){this.universityDAO=new UniversityDAO();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getServletPath();
        switch (action){
            case "/new_university":
                try {
                    showNewForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/insert_university":
                try {
                    insertUniversity(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete_university":
                try {
                    deleteUniversity(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit_university":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/update_university":
                try {
                    updateUniversity(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listUniversity(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("universityform.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUniversity(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException, ClassNotFoundException {
        HttpSession session=request.getSession();
        try {
            String UniversityName = request.getParameter("UniversityName");
            University newUniversity = new University(UniversityName);

            if(UniversityName=="")
            {
                request.getSession().setAttribute("notnullMessage", "UniversityName Null!");
                session.removeAttribute("alertMessage");
                session.removeAttribute("existMessage");
                response.sendRedirect("universityform.jsp");
            }
            else
            {
                //String LoginName=request.getParameter("UserLoginName");
                if((UniversityDAO.existUniversity(UniversityName)) == false)
                {
                    UniversityDAO.insertUniversity(newUniversity);
                    if (newUniversity != null) {
                        //UserDAO.existUser(UserName, UserLoginName);
                        request.getSession().setAttribute("successMessage", "Saved Successfully!");
                        session.removeAttribute("updateMessage");
                        session.removeAttribute("deleteMessage");
                        response.sendRedirect("list_university");
                    }
                    else
                    {
                        request.getSession().setAttribute("alertMessage", "WrongUniversity!");
                        session.removeAttribute("notnullMessage");
                        session.removeAttribute("existMessage");
                        response.sendRedirect("universityform.jsp");
                    }
                }
                else
                {
                    request.getSession().setAttribute("existMessage", "AlreadyExist!");
                    session.removeAttribute("notnullMessage");
                    session.removeAttribute("alertMessage");
                    response.sendRedirect("universityform.jsp");
                }
            }
        }catch (SQLException e){ e.printStackTrace();

        }
    }

    private void deleteUniversity(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int University_id=Integer.parseInt(request.getParameter("University_id"));
        if(universityDAO.deleteUniversity(University_id)==true){
            request.getSession().setAttribute("deleteMessage", "Deleted Success!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_university");
        }
        else {
            request.getSession().setAttribute("deleteMessage", "Not Deleted!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_university");
        }
    }

    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int University_id=Integer.parseInt(request.getParameter("University_id"));
        University existUniversity = universityDAO.selectUniversityById(University_id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("universityform.jsp");
        request.setAttribute("university", existUniversity);
        dispatcher.forward(request,response);
    }

    private void updateUniversity(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int University_id=Integer.parseInt(request.getParameter("University_id"));
        String UniversityName=request.getParameter("UniversityName");
        University university =new University(University_id,UniversityName);
        universityDAO.updateUniversity(university);
        if(university != null)
        {
            request.getSession().setAttribute("updateMessage", "Update Successfully!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_university");

        }
        else {
            request.getSession().setAttribute("updateMessage", "Not Updated!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_university");
        }
    }

    private void listUniversity(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<University> university =new ArrayList<University>();
        String SearchUniversity=request.getParameter("SearchUniversity");
        university = universityDAO.selectAllUniversitys(SearchUniversity);
        request.setAttribute("listUniversity", university);
        RequestDispatcher dispatcher=request.getRequestDispatcher("universitylist.jsp");
        dispatcher.forward(request,response);
    }




}
