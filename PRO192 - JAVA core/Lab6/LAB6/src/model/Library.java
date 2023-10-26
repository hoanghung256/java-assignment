/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 *
 * @author hoang
 */
public class Library {
    private final ArrayList<Book> listOfBook = new ArrayList<>();
    private static final File FILE = new File("src");
    private static final String PATH = FILE.getAbsolutePath();
    private static final String FILE_NAME = "\\model\\lib.txt";
    static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy");
    static final Pattern ID_PATTERN = Pattern.compile("^[B][0-9]{3}$");

    public Library() {
    }

    public void showAllBook() throws ParseException {
        System.out.println("List of books");
        System.out.println("-------------------------------------");
        if (loadData()) {
            listOfBook.forEach(b -> System.out.println(b));
        } else {
            System.out.println("Load data failed...");
        }
        System.out.println("-------------------------------------");
    }

    public ArrayList<Book> searchByCriteria(Predicate<Book> criteria) {
        ArrayList<Book> matched = new ArrayList<>();
        for (Book b : listOfBook) {
            if (criteria.test(b)) {
                matched.add(b);
            }
        }
        return matched;
    }

    public void addNewBook() {
        Scanner sc = new Scanner(System.in);
        String id = "";
        do {
            System.out.print("Enter ID: ");
            id = id + sc.nextLine();
        } while (isValidID(id) == false);
        System.out.print("Enter book's title: ");
        String title = sc.nextLine();
        System.out.print("Enter name of author: ");
        String author = sc.nextLine();
        String date = "";
        do {
            System.out.print("Enter published date: ");
            date = date + sc.nextLine();
        } while (isValidDate(date) == false);

        try {
            listOfBook.add(new Book(id, title, author, convertStringToDate(date)));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


private boolean loadData() {
        String std;

        try (BufferedReader br = new BufferedReader(new FileReader(PATH + FILE_NAME))) {    //Try with resource
            while ((std = br.readLine()) != null) {
                String[] b = std.split(";");
                try {
                    listOfBook.add(new Book(b[0], b[1], b[2], convertStringToDate(b[3])));
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
        try (PrintWriter pr = new PrintWriter(PATH + FILE_NAME);) {
            for (Book s : listOfBook) {
                pr.println(s.getId() + ";" + s.getTitle() + ";" + s.getAuthor() + ";" + s.getPublishDate());
            }
            pr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public static boolean isValidDate(String date) {
        FORMATTER.setLenient(false);
        try {
             FORMATTER.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isValidID(String id) {
        return ID_PATTERN.matcher(id).matches();
    }
    
    public static Date convertStringToDate(String dateString) throws Exception {
        return FORMATTER.parse(dateString);
    }
    
    public static String convertDateToString(Date date) throws Exception {
        return FORMATTER.format(date);
    }
}
