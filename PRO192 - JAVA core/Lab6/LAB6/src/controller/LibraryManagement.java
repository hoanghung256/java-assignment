/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Book;
import view.Menu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author hoang
 */
public class LibraryManagement extends Menu<String> {

    private final Book model = new Book();
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
        searchMenu = new Menu<String>(subMenuTitle, subOptions) {       //Anonymous class extends Menu<T> abstract class
            Scanner sc = new Scanner(System.in);

            @Override       //Override excute() for search menu
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        String searchId = sc.nextLine();
                        Predicate<Book> searchById = b -> b.getId().equals(searchId);
                        model.searchByCriteria(searchById);
                        break;
                    case 2:
                        System.out.print("Enter title: ");
                        String searchTitle = sc.nextLine();
                        Predicate<Book> searchByTitle = b -> b.getTitle().equals(searchTitle);
                        model.searchByCriteria(searchByTitle);
                        break;
                    case 3:
                        System.out.print("Enter author's name: ");
                        String searchAuthor = sc.nextLine();
                        Predicate<Book> searchByAuthor = b -> b.getAuthor().equals(searchAuthor);
                        model.searchByCriteria(searchByAuthor);
                        break;
                    case 4:
                        System.out.print("Enter year: ");
                        String searchYear = sc.nextLine();
                        Predicate<Book> searchByYear = b -> {
                            String[] date =  b.getPublishDate().split("/");
                            return date[date.length - 1].equals(searchYear);
                        };
                        model.searchByCriteria(searchByYear);
                        break;
                    default:
                        break;
                }
            }
        };
    }

    @Override       //Override excute() for main menu
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
