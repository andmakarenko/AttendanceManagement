package models;

import java.util.Date;

public class Attendance {
    private int attendanceID;
    private int userID;
    private Date date;
    private String status;

    public void setAttendanceID(int attendanceID) {this.attendanceID = attendanceID;}
    public void setUserID(int userID) { this.userID = userID; }
    public void setDate(Date date) { this.date = date; }
    public void setStatus(String status) { this.status = status; }
    public int getAttendanceID() { return attendanceID; }
    public int getUserID() { return userID; }
    public Date getDate() { return date; }
    public String getStatus() { return status; }
}
