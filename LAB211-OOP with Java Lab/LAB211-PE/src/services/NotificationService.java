/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author hoang hung
 */
public class NotificationService {
    private static NotificationService notiService = null;
    
    private NotificationService() {
    }
    
    public static NotificationService getInstance() {
        if (notiService == null) {
            notiService = new NotificationService();
        }
        
        return notiService;
    }
    
    public void viewAllNoti() {
        
    }
}
