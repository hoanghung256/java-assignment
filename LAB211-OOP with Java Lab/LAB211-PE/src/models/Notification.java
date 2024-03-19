/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author hoang hung
 */
public class Notification {
    private String notiId;
    private String senderId;
    private String receiverId;
    private String description;

    public Notification(String notiId, String senderId, String receiverId, String description) {
        this.notiId = notiId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.description = description;
    }

    public String getNotiId() {
        return notiId;
    }

    public void setNotiId(String notiId) {
        this.notiId = notiId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("| %-2s | %-9s | %-11s | %-55s |", notiId, senderId, receiverId, description);
    }
}
