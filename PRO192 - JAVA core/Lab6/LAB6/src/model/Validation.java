/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hoang
 */
public class Validation {
    static final Pattern ID_PATTERN = Pattern.compile("^[B][0-9]{3}$");
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    
    public static boolean isValidDate(String date) {
       SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        try {
            dateFormat.parse(date);
            return true;
        } catch (Exception e) {
            System.out.println("Invalid date format dd/mm/yyyy");
            return false;
        } 
    }

    public static boolean isValidID(String id) {
        Matcher check = ID_PATTERN.matcher(id);
        if (check.matches()) {
            Library lib = new Library();
            
            return false;
        } 
        System.out.println("The CusId does not accept the format (fading B and has 4 keys)");
        return false;
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
