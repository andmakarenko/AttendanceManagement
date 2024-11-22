package controllers;

import dao.AttendanceDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Attendance;

import java.io.IOException;
import java.io.PrintWriter;

public class AttendanceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AttendanceDAO attendanceDAO = new AttendanceDAO();
        Attendance attendance = attendanceDAO.getAttendance(Integer.parseInt(req.getAttribute("userID").toString()));
        if(attendance == null){
            req.setAttribute("message", "Attendance not found");
        }

        req.setAttribute("attendance", attendance);
        RequestDispatcher dispatcher = req.getRequestDispatcher("attendance.jsp");
        dispatcher.forward(req, resp);
    }
}
