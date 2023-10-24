/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.*;
import java.util.ArrayList;

/**
 *
 * @author hoang
 */
public class App {
    public static void main(String[] args) {
        String menuTitle = "Library Mangement";
        ArrayList<String> options = new ArrayList<>();
        options.add("List all books");
        options.add("Search book");
        options.add("Add new book");
        options.add("Exit");
        LibraryManagement libManager = new LibraryManagement(menuTitle, options);
        libManager.run();
    }
}
