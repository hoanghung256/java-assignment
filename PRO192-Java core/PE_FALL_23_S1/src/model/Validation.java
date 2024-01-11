/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Predicate;
import java.util.regex.Matcher;

/**
 *
 * @author hoang
 */
public class Validation {
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    public static boolean isValidPhone(String phone) {
            Predicate<Patient> isValidPhone = e -> e.getPhone().equals(phone);
            if (PatientList.searchByCriteria(isValidPhone).isEmpty()) {
                return true;
            }
            System.out.println("This phone already exists!");
            return false;
    }
    
    public static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            System.out.println("Date must be in the format: dd/MM/yyyy");
            return false;
        }
    }

    public static Date convertStringToDate(String dateString) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.parse(dateString);
    }

    public static String convertDateToString(Date date) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(date);
    }
}
