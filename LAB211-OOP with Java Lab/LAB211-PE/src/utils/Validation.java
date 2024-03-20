package utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import services.StaffService;
import services.UserService;

public class Validation {
    public static String getValue(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        return sc.nextLine();
    }

    public static int getInt(String msg) {
        while (true) {
            String value = getValue(msg);
            try {
                int parsed = Integer.parseInt(value);
                if (parsed < 0) {
                    System.out.println("Number input must greater than 0!");
                    continue;
                }
                return parsed;
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format!");
                continue;
            }
        }
    }

    public static LocalDate parseLocalDate(String localDate) {
        try {
            LocalDate date = LocalDate.parse(localDate);
            return date;
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static LocalDate getDate(String msg) {
        try {
            String dateStr = getValue(msg);
            LocalDate date = LocalDate.parse(dateStr);
            return date;
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static LocalTime getTime(String msg) {
        try {
            String timeStr = getValue(msg);
            LocalTime time = LocalTime.parse(timeStr);
            return time;
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static String getAndValidateStaffId(String msg) {
        String id = null;
        while (true) {
            id = getValue(msg);
            if (StaffService.getInstance().findById(id) == null) {
                System.out.println("Staff not exists!");
                continue;
            }
            break;
        }
        return id;
    }

    public static String getAndValidateStaffName(String msg) {
        String name = null;
        while (true) {
            name = getValue(msg);
            if (StaffService.getInstance().findByName(name) == null) {
                System.out.println("Staff not exists!");
                continue;
            }
            break;
        }
        return name;
    }
}
