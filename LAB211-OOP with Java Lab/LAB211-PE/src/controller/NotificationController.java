package controller;

import services.NotificationService;
import view.Menu;

public class NotificationController {
    private static NotificationController instance;
    private NotificationService notiService;

    private NotificationController() {
        notiService = NotificationService.getInstance();
    }

    public static NotificationController getInstance() {
        if (instance == null) {
            instance = new NotificationController();
        }
        return instance;
    }

    /**
     * Manger can view all the notification
     */
    public void runNotificationMenuForManager() {
        String title = "NOTIFICATION MENU";
        String[] options = {
                "View all notifications",
                "View notifications send by you",
                "View notification received",
                "Send notification",
                "Return main menu"
        };

        Menu<String> notificationMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> notiService.viewAllNoti();
                    case 2 -> notiService.viewAllSendNoti();
                    case 3 -> notiService.viewAllReceivedNoti();
                    case 4 -> notiService.sendNoti();
                    case 5 -> {
                        return;
                    }
                }
            }
        };

        notificationMenu.run();
    }

    /**
     * Staff can only view the notification send to themself or sended by themself
     */
    public void runNotificationMenuForStaff() {
        String title = "NOTIFICATION MENU";
        String[] options = {
                "View your notifications",
                "Send notification"
        };

        Menu<String> notificationMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> notiService.viewAllNoti(Controller.getInstance().getLoginStaff());
                    case 2 -> notiService.sendNoti();
                }
            }
        };

        notificationMenu.run();
    }
}
