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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author hoang
 */
public class Library {
    private final ArrayList<Book> listOfBook = new ArrayList<>();
    private static final File FILE = new File("src");
    private static final String PATH = FILE.getAbsolutePath();
    private static final String FILE_NAME = "\\model\\lib.txt";
    
    public void showAllBook() {
        System.out.println("List of books");
        System.out.println("-------------------------------------");
        if (loadData()) {
            listOfBook.forEach(b -> System.out.println(b));
        } else {
            System.out.println("Load data failed...");
        }
        System.out.println("-------------------------------------");
    }
    
    public void searchByCriteria(Predicate<Book> criteria) {
        System.out.println("Book matched");
        System.out.println("-------------------------------------");
        for (Book b : listOfBook) {
            if (criteria.test(b)) {
                System.out.println(b.toString());
            }
        }
        System.out.println("-------------------------------------");
    }
    
    public void addNewBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book's ID: ");
        String id = sc.nextLine();
        System.out.print("Enter book's title: ");
        String title = sc.nextLine();
        System.out.print("Enter name of author: ");
        String author = sc.nextLine();
        System.out.print("Enter published date: ");
        String publishDate = sc.nextLine();
        listOfBook.add(new Book(id, title, author, publishDate));
        if (saveData()) {
            System.out.println("Add new book into databsae succeed...");
        } else {
            System.out.println("Add new book into databsae falied...");
        }
    }
    
    private boolean loadData() {
        String std;

        try (BufferedReader br = new BufferedReader(new FileReader(PATH + FILE_NAME))) {    //Try with resource
            while ((std = br.readLine()) != null) {
                String[] b = std.split(";");
                listOfBook.add(new Book(b[0], b[1], b[2], b[3]));  
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
}
