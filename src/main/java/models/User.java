package models;

public class User {
    private int userID;
    private String username;
    private String role;

    public int getId() { return userID; }
    public void setId(int id) { this.userID = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
