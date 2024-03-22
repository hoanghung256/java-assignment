/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import models.Notification;

/**
 *
 * @author hoang hung
 */
public class NotificationRepository {
    private static NotificationRepository instance = null;
    private ArrayList<Notification> notifications;
    private final String srcPath = new File("src").getAbsolutePath();
    final String notiPath = "\\data\\notifications.txt";

    private NotificationRepository() {
    }

    public static NotificationRepository getInstance() {
        if (instance == null) {
            instance = new NotificationRepository();
        }

        return instance;
    }

    public ArrayList<Notification> getNoti() {
        if (notifications == null || notifications.size() == 0) {
            notifications = readNoti();
        }
        return notifications;
    }

    public ArrayList<Notification> readNoti() {
        notifications = new ArrayList<>();
        String line;
        try (BufferedReader input = new BufferedReader(new FileReader(srcPath + notiPath))) {
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(";");
                Notification notification = new Notification(
                        attributes[0],
                        attributes[1],
                        attributes[2],
                        attributes[3]);
                notifications.add(notification);
            }
            return notifications;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Get notification for specific staff
     */
    public ArrayList<Notification> getNoti(int staffId) {
        String line;
        try (BufferedReader input = new BufferedReader(new FileReader(srcPath + notiPath))) {
            ArrayList<Notification> notifications = new ArrayList<>();
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(";");
                if (Integer.parseInt(attributes[2]) == (staffId)) {
                    Notification notification = new Notification(attributes[0], attributes[1], attributes[2],
                            attributes[3]);
                    notifications.add(notification);
                }
            }
            return notifications;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void save() {
        try (PrintWriter writer = new PrintWriter(srcPath + notiPath)) {
            for (Notification noti : notifications) {
                writer.println(noti);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
