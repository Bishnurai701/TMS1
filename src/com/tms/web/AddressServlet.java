package com.tms.web;

import com.tms.dao.AddressDAO;
import com.tms.model.*;

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

@WebServlet(name = "AddressServlet",urlPatterns = {("/list_address"),("/new_address"),("/insert_address"),("/delete_address"),("/edit_address"),("/update_address")})
public class AddressServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private AddressDAO addressDAO;
    public void init(){this.addressDAO=new AddressDAO();}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getServletPath();
        switch (action){
            case "/new_address":
                try {
                    showNewForm(request,response);
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/insert_address":
                try {
                    insertAddress(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete_address":
                try {
                    deleteAddress(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit_address":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/update_address":
                try {
                    updateAddress(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listAddress(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        List<AddressType> listAddressTypeDrop=new ArrayList<AddressType>();
        listAddressTypeDrop=addressDAO.droplistAddressTypeName();
        request.setAttribute("listAddressTypeDrop",listAddressTypeDrop);

        List<Registration> listRegistrationDrop=new ArrayList<Registration>();
        listRegistrationDrop=addressDAO.droplistRegistrationName();
        request.setAttribute("listRegistrationDrop",listRegistrationDrop);

        List<Address> listCountryDrop=new ArrayList<Address>();
        listCountryDrop=addressDAO.droplistCountryName();
        request.setAttribute("listCountryDrop",listCountryDrop);

        List<State> listStateDrop=new ArrayList<State>();
        listStateDrop=addressDAO.droplistStateName();
        request.setAttribute("listStateDrop",listStateDrop);

        List<District> listDistrictDrop=new ArrayList<District>();
        listDistrictDrop=addressDAO.droplistDistrictName();
        request.setAttribute("listDistrictDrop",listDistrictDrop);

        List<Municipality> listMunicipalityDrop=new ArrayList<Municipality>();
        listMunicipalityDrop=addressDAO.droplistMunicipalityName();
        request.setAttribute("listMunicipalityDrop",listMunicipalityDrop);

        RequestDispatcher dispatcher = request.getRequestDispatcher("addressform.jsp");
        dispatcher.forward(request, response);
    }
    private void insertAddress(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException, ClassNotFoundException {
        HttpSession session=request.getSession();
        try {

            int AddressType_id=Integer.parseInt(request.getParameter("AddressType_id"));
            int Registration_id = Integer.parseInt(request.getParameter("Registration_id"));
            String Address_MunicipalityName = request.getParameter("Address_MunicipalityName");
            int Municipality_id = Integer.parseInt(request.getParameter("Municipality_id"));
            String StreetName = request.getParameter("StreetName");
            int WardNo = Integer.parseInt(request.getParameter("WardNo"));
            int Country_id=Integer.parseInt(request.getParameter("Country_id"));
            int State_id = Integer.parseInt(request.getParameter("State_id"));
            int District_id = Integer.parseInt(request.getParameter("District_id"));
            String CityName=request.getParameter("CityName");

            Address newAddress = new Address(AddressType_id,Registration_id,Address_MunicipalityName,Municipality_id,StreetName,WardNo,Country_id,State_id,District_id,CityName);

            if (Address_MunicipalityName == "" || StreetName == "" || WardNo == 0) {
                request.getSession().setAttribute("notnullMessage", "Address Null!");
                session.removeAttribute("alertMessage");
                session.removeAttribute("existMessage");
                response.sendRedirect("addressform.jsp");
            } else {
                AddressDAO.insertAddress(newAddress);
                if (newAddress != null) {
                    //UserDAO.existUser(UserName, UserLoginName);
                    request.getSession().setAttribute("successMessage", "Saved Successfully!");
                    session.removeAttribute("updateMessage");
                    session.removeAttribute("deleteMessage");
                    response.sendRedirect("list_address");
                } else {
                    request.getSession().setAttribute("alertMessage", "WrongAddress!");
                    session.removeAttribute("notnullMessage");
                    session.removeAttribute("existMessage");
                    response.sendRedirect("addressform.jsp");
                }
            }
        }catch (IOException e){e.getMessage();}
    }

    private void deleteAddress(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Address_id=Integer.parseInt(request.getParameter("Address_id"));
        if(addressDAO.deleteAddress(Address_id)==true){
            request.getSession().setAttribute("deleteMessage", "Deleted Success!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_address");
        }
        else {
            request.getSession().setAttribute("deleteMessage", "Not Deleted!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_address");
        }
    }

    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int Address_id=Integer.parseInt(request.getParameter("Address_id"));
        Address existAddress = addressDAO.selectAddressById(Address_id);

        List<AddressType> listAddressTypeDrop=new ArrayList<AddressType>();
        listAddressTypeDrop=addressDAO.droplistAddressTypeName();
        request.setAttribute("listAddressTypeDrop",listAddressTypeDrop);

        List<Registration> listRegistrationDrop=new ArrayList<Registration>();
        listRegistrationDrop=addressDAO.droplistRegistrationName();
        request.setAttribute("listRegistrationDrop",listRegistrationDrop);

        List<Address> listCountryDrop=new ArrayList<Address>();
        listCountryDrop=addressDAO.droplistCountryName();
        request.setAttribute("listCountryDrop",listCountryDrop);

        List<State> listStateDrop=new ArrayList<State>();
        listStateDrop=addressDAO.droplistStateName();
        request.setAttribute("listStateDrop",listStateDrop);

        List<District> listDistrictDrop=new ArrayList<District>();
        listDistrictDrop=addressDAO.droplistDistrictName();
        request.setAttribute("listDistrictDrop",listDistrictDrop);

        List<Municipality> listMunicipalityDrop=new ArrayList<Municipality>();
        listMunicipalityDrop=addressDAO.droplistMunicipalityName();
        request.setAttribute("listMunicipalityDrop",listMunicipalityDrop);


        RequestDispatcher dispatcher=request.getRequestDispatcher("addressform.jsp");
        request.setAttribute("address", existAddress);
        dispatcher.forward(request,response);
    }

    private void updateAddress(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Address_id=Integer.parseInt(request.getParameter("Address_id"));
        int AddressType_id=Integer.parseInt(request.getParameter("AddressType_id"));
        int Registration_id=Integer.parseInt(request.getParameter("Registration_id"));
        String Address_MunicipalityName=request.getParameter("Address_MunicipalityName");
        int Municipality_id=Integer.parseInt(request.getParameter("Municipality_id"));
        String StreetName=request.getParameter("StreetName");
        int WardNo=Integer.parseInt(request.getParameter("WardNo"));
        int Country_id=Integer.parseInt(request.getParameter("Country_id"));
        int State_id=Integer.parseInt(request.getParameter("State_id"));
        int District_id=Integer.parseInt(request.getParameter("District_id"));
        String CityName=request.getParameter("CityName");

        Address address =new Address(Address_id,AddressType_id,Registration_id,Address_MunicipalityName,Municipality_id,StreetName,WardNo,Country_id,State_id,District_id,CityName);
        addressDAO.updateAddress(address);
        if(address != null )
        {
            request.getSession().setAttribute("updateMessage", "Update Successfully!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_address");

        }
        else {
            request.getSession().setAttribute("updateMessage", "Not Updated!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_address");
        }
    }

    private void listAddress(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Address> address =new ArrayList<Address>();
        String SearchAddress=request.getParameter("SearchAddress");
        address = addressDAO.selectAllAddress(SearchAddress);
        request.setAttribute("listAddress", address);
        RequestDispatcher dispatcher=request.getRequestDispatcher("addresslist.jsp");
        dispatcher.forward(request,response);
    }


}
