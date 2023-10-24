/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Library;
import view.Menu;

/**
 *
 * @author hoang
 */
public class LibraryManagement extends Menu<String> {
    private Library model = new Library();
    
    public LibraryManagement(String title, ArrayList<String> options) {
        super(title, options);
    }

    @Override
    public void execute(int choice) {
        Scanner sc = new Scanner(System.in);
        switch (choice) {
            case 1:
                model.showAllBook();
                break;
            case 2:
                System.out.println("case2");
                break;
            case 3:
                model.addNewBook();
                break;
            case 4:
                System.out.println("bye");
                System.exit(0);
            default:
                
                break;
        }
    }

}
