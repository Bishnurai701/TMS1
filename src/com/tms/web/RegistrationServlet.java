package com.tms.web;

import com.tms.dao.RegistrationDAO;
import com.tms.model.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebServlet(name = "RegistrationServlet",urlPatterns = {("/list_registration"),("/new_registration"),("/insert_registration"),("/delete_registration"),("/edit_registration"),("/update_registration")})
@MultipartConfig(fileSizeThreshold=1024*1024*2,
        maxFileSize = 1024*1024*10,
        maxRequestSize = 1024*1024*50)
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private RegistrationDAO registrationDAO;
    public void init(){this.registrationDAO=new RegistrationDAO();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action=request.getServletPath();
    switch (action){
        case "/new_registration":
            try {
                showNewFrom(request,response);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            break;
        case "/insert_registration":
            try {
                insertRegistration(request,response);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;
        case "/delete_registration":
            try {
                deleteRegistration(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            break;
        case "/edit_registration":
            try {
                showEditForm(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            break;
        case "/update_registration":
            try {
                updateRegistration(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            break;
        default:
            try {
                listRegistration(request,response);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            break;
    }
    }
    private void showNewFrom(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        List<Post> listPostDrop=new ArrayList<Post>();
        listPostDrop=registrationDAO.droplistPostName();
        request.setAttribute("listPostDrop",listPostDrop);

        List<Section> listSectionDrop=new ArrayList<Section>();
        listSectionDrop=registrationDAO.droplistSectionName();
        request.setAttribute("listSectionDrop",listSectionDrop);

        List<Department> listDepartmentDrop=new ArrayList<Department>();
        listDepartmentDrop=registrationDAO.droplistDepartmentName();
        request.setAttribute("listDepartmentDrop",listDepartmentDrop);

        List<Board> listBoardDrop=new ArrayList<Board>();
        listBoardDrop=registrationDAO.droplistBoardName();
        request.setAttribute("listBoardDrop",listBoardDrop);

        List<Faculty> listFacultyDrop=new ArrayList<Faculty>();
        listFacultyDrop=registrationDAO.droplistFacultyName();
        request.setAttribute("listFacultyDrop",listFacultyDrop);

        List<University> listUniversityDrop=new ArrayList<University>();
        listUniversityDrop=registrationDAO.droplistUniversityName();
        request.setAttribute("listUniversityDrop",listUniversityDrop);


        RequestDispatcher dispatcher=request.getRequestDispatcher("registrationform.jsp");
        dispatcher.forward(request,response);
    }
    private void insertRegistration(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, ParseException, SQLException {
        HttpSession session=request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

            try {
                java.sql.Date RegistrationDate= java.sql.Date.valueOf(request.getParameter("RegistrationDate"));
                Date RegisterDate =new SimpleDateFormat("dd-mm-yyyy").parse(request.getParameter("RegistrationDate"));
                java.sql.Date sqlDate = new java.sql.Date(RegistrationDate.getTime());
                String FirstName = request.getParameter("FirstName");
                String MiddleName = request.getParameter("MiddleName");
                String LastName = request.getParameter("LastName");
                String MothersName = request.getParameter("MothersName");
                String FathersName = request.getParameter("FathersName");
                java.sql.Date DOB= java.sql.Date.valueOf(request.getParameter("DOB"));
                Date DOBDate =new SimpleDateFormat("dd-mm-yyyy").parse(request.getParameter("DOB"));
                java.sql.Date sqlDOB = new java.sql.Date(DOB.getTime());
                String Gender = request.getParameter("Gender");
                if(Gender.equals("Male")==true)
                {
                    Gender="Male";
                }
                else
                {
                    Gender="Female";
                }
                String Email = request.getParameter("Email");
                String MobileNo = request.getParameter("MobileNo");
                String LandLine = request.getParameter("LandLine");
                int PersonalIDNumber = Integer.parseInt(request.getParameter("PersonalIDNumber"));
                int Post_id = Integer.parseInt(request.getParameter("Post_id"));
                int Section_id = Integer.parseInt(request.getParameter("Section_id"));
                int Department_id = Integer.parseInt(request.getParameter("Department_id"));

                //String PhotoName =request.getParameter("PhotoName");
                //String PhotoPath = request.getParameter("PhotoPath");
                InputStream inputStream=null;
                Part part=request.getPart("file");
                if(part != null){
                    System.out.println(part.getName());
                    System.out.println(part.getSize());
                    System.out.println(part.getContentType());
                    inputStream=part.getInputStream();
                }
                String PhotoName=getSubmittedFileName(part);
                InputStream fileContent=part.getInputStream();
                String PhotoPath="E:\\Project\\TMS\\web\\image"+ File.separator+PhotoName;
                File fileSaveDir=new File(PhotoPath);
                part.write(PhotoPath+File.separator);

                Registration newRegistration=new Registration (RegistrationDate,FirstName,MiddleName,LastName,MothersName,FathersName,DOB,Gender,Email,MobileNo,LandLine,PersonalIDNumber,Post_id,Section_id,Department_id,PhotoName,PhotoPath);
                if(RegistrationDate==null || FirstName=="" || LastName=="" || MothersName=="" || FathersName=="" || DOB==null || Email=="" || MobileNo=="" || PersonalIDNumber==0)
                {
                    request.getSession().setAttribute("notnullMessage", "RegistrationDate Null!");
                    session.removeAttribute("alertMessage");
                    session.removeAttribute("existMessage");
                    response.sendRedirect("registrationform.jsp");
                }
                else
                {
                    if(RegistrationDAO.existRegistration(PersonalIDNumber,Email,MobileNo,LandLine)==false)
                    {
                    RegistrationDAO.insertRegistration(newRegistration);
                    if(newRegistration != null){
                        request.getSession().setAttribute("successMessage", "Saved Successfully!");
                        session.removeAttribute("updateMessage");
                        session.removeAttribute("deleteMessage");
                        response.sendRedirect("list_registration");
                    }
                    else
                    {
                        request.getSession().setAttribute("alertMessage", "WrongBoard!");
                        session.removeAttribute("notnullMessage");
                        session.removeAttribute("existMessage");
                        response.sendRedirect("registrationform.jsp");
                    }
                    }
                    else
                    {
                        request.getSession().setAttribute("existMessage", "AlreadyExist!");
                        session.removeAttribute("notnullMessage");
                        session.removeAttribute("alertMessage");
                        response.sendRedirect("registrationform.jsp");
                    }
                }
            }catch (SQLException e){e.printStackTrace();}
    }

    private static String getSubmittedFileName(Part part) throws SQLException {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("file")) {
                String file = cd.substring(cd.indexOf("=") + 2).trim().replace("\"", "");
                return file.substring(file.lastIndexOf("\"") + 1).substring(file.lastIndexOf("\\") + 1); // MSIE fix.
            }
        }
       return "";
    }

/*
    private String getSubmittedFileName(Part part)throws IOException {
        String ContendDisp=part.getHeader("contend-disposition");
        String [] items=ContendDisp.split(";");
        for (String s : items){
            if(s.trim().startsWith("file"))
            {
                return s.substring(s.indexOf("=")+2,s.length()-1);
            }
        }
        return "";
    }
*/

    private void deleteRegistration(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Registration_id=Integer.parseInt(request.getParameter("Registration_id"));
        if(registrationDAO.deleteRegistration(Registration_id)==true){
            request.getSession().setAttribute("deleteMessage", "Deleted Success!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_registration");
        }
        else {
            request.getSession().setAttribute("deleteMessage", "Not Deleted!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_registration");
        }
    }

    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int Registration_id=Integer.parseInt(request.getParameter("Registration_id"));
        Registration existingRegistration = registrationDAO.selectRegistrationById(Registration_id);

        List<Post> listPostDrop=new ArrayList<Post>();
        listPostDrop=registrationDAO.droplistPostName();
        request.setAttribute("listPostDrop",listPostDrop);

        List<Section> listSectionDrop=new ArrayList<Section>();
        listSectionDrop=registrationDAO.droplistSectionName();
        request.setAttribute("listSectionDrop",listSectionDrop);

        List<Department> listDepartmentDrop=new ArrayList<Department>();
        listDepartmentDrop=registrationDAO.droplistDepartmentName();
        request.setAttribute("listDepartmentDrop",listDepartmentDrop);

        List<Board> listBoardDrop=new ArrayList<Board>();
        listBoardDrop=registrationDAO.droplistBoardName();
        request.setAttribute("listBoardDrop",listBoardDrop);

        List<Faculty> listFacultyDrop=new ArrayList<Faculty>();
        listFacultyDrop=registrationDAO.droplistFacultyName();
        request.setAttribute("listFacultyDrop",listFacultyDrop);

        List<University> listUniversityDrop=new ArrayList<University>();
        listUniversityDrop=registrationDAO.droplistUniversityName();
        request.setAttribute("listUniversityDrop",listUniversityDrop);


        RequestDispatcher dispatcher=request.getRequestDispatcher("registrationform.jsp");
        request.setAttribute("registration", existingRegistration);
        dispatcher.forward(request,response);
    }

    private void updateRegistration(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException, ParseException {
        HttpSession session=request.getSession();
        int Registration_id=Integer.parseInt(request.getParameter("Registration_id"));
        java.sql.Date RegistrationDate= java.sql.Date.valueOf(request.getParameter("RegistrationDate"));
        Date RegisterDate =new SimpleDateFormat("dd-mm-yyyy").parse(request.getParameter("RegistrationDate"));
        java.sql.Date sqlDate = new java.sql.Date(RegistrationDate.getTime());
        String FirstName=request.getParameter("FirstName");
        String MiddleName=request.getParameter("MiddleName");
        String LastName=request.getParameter("LastName");
        String MothersName=request.getParameter("MothersName");
        String FathersName=request.getParameter("FathersName");
        java.sql.Date DOB= java.sql.Date.valueOf(request.getParameter("DOB"));
        Date DOBDate =new SimpleDateFormat("dd-mm-yyyy").parse(request.getParameter("RegistrationDate"));
        java.sql.Date sqlDOBDate = new java.sql.Date(DOB.getTime());
        String Gender=request.getParameter("Gender");
        if(Gender.equals("Male")==true)
        {
            Gender="Male";
        }
        else
        {
            Gender="Female";
        }
        String Email=request.getParameter("Email");
        String MobileNo=request.getParameter("MobileNo");
        String LandLine=request.getParameter("landLine");
        int PersonalIDNumber=Integer.parseInt(request.getParameter("PersonalIDNumber"));
        int Post_id=Integer.parseInt(request.getParameter("Post_id"));
        int Section_id=Integer.parseInt(request.getParameter("Section_id"));
        int Department_id=Integer.parseInt(request.getParameter("Department_id"));
        Registration registration =new Registration(Registration_id,RegistrationDate,FirstName,MiddleName,LastName,MothersName,FathersName,DOB,Gender,Email,MobileNo,LandLine,PersonalIDNumber,Post_id,Section_id,Department_id);
        registrationDAO.updateRegistration(registration);
        if(registration != null)
        {
            request.getSession().setAttribute("updateMessage", "Update Successfully!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_registration");

        }
        else {
            request.getSession().setAttribute("updateMessage", "Not Updated!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_registration");
        }
    }


    private void listRegistration(HttpServletRequest request,HttpServletResponse response) throws IOException, ClassNotFoundException, ServletException {
        List<Registration> registration=new ArrayList<Registration>();
        String SearchPerson=request.getParameter("SearchPerson");
        registration=registrationDAO.selectAllRegistrations(SearchPerson);
        request.setAttribute("listRegistration",registration);
        RequestDispatcher dispatcher=request.getRequestDispatcher("registrationlist.jsp");
        dispatcher.forward(request,response);
    }





}
