package models;

/**
 *
 * @author hoang hung
 */
public class User {
    private String userId;
    private String staffId;
    private String username;
    private String password;
    private String lever;

    public User(String userId, String staffId, String username, String password, String lever) {
        this.userId = userId;
        this.staffId = staffId;
        this.username = username;
        this.password = password;
        this.lever = lever;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
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
        return "User{" + "userId=" + userId + ", staffId=" + staffId + ", username=" + username + ", password="
                + password + ", lever=" + lever + '}';
    }

    public String toFileString() {
        return this.userId + ";" + this.staffId + ";" + this.username + ";" + this.password + ";" + this.lever;
    }
}