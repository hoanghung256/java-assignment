package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hoang hung
 */
public class User {
    private int userId;
    private int staffId;
    private String username;
    private String password;
    private String lever;

    public User(int userId, int staffId, String username, String password, String lever) {
        this.userId = userId;
        this.staffId = staffId;
        this.username = username;
        this.password = password;
        this.lever = lever;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLever() {
        return lever;
    }

    public void setLever(String lever) {
        this.lever = lever;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", staffId=" + staffId + ", username=" + username + ", password=" + password + ", lever=" + lever + '}';
    }
}
