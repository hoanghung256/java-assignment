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
    private int notiId;
    private int senderId;
    private int receiverId;
    private String description;

    public Notification(int notiId, int senderId, int receiverId, String description) {
        this.notiId = notiId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.description = description;
    }

    public int getNotiId() {
        return notiId;
    }

    public void setNotiId(int notiId) {
        this.notiId = notiId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
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
        return "Notification{" + "notiId=" + notiId + ", senderId=" + senderId + ", receiverId=" + receiverId + ", description=" + description + '}';
    }
}
