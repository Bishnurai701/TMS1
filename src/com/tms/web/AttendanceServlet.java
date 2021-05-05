package com.tms.web;

import com.mysql.cj.xdevapi.TableImpl;
import com.tms.dao.AttendanceDAO;
import com.tms.dao.QualificationDAO;
import com.tms.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@WebServlet(name = "AttendanceServlet",urlPatterns = {("/list_attendance"),("/new_attendance"),("/insert_attendance"),("/delete_attendance"),("/edit_attendance"),("/update_attendance")})
public class AttendanceServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private AttendanceDAO attendanceDAO;
    public void init(){this.attendanceDAO=new AttendanceDAO();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getServletPath();
        switch (action){
            case "/new_attendance":
                try {
                    showNewForm(request,response);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "/insert_attendance":
                try {
                    insertAttendance(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "/delete_attendance":
                break;
            case "/edit_attendance":
                break;
            case "/update_attendance":
                break;
            default:
                try {
                    listAttendance(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {

        List<Registration> listNameDrop=new ArrayList<Registration>();
        listNameDrop=attendanceDAO.droplistName();
        request.setAttribute("listNameDrop", listNameDrop);

        RequestDispatcher dispatcher = request.getRequestDispatcher("attendanceform.jsp");
        dispatcher.forward(request, response);
    }
    private void insertAttendance(HttpServletRequest request, HttpServletResponse response) throws Exception, ClassNotFoundException {
        HttpSession session = request.getSession();
       try {
           int Registration_id = Integer.parseInt(request.getParameter("Registration_id"));

           java.sql.Date AttendDate = java.sql.Date.valueOf(request.getParameter("AttendDate"));
           Date AttendanceDate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("AttendDate"));
           java.sql.Date sqlAttend = new java.sql.Date(AttendDate.getTime());

           
           Time Check_IN =Time.valueOf(request.getParameter("Check_IN"));
           Time CheckIN= (Time) new SimpleDateFormat("HH:mm").parse(request.getParameter("Check_IN"));
           java.sql.Time sqlCheckIN = new Time(CheckIN.getTime());

           java.util.Date CheckTime = new SimpleDateFormat("hh:mm:ss").parse(request.getParameter("Check_OUT"));
           java.util.Date dateCheck = new Date();
           java.sql.Time Check_OUT = new Time(CheckTime.getTime());

           //Time sqlTime=new java.sql.Time(Check_IN.getTime());
           //Time CheckIN=new Time(timeformat.parse(request.getParameter("Check_IN")).getTime());

           //Time Check_OUT=new Time(timeformat.parse(request.getParameter("Check_OUT")).getTime());

           //java.sql.Timestamp Check_IN= java.sql.Timestamp.valueOf(request.getParameter("Check_IN"));
           //Date CheckINDate =new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse(request.getParameter(String.valueOf(Check_IN)));
           //java.sql.Timestamp CheckIN=new java.sql.Timestamp(Check_IN.getTime());
           //java.sql.Date CheckIN=java.sql.Date.valueOf(request.getParameter("Check_IN"));




           //java.sql.Timestamp Check_OUT = (Timestamp) new SimpleDateFormat("hh:mm").parse(request.getParameter("Check_OUT"));
           //java.sql.Timestamp CheckOUT=new java.sql.Timestamp(Check_OUT.getTime());

           //java.sql.Timestamp Check_IN =Timestamp.valueOf(request.getParameter("Check_IN"));
           //Date timeformate=new SimpleDateFormat("hh:mm").parse(request.getParameter("Check_IN"));


           //SimpleDateFormat CheckIN=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
           //String Check=CheckIN.format(new Date());
           //Timestamp Check_IN=Timestamp.valueOf(Check);

           //java.sql.Timestamp Check_IN =Timestamp.valueOf(request.getParameter("Check_IN"));
           //Timestamp CheckIN = (Timestamp) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(request.getParameter("Check_IN"));
           //java.sql.Timestamp sqlTime=new java.sql.Timestamp(Check_IN.getTime());

           //Date CheckIn=new SimpleDateFormat(Dateformat).parse(request.getParameter("Check_IN"));
           //java.sql.Timestamp sqlTime=new java.sql.Timestamp(Check_IN.getTime());

           //java.sql.Timestamp Check_IN =Timestamp.valueOf(request.getParameter("Check_IN"));
           //Check_IN= new Timestamp(new Date().getTime());
           //Timestamp CheckIN = (Timestamp) new SimpleDateFormat("HH:mm:ss").parse(request.getParameter("Check_IN"));


           //java.sql.Timestamp Check_OUT = java.sql.Timestamp.valueOf(request.getParameter("Check_OUT"));
           //Timestamp CheckOUT = (Timestamp) new SimpleDateFormat("HH:mm:ss.fff").parse(request.getParameter("Check_OUT"));
           //java.sql.Timestamp sqlOUT = new java.sql.Timestamp(Check_OUT.getTime());


           String Comment = request.getParameter("Comment");

           Attendance newAttendance = new Attendance(Registration_id, AttendDate,Check_IN,Check_OUT, Comment);
           if (AttendDate == null || Check_IN == null || Check_OUT == null) {
               request.getSession().setAttribute("notnullMessage", "Attendance Null!");
               session.removeAttribute("alertMessage");
               session.removeAttribute("existMessage");
               response.sendRedirect("attendanceform.jsp");
           } else {
               attendanceDAO.insertAttendance(newAttendance);
               if (newAttendance != null) {
                   //UserDAO.existUser(UserName, UserLoginName);
                   request.getSession().setAttribute("successMessage", "Saved Successfully!");
                   session.removeAttribute("updateMessage");
                   session.removeAttribute("deleteMessage");
                   response.sendRedirect("list_attendance");
               } else {
                   request.getSession().setAttribute("alertMessage", "WrongAttendance!");
                   session.removeAttribute("notnullMessage");
                   session.removeAttribute("existMessage");
                   response.sendRedirect("attendanceform.jsp");
               }
           }
       }catch (Exception e){e.printStackTrace();}
    }
    private void listAttendance(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Attendance> attendance =new ArrayList<Attendance>();
        String SearchAttendance=request.getParameter("SearchAttendance");
        attendance = AttendanceDAO.selectAllAttendance(SearchAttendance);
        request.setAttribute("listAttendance", attendance);
        RequestDispatcher dispatcher=request.getRequestDispatcher("attendancelist.jsp");
        dispatcher.forward(request,response);
    }

}
