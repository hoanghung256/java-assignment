/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.LibraryManagement;
import java.util.ArrayList;

/**
 *
 * @author hoang
 */
public class App {
    public static void main(String[] args) {
        String menuTitle = "Library Mangement";
        ArrayList<String> options = new ArrayList<>();
        options.add("List all book");
        options.add("Search book");
        options.add("Add new book");
        options.add("Exit");
        LibraryManagement lib_manager = new LibraryManagement(menuTitle, options);
        lib_manager.run();
    }
}
