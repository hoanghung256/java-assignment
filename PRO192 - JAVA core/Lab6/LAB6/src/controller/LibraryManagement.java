/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Book;
import view.Menu;

/**
 *
 * @author hoang
 */
public class LibraryManagement extends Menu<String> {
    private Book model = new Book();
    private Menu<String> menu;
    private Menu<String> searchMenu;
    
    public LibraryManagement(String title, ArrayList<String> options) {
        super(title, options);
        createSearchMenu();
    }
    
    private void createSearchMenu() {
        String subMenuTitle = "Book Searching";
        ArrayList<String> subOptions = new ArrayList<>();
        subOptions.add("Find by BookID");
        subOptions.add("Find by Title");
        subOptions.add("Find by Author");
        subOptions.add("Find by Year of publishing");
        searchMenu = new Menu<String>(subMenuTitle, subOptions) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
//                        model.findByBookID();
                        System.out.println("search1");
                        break;
                    case 2:
//                        model.findByTitle();
                        System.out.println("search2");
                        break;
                    case 3:
//                        model.findByAuthor();
                        System.out.println("search3");
                        break;
                    case 4:
//                        model.findByYearOfPublishing();
                        System.out.println("search4");
                        break;
                    default:
                        break;
                }
            }
        };
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                model.showAllBook();
                break;
            case 2:
                searchMenu.run();
                break;
            case 3:
                model.addNewBook();
                break;
            case 4:
                System.out.println("Goodbye!!!");
                System.exit(0);
            default:
                
                break;
        }
    }

}
