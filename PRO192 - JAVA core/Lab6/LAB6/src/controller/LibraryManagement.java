/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.ParseException;
import java.util.Comparator;
import model.*;
import view.Menu;

import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author hoang
 */
public class LibraryManagement extends Menu<String> {

    private final Library model = new Library();
    private static final String[] menuOptions = {"List all books", "Search book", "Add new book", "Remove a book", "Sort by date published", "Exit"};
    private static final String[] searchMenuOptions = {"Find by BookID", "Find by Title", "Find by Author", "Find by Year of publishing"};
    private Menu<String> searchMenu;

    public LibraryManagement() {
        super("Library Managerment", menuOptions);
        createSearchMenu();
    }

    private void createSearchMenu() {

        //Define search menu with annonymous class
        searchMenu = new Menu<String>("Book Searching", searchMenuOptions) {
            Scanner sc = new Scanner(System.in);

            //Override excute() for search menu
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        String searchId = sc.nextLine();
                        Predicate<Book> searchById = b -> b.getId().equals(searchId);
                        Library.printResult(model.searchByCriteria(searchById));
                        break;
                    case 2:
                        System.out.print("Enter title: ");
                        String searchTitle = sc.nextLine();
                        Predicate<Book> searchByTitle = b -> b.getTitle().equals(searchTitle);
                        model.searchByCriteria(searchByTitle).forEach(s -> System.out.println(s.toString()));
                        break;
                    case 3:
                        System.out.print("Enter author's name: ");
                        String searchAuthor = sc.nextLine();
                        Predicate<Book> searchByAuthor = book -> book.getAuthor().equals(searchAuthor);
                        model.searchByCriteria(searchByAuthor).forEach(s -> System.out.println(s.toString()));
                        break;
                    case 4:
                        System.out.print("Enter year: ");
                        String searchYear = sc.nextLine();
                        Predicate<Book> searchByYear = b -> {
                            String[] date = b.getPublishDate().toString().split("/");
                            return date[date.length - 1].equals(searchYear);
                        };
                        model.searchByCriteria(searchByYear).forEach(s -> System.out.println(s.toString()));
                        break;
                }
            }
        };
    }

    //Override excute() for main menu
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                try {
                model.showAllBook();
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
            break;
            case 2:
                searchMenu.run();
                break;
            case 3:
                model.addNewBook();
                break;
            case 4:
                model.removeBook();
                break;
            case 5:
                model.sortByPublishedDate();
                break;
            case 6:
                System.out.println("Goodbye!!!");
                System.exit(0);
        }
    }

}
