package dao;

import models.Attendance;
import utils.DBConnection;
import utils.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceDAO {
    public Attendance getAttendance(int userID) {
        Attendance attendance = null;

        try(Connection connection = DBConnection.getConnection()){
            String sql = "select * from attendance where userID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                attendance = new Attendance();
                attendance.setAttendanceID(resultSet.getInt("attendanceID"));
                attendance.setUserID(userID);
                attendance.setDate(resultSet.getDate("date"));
                attendance.setStatus(resultSet.getString("status"));
            }
        }catch (SQLException e){
            System.out.println(e);
            e.printStackTrace();
        }
        return attendance;
    }

}
