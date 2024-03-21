/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.ArrayList;

import controller.Controller;
import models.Notification;
import models.Staff;
import repository.NotificationRepository;
import utils.IDGenerator;
import utils.Validation;

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

    public void viewAllNoti(Staff staff) {
        System.out.println(
                "+--------+-----------+-------------+---------------------------------------------------------+");
        System.out.println(String.format("| %-6s | %-5s | %-5s | %-55s |",
                "ID", "Sender ID", "Receiver ID", "Description"));
        System.out.println(
                "+--------+-----------+-------------+---------------------------------------------------------+");
        for (Notification noti : notifications) {
            if (noti.getReceiverId().equals(staff.getStaffId()) || noti.getSenderId().equals(staff.getStaffId())) {
                System.out.println(noti);
            }
        }
        System.out.println(
                "+--------+-----------+-------------+---------------------------------------------------------+");
    }

    public void viewAllNoti() {
        System.out.println(
                "+--------+-----------+-------------+---------------------------------------------------------+");
        System.out.println(String.format("| %-6s | %-5s | %-5s | %-55s |",
                "ID", "Sender ID", "Receiver ID", "Description"));
        System.out.println(
                "+--------+-----------+-------------+---------------------------------------------------------+");
        for (Notification noti : notifications) {
            System.out.println(noti);
        }
        System.out.println(
                "+--------+-----------+-------------+---------------------------------------------------------+");
    }

    public void viewAllSendNoti() {
        String sendBy = Controller.getInstance().getLoginStaff().getStaffId();
        System.out.println(
                "+--------+-----------+-------------+---------------------------------------------------------+");
        System.out.println(String.format("| %-6s | %-5s | %-5s | %-55s |",
                "ID", "Sender ID", "Receiver ID", "Description"));
        System.out.println(
                "+--------+-----------+-------------+---------------------------------------------------------+");
        for (Notification noti : notifications) {
            if (noti.getSenderId().equals(sendBy)) {
                System.out.println(noti);
            }
        }
        System.out.println(
                "+--------+-----------+-------------+---------------------------------------------------------+");
    }

    public void viewAllReceivedNoti() {
        String received = Controller.getInstance().getLoginStaff().getStaffId();

        System.out.println(
                "+--------+-----------+-------------+---------------------------------------------------------+");
        System.out.println(String.format("| %-6s | %-5s | %-5s | %-55s |",
                "ID", "Sender ID", "Receiver ID", "Description"));
        System.out.println(
                "+--------+-----------+-------------+---------------------------------------------------------+");
        for (Notification noti : notifications) {
            if (noti.getReceiverId().equals(received)) {
                System.out.println(noti);
            }
        }
        System.out.println(
                "+--------+-----------+-------------+---------------------------------------------------------+");
    }

    public void sendNoti() {
        String senderId = Controller.getInstance().getLoginStaff().getStaffId();
        String receiverId = Validation.getAndValidateStaffId(1, "Enter receiver ID: ");
        String description = Validation.getValue("Enter description of notification: ");

        Notification noti = new Notification(
                IDGenerator.generate("NO", notifications.size()),
                senderId,
                receiverId,
                description);
        if (notifications.add(noti)) {
            System.out.println("Send notification successfully!");
        } else {
            System.out.println("Send notification failed!");
        }
    }
}
