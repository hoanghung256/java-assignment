/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author hoang
 */
public class Validation {
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    
    public static boolean isValidInt(String checkQuantity) {
        int quantity;
        try {
            quantity = Integer.parseInt(checkQuantity);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid quantity: " + checkQuantity);
            return false;
        }
        return true;
    }
    
    public static boolean isValidDouble(String checkPrice) {
        double price;
        try {
            price = Double.parseDouble(checkPrice);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid price: " + checkPrice);
            return false;
        }
        return true;
    }
    
    public static boolean isValidDate(String date) {
       SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException ex) {
            System.out.println("Date must be in the correct Date format: dd/mm/yyyy");
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
