package utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validation {
    public static String getValue(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        return sc.nextLine();
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
}
