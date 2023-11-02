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
import java.util.regex.Pattern;

/**
 *
 * @author hoang
 */
public class Validation {
    private static final Pattern ID_PATTERN = Pattern.compile("^NV[0-9]{4}$");
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    
    public static boolean isValidID(String id) {
        Matcher check = ID_PATTERN.matcher(id);
        if (check.matches()) {
            StaffList staffs = new StaffList();
            Predicate<Staff> isValidId = s -> s.getId().equals(id);
            if (staffs.searchByCriteria(isValidId).isEmpty()) {
                return true;
            }
            System.out.println(id + ": this ID already exists!");
            return false;
        } 
        System.out.println("The staff member does not accept the format (fading MNV and has 6 keys): " + id);
        return false;
    }
    
    public static boolean isValidDate(String date) {
       SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException ex) {
            System.out.println("Date must be in the correct Date format: dd/mm/yyyy: " + date);
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
