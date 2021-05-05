package com.tms.web;

import com.tms.dao.MunicipalityDAO;
import com.tms.dao.QualificationDAO;
import com.tms.dao.UniversityDAO;
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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "QualificationServlet",urlPatterns = {("/list_qualification"),("/new_qualification"),("/insert_qualification"),("/delete_qualification"),("/edit_qualification"),("/update_qualification")})
@MultipartConfig(fileSizeThreshold=1024*1024*2,
        maxFileSize = 1024*1024*10,
        maxRequestSize = 1024*1024*50)
public class QualificationServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private QualificationDAO qualificationDAO;
    public void init(){this.qualificationDAO=new QualificationDAO();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getServletPath();
        switch (action){
            case "/new_qualification":
                try {
                    showNewForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/insert_qualification":
                try {
                    insertQualification(request,response);
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "/delete_qualification":
                try {
                    deleteQualification(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit_qualification":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/update_qualification":
                try {
                    updateQualification(request,response);
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
                    listQualification(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        List<Registration> listRegistrationDrop=new ArrayList<Registration>();
        listRegistrationDrop=qualificationDAO.droplistFirstName();
        request.setAttribute("listRegistrationDrop",listRegistrationDrop);

        List<Level> listLevelDrop=new ArrayList<Level>();
        listLevelDrop=qualificationDAO.droplistLevelName();
        request.setAttribute("listLevelDrop",listLevelDrop);

        List<Board> listBoardDrop=new ArrayList<Board>();
        listBoardDrop=qualificationDAO.droplistBoardName();
        request.setAttribute("listBoardDrop",listBoardDrop);

        List<Faculty> listFacultyDrop=new ArrayList<Faculty>();
        listFacultyDrop=qualificationDAO.droplistFacultyName();
        request.setAttribute("listFacultyDrop",listFacultyDrop);

        List<University> listUniversityDrop=new ArrayList<University>();
        listUniversityDrop=qualificationDAO.droplistUniversityName();
        request.setAttribute("listUniversityDrop",listUniversityDrop);


        RequestDispatcher dispatcher = request.getRequestDispatcher("qualificationform.jsp");
        dispatcher.forward(request, response);
    }

    private void insertQualification(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        int maxFileSize=1024*1024*1024;
        int factFileSize=1024*1024*1024;
        try {
            int Level_id = Integer.parseInt(request.getParameter("Level_id"));
            String InstituteName = request.getParameter("InstituteName");
            String PercentOrGPA = request.getParameter("PercentOrGPA");
            java.sql.Date PassedYear = java.sql.Date.valueOf(request.getParameter("PassedYear"));
            Date PassedDate = new SimpleDateFormat("dd-mm-yyyy").parse(request.getParameter("PassedYear"));
            java.sql.Date sqlPassed = new java.sql.Date(PassedYear.getTime());
            String Address = request.getParameter("Address");
            int Board_id = Integer.parseInt(request.getParameter("Board_id"));
            int Faculty_id = Integer.parseInt(request.getParameter("Faculty_id"));
            int University_id = Integer.parseInt(request.getParameter("University_id"));
            int Registration_id = Integer.parseInt(request.getParameter("Registration_id"));



            out=response.getWriter();
            InputStream inputStream=null;
            Part part=request.getPart("file");
            if(part != null){
                System.out.println(part.getName());
                System.out.println(part.getSize());
                System.out.println(part.getContentType());
                inputStream=part.getInputStream();
            }
            String FileName=getSubmittedFileName(part);
            InputStream fileContent=part.getInputStream();
            String FilePath="E:\\Project\\TMS\\web\\File"+ File.separator+FileName;
            File fileSaveDir=new File(FilePath);
            part.write(FilePath+File.separator);
            session=request.getSession(false);

            /*
            if(ServletFileUpload.isMultipartContent(request)){
                List<FileItem> multiparts=new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for(FileItem item:multiparts){
                    if(!item.isFormField()){
                        FilePath=FilePath+ File.separator+FileName;
                        File fileSaveDir=new File(FilePath);
                        part.write(FilePath+File.separator);
                    }
                }
            }
             */
            /*
            String FolderName="File";
            String uploadPath=request.getServletContext().getRealPath("")+File.separator+FolderName;
            File dir=new File(uploadPath);
            if(!dir.exists()){
                dir.mkdirs();
            }
            Part part=request.getPart("file");
            String FileName=getSubmittedFileName(part);
            String FilePath = "G:\\Project\\TMS\\web\\"+FolderName+File.separator+FileName;
            InputStream is=part.getInputStream();
            Files.copy(is, Paths.get(uploadPath+File.separator+FileName), StandardCopyOption.REPLACE_EXISTING);



            DiskFileItemFactory df=new DiskFileItemFactory();
            df.setSizeThreshold(maxFileSize);
            df.setRepository(new File("C:\\temp"));
            ServletFileUpload upload = new ServletFileUpload(df);
            upload.setSizeMax(factFileSize);
            List fileItem=upload.parseRequest(request);
            ListIterator list=fileItem.listIterator();
            while (list.hasNext()){
                FileItem fi=(FileItem)list.next();
                FileName=fi.getName();
                File FilePath= new File("G:\\Project\\TMS\\web\\File",FileName);
                fi.write(FilePath);
            }

            List<FileItem> multifile = sf.parseRequest(request);
            for (FileItem item : multifile) {
                if (!item.isFormField()) {
                    FilePath = new File(item.getName()).getName();
                    item.write(new File("G:/Project/TMS/web/File/" + File.separator + FilePath));
                }
            }
            System.out.println("file uploaded");
            */
            Qualification newQualification = new Qualification(Level_id, InstituteName, PercentOrGPA, PassedYear, Address, Board_id, Faculty_id, University_id, Registration_id, FilePath,FileName);
            if (InstituteName == "" || PercentOrGPA == "" || PassedYear == null || Address == "") {
                request.getSession().setAttribute("notnullMessage", "Qualification Null!");
                session.removeAttribute("alertMessage");
                session.removeAttribute("existMessage");
                response.sendRedirect("qualificationform.jsp");
            } else {
                QualificationDAO.insertQualification(newQualification);
                if (newQualification != null) {
                    //UserDAO.existUser(UserName, UserLoginName);
                    request.getSession().setAttribute("successMessage", "Saved Successfully!");
                    session.removeAttribute("updateMessage");
                    session.removeAttribute("deleteMessage");
                    response.sendRedirect("list_qualification");
                } else {
                    request.getSession().setAttribute("alertMessage", "WrongQualification!");
                    session.removeAttribute("notnullMessage");
                    session.removeAttribute("existMessage");
                    response.sendRedirect("qualificationform.jsp");
                }
            }
        }catch (ClassNotFoundException e){e.printStackTrace();}
    }

    private String getSubmittedFileName(Part part) {
            for (String cd : part.getHeader("content-disposition").split(";")) {
                if (cd.trim().startsWith("file")) {
                    String file = cd.substring(cd.indexOf("=") + 2).trim().replace("\"", "");
                    return file.substring(file.lastIndexOf("\"") + 1).substring(file.lastIndexOf("\\") + 1); // MSIE fix.
                }
            }
            return "";
    }


    private void deleteQualification(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Qualification_id=Integer.parseInt(request.getParameter("Qualification_id"));
        if(qualificationDAO.deleteQualification(Qualification_id)==true){
            request.getSession().setAttribute("deleteMessage", "Deleted Success!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_qualification");
        }
        else {
            request.getSession().setAttribute("deleteMessage", "Not Deleted!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_qualification");
        }
    }
    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int Qualification_id=Integer.parseInt(request.getParameter("Qualification_id"));
        Qualification existQualification = qualificationDAO.selectQualificationById(Qualification_id);

            List<Registration> listRegistrationDrop=new ArrayList<Registration>();
            listRegistrationDrop=qualificationDAO.droplistFirstName();
            request.setAttribute("listRegistrationDrop",listRegistrationDrop);

            List<Level> listLevelDrop=new ArrayList<Level>();
            listLevelDrop=qualificationDAO.droplistLevelName();
            request.setAttribute("listLevelDrop",listLevelDrop);

            List<Board> listBoardDrop=new ArrayList<Board>();
            listBoardDrop=qualificationDAO.droplistBoardName();
            request.setAttribute("listBoardDrop",listBoardDrop);

            List<Faculty> listFacultyDrop=new ArrayList<Faculty>();
            listFacultyDrop=qualificationDAO.droplistFacultyName();
            request.setAttribute("listFacultyDrop",listFacultyDrop);

            List<University> listUniversityDrop=new ArrayList<University>();
            listUniversityDrop=qualificationDAO.droplistUniversityName();
            request.setAttribute("listUniversityDrop",listUniversityDrop);


        RequestDispatcher dispatcher=request.getRequestDispatcher("qualificationform.jsp");
        request.setAttribute("qualification", existQualification);
        dispatcher.forward(request,response);
    }

    private void updateQualification(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException, ParseException {
        HttpSession session=request.getSession();
        int Qualification_id=Integer.parseInt(request.getParameter("Qualification_id"));
        int Level_id=Integer.parseInt(request.getParameter("Level_id"));
        String InstituteName=request.getParameter("InstituteName");
        String PercentOrGPA=request.getParameter("PercentOrGPA");
        java.sql.Date PassedYear = java.sql.Date.valueOf(request.getParameter("PassedYear"));
        Date PassedDate = new SimpleDateFormat("dd-mm-yyyy").parse(request.getParameter("PassedYear"));
        java.sql.Date sqlPassed = new java.sql.Date(PassedYear.getTime());
        String Address = request.getParameter("Address");
        int Board_id=Integer.parseInt(request.getParameter("Board_id"));
        int Faculty_id=Integer.parseInt(request.getParameter("Faculty_id"));
        int University_id=Integer.parseInt(request.getParameter("University_id"));
        int Registration_id=Integer.parseInt(request.getParameter("Registration_id"));
        String FilePath=request.getParameter("FilePath");
        String FileName=request.getParameter("FileName");
        Qualification qualification =new Qualification(Qualification_id,Level_id,InstituteName,PercentOrGPA,PassedYear, Address,Board_id,Faculty_id,University_id,Registration_id,FilePath,FileName);
        qualificationDAO.updateQualification(qualification);
        if(qualification != null)
        {
            request.getSession().setAttribute("updateMessage", "Update Successfully!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_qualification");

        }
        else {
            request.getSession().setAttribute("updateMessage", "Not Updated!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_qualification");
        }
    }

    private void listQualification(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Qualification> qualification =new ArrayList<Qualification>();
        String SearchQualification=request.getParameter("SearchQualification");
        qualification = qualificationDAO.selectAllQualifications(SearchQualification);
        request.setAttribute("listQualification", qualification);
        RequestDispatcher dispatcher=request.getRequestDispatcher("qualificationlist.jsp");
        dispatcher.forward(request,response);
    }



}
