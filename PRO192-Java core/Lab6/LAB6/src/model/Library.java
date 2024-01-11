/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static model.Validation.convertStringToDate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author hoang
 */
public class Library {
    private static final ArrayList<Book> listOfBook = new ArrayList<>();
    private static final File FILE = new File("src");
    private static final String PATH = FILE.getAbsolutePath();
    private static final String DATA_FILE_NAME = "\\model\\lib.txt";

    public Library() {
        loadData();
    }

    public void showAllBook() throws ParseException {
        System.out.println("List of books");
        System.out.println("-------------------------------------");
        listOfBook.forEach(b -> System.out.println(b));
        System.out.println("-------------------------------------");
        System.out.println("Total book: " + listOfBook.size());
    }

    public ArrayList<Book> searchByCriteria(Predicate<Book> criteria) {
        ArrayList<Book> matched = new ArrayList<>();
        for (Book b : listOfBook) {
            if (criteria.test(b)) {
                matched.add(b);
            }
        }
        if (matched.isEmpty()) {
            System.out.println("No book matched!");
        }
        return matched;

    }

    public void addNewBook() {
        Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.print("Enter ID: ");
            id = sc.nextLine();
            if (Validation.isValidID(id)) {
                break;
            }
        }
        System.out.print("Enter book's title: ");
        String title = sc.nextLine();
        System.out.print("Enter name of author: ");
        String author = sc.nextLine();
        String date;
        while (true) {
            System.out.print("Enter publish date: ");
            date = sc.nextLine();
            if (Validation.isValidDate(date)) {
                break;
            }
        }
        try {
            listOfBook.add(new Book(id, title, author, convertStringToDate(date)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        saveData();
        System.out.println("Add book succeed!");
    }

    public void removeBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter title of book want to remove: ");
        String removeName = sc.nextLine();
        if (listOfBook.removeIf(b -> b.getTitle().equalsIgnoreCase(removeName))) {
            saveData();
            System.out.println("Remove book succeed!");
        } else {
            System.out.println("Book title not found!");
        }
    }

    private boolean loadData() {
        String std;

        try (BufferedReader br = new BufferedReader(new FileReader(PATH + DATA_FILE_NAME))) {    //Try with resource
            while ((std = br.readLine()) != null) {
                String[] b = std.split(";");
                try {
                    listOfBook.add(new Book(b[0], b[1], b[2], Validation.convertStringToDate(b[3])));
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    private boolean saveData() {
        try (PrintWriter pr = new PrintWriter(PATH + DATA_FILE_NAME);) {
            for (Book s : listOfBook) {
                pr.println(s.getId() + ";" + s.getTitle() + ";" + s.getAuthor() + ";" + Validation.convertDateToString(s.getPublishDate()));
            }
            pr.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public static void printResult(ArrayList<Book> result) {
        if (result.isEmpty()) {
            System.out.println("No book matched!");
        } else {
            System.out.println("Result");
            System.out.println("-------------------------------------");
            result.forEach(b -> System.out.println(b));
            System.out.println("-------------------------------------");
            System.out.println("Total book: " + result.size());
        }
    }
    
    public static void sortByPublishedDate() {
        Collections.sort(listOfBook);
        System.out.println("Sort by published date succeed!");
    }
}
