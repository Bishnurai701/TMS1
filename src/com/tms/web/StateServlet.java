package com.tms.web;



import com.tms.dao.StateDAO;
import com.tms.model.State;

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

@WebServlet(name = "StateServlet",urlPatterns = {("/list_state"),("/new_state"),("/insert_state"),("/delete_state"),("/edit_state"),("/update_state")})
public class StateServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private StateDAO stateDAO;

    public void init(){this.stateDAO=new StateDAO();}


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getServletPath();
        switch (action){
            case "/new_state":
                try {
                    showNewForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/insert_state":
                try {
                    insertState(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete_state":
                try {
                    deleteState(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit_state":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "update_state":
                try {
                    updateState(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listState(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("stateform.jsp");
        dispatcher.forward(request, response);
    }

    private void insertState(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException, ClassNotFoundException {
        //HttpSession session=request.getSession();
        try {

            String StateName = request.getParameter("StateName");
            State newState = new State(StateName);

            if(StateName=="")
            {
                request.getSession().setAttribute("notnullMessage", "StateName Null!");
                response.sendRedirect("stateform.jsp");
            }
            else
            {
                //String LoginName=request.getParameter("UserLoginName");
                if((StateDAO.existState(StateName)) == false)
                {
                    StateDAO.insertState(newState);
                    if (newState != null) {
                        //UserDAO.existUser(UserName, UserLoginName);
                        request.getSession().setAttribute("successMessage", "Saved Successfully!");
                        response.sendRedirect("list_state");
                    }
                    else
                    {
                        request.getSession().setAttribute("alertMessage", "WrongState!");
                        response.sendRedirect("stateform.jsp");
                    }
                }
                else
                {
                    request.getSession().setAttribute("existMessage", "AlreadyExist!");
                    response.sendRedirect("stateform.jsp");
                }
            }
        }catch (SQLException e){ e.printStackTrace();

        }
    }



    private void deleteState(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        int State_id=Integer.parseInt(request.getParameter("State_id"));
        if(stateDAO.deleteState(State_id) == true)
        {
            request.getSession().setAttribute("deleteMessage", "Deleted Success!");
            response.sendRedirect("list_state");
        }
        else
        {
            request.getSession().setAttribute("deleteMessage", "Not Deleted!");
            response.sendRedirect("list_state");
        }
    }

    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int State_id=Integer.parseInt(request.getParameter("State_id"));
        State existingState= stateDAO.selectStateById(State_id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("stateform.jsp");
        request.setAttribute("state",existingState);
        dispatcher.forward(request,response);

    }

    private void updateState(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        int State_id=Integer.parseInt(request.getParameter("State_id"));
        String StateName=request.getParameter("StateName");
        State state=new State(State_id,StateName);
        stateDAO.updateState(state);
        if(state != null)
        {
            request.getSession().setAttribute("updateMessage", "Update Successfully!");
            response.sendRedirect("list_state");

        }
        else {
            request.getSession().setAttribute("updateMessage", "Not Updated!");
            response.sendRedirect("list_state");
        }
    }

    private void listState(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<State> state=new ArrayList<State>();
        String SearchState=request.getParameter("SearchState");
        state=stateDAO.selectAllStates(SearchState);
        request.setAttribute("listState",state);
        RequestDispatcher dispatcher=request.getRequestDispatcher("statelist.jsp");
        dispatcher.forward(request,response);
    }



}
