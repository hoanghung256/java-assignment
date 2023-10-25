/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hoang
 */
public class Book extends Library{
    private String id;
    private String title;
    private String author;
    private String publishDate;

    public Book() {
    }

    public Book(String id, String title, String author, String publishDate) {
        if (validateId(id)) {
            this.id = id;
        } else {
            System.out.println("The CusId does not accept the format (fading B and has 4 keys)");
        }
        this.title = title;
        this.author = author;
        if (validateDate(publishDate)) {
            this.publishDate = publishDate;
        } else {
            System.out.println("DatePublished must be in the correct Date format: dd/mm/yyyy");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (validateId(id)) {
            this.id = id;
        } else {
            System.out.println("The CusId does not accept the format (fading B and has 4 keys)");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        if (validateDate(publishDate)) {
            this.publishDate = publishDate;
        } else {
            System.out.println("DatePublished must be in the correct Date format: dd/mm/yyyy");
        }
    }

    @Override
    public String toString() {
        return "Book{"+ id + " - " + title + " - " + author + " - " + publishDate + '}';
    }
    
    private boolean validateId(String id) {
        Pattern pattern = Pattern.compile("^[B][0-9]{3}$");
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }
    
    private boolean validateDate(String date) {
        Pattern pattern = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((19|20)\\d\\d)$");
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
