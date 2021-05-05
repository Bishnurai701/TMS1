package com.tms.web;

import com.tms.dao.BoardDAO;
import com.tms.dao.FacultyDAO;
import com.tms.model.Board;
import com.tms.model.Faculty;

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

@WebServlet(name = "BoardServlet",urlPatterns = {("/list_board"),("/new_board"),("/insert_board"),("/delete_board"),("/edit_board"),("/update_board")})
public class BoardServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private BoardDAO boardDAO;
    public void init(){this.boardDAO=new BoardDAO();}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getServletPath();
        switch (action){
            case "/new_board":
                showNewFrom(request,response);
                break;
            case "/insert_board":
                try {
                    insertBoard(request,response);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete_board":
                try {
                    deleteBoard(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit_board":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/update_board":
                try {
                    updateBoard(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listBoard(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void showNewFrom(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher=request.getRequestDispatcher("boardform.jsp");
        dispatcher.forward(request,response);
    }

    private void insertBoard(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException,ClassNotFoundException{
        HttpSession session=request.getSession();
        try
        {
            String BoardName=request.getParameter("BoardName");
            Board newBoard=new Board(BoardName);
            if(BoardName==""){
                request.getSession().setAttribute("notnullMessage", "BoardName Null!");
                session.removeAttribute("alertMessage");
                session.removeAttribute("existMessage");
                response.sendRedirect("boardform.jsp");
            }
            else
            {
                if(BoardDAO.existBoard(BoardName)==false){
                    BoardDAO.insertBoard(newBoard);
                    if(newBoard != null){
                        request.getSession().setAttribute("successMessage", "Saved Successfully!");
                        session.removeAttribute("updateMessage");
                        session.removeAttribute("deleteMessage");
                        response.sendRedirect("list_board");
                    }
                    else
                    {
                        request.getSession().setAttribute("alertMessage", "WrongBoard!");
                        session.removeAttribute("notnullMessage");
                        session.removeAttribute("existMessage");
                        response.sendRedirect("boardform.jsp");
                    }
                }
                else
                {
                    request.getSession().setAttribute("existMessage", "AlreadyExist!");
                    session.removeAttribute("notnullMessage");
                    session.removeAttribute("alertMessage");
                    response.sendRedirect("boardform.jsp");
                }
            }
        }catch (SQLException e){e.printStackTrace();}
    }

    private void deleteBoard(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Board_id=Integer.parseInt(request.getParameter("Board_id"));
        if(boardDAO.deleteBoard(Board_id)==true){
            request.getSession().setAttribute("deleteMessage", "Deleted Success!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_board");
        }
        else {
            request.getSession().setAttribute("deleteMessage", "Not Deleted!");
            session.removeAttribute("successMessage");
            session.removeAttribute("updateMessage");
            response.sendRedirect("list_board");
        }
    }

    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int Board_id=Integer.parseInt(request.getParameter("Board_id"));
        Board existBoard = boardDAO.selectBoardById(Board_id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("boardform.jsp");
        request.setAttribute("board", existBoard);
        dispatcher.forward(request,response);
    }

    private void updateBoard(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        HttpSession session=request.getSession();
        int Board_id=Integer.parseInt(request.getParameter("Board_id"));
        String BoardName=request.getParameter("BoardName");
        Board board =new Board(Board_id,BoardName);
        boardDAO.updateBoard(board);
        if(board != null)
        {
            request.getSession().setAttribute("updateMessage", "Update Successfully!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_board");

        }
        else {
            request.getSession().setAttribute("updateMessage", "Not Updated!");
            session.removeAttribute("deleteMessage");
            session.removeAttribute("successMessage");
            response.sendRedirect("list_board");
        }
    }

    private void listBoard(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Board> board =new ArrayList<Board>();
        String SearchBoard=request.getParameter("SearchBoard");
        board = boardDAO.selectAllBoards(SearchBoard);
        request.setAttribute("listBoard", board);
        RequestDispatcher dispatcher=request.getRequestDispatcher("boardlist.jsp");
        dispatcher.forward(request,response);
    }



}
