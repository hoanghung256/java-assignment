/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import models.Notification;

/**
 *
 * @author hoang hung
 */
public class NotificationRepository {
    private static NotificationRepository notiRepo = null;
    private final String srcPath = new File("src").getAbsolutePath();
    final String notiPath = "\\data\\notifications.txt";
    
    private NotificationRepository() {
    }
    
    public static NotificationRepository getInstance() {
        if (notiRepo == null) {
            notiRepo = new NotificationRepository();
        }
        
        return notiRepo;
    }
    
    public ArrayList<Notification> getNoti() {
        String line;
        try (BufferedReader input = new BufferedReader(new FileReader(srcPath + notiPath))) {
            ArrayList<Notification> notifications = new ArrayList<>();
            while((line = input.readLine())!= null){
                String[] attributes = line.split(";");
                Notification notification = new Notification(attributes[0], attributes[1], attributes[2], attributes[3]);     
                notifications.add(notification);
            }
            return notifications;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /** Get notification for specific staff
     */
    public ArrayList<Notification> getNoti(int staffId) {
        String line;
        try (BufferedReader input = new BufferedReader(new FileReader(srcPath + notiPath))) {
            ArrayList<Notification> notifications = new ArrayList<>();
            while((line = input.readLine())!= null){
                String[] attributes = line.split(";");
                if (Integer.parseInt(attributes[2]) == (staffId)) {
                    Notification notification = new Notification(attributes[0], attributes[1], attributes[2], attributes[3]);
                    notifications.add(notification);
                }
            }
            return notifications;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
