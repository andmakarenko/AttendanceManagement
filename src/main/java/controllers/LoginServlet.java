package controllers;

import dao.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;
import utils.DBConnection;
import utils.PasswordUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.*;



public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.authenticate(username, password);

        if (user != null) {
            if (user.getRole().equals("admin")) {
                request.setAttribute("username", user.getUsername());
                request.setAttribute("userID", user.getId());
                RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("username", user.getUsername());
                request.setAttribute("userID", user.getId());
                RequestDispatcher dispatcher = request.getRequestDispatcher("studentDashboard.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Invalid username or password.");

            // Forward back to the login page (URL remains as /login)
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}


