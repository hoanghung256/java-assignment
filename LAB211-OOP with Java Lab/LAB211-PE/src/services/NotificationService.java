/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.ArrayList;
import models.Notification;
import repository.NotificationRepository;

/**
 *
 * @author hoang hung
 */
public class NotificationService {
    private static NotificationService instance;
    private static ArrayList<Notification> notifications;
    
    private NotificationService() {
        notifications = NotificationRepository.getInstance().getNoti();
    }
    
    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }
    
    public void viewAllNoti() {
        System.out.println("+--------+-----------+-------------+---------------------------------------------------------+");
        System.out.println(String.format("| %-6s | %-5s | %-5s | %-55s |", 
                                            "ID","Sender ID", "Receiver ID", "Description"));
        System.out.println("+--------+-----------+-------------+---------------------------------------------------------+");
        for (Notification noti : notifications) {
            System.out.println(noti);
        }
        System.out.println("+--------+-----------+-------------+---------------------------------------------------------+");
    }

    public static void main(String[] args) {
        NotificationService.getInstance().viewAllNoti();
    }
}
