/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hoang
 * @param <T>
 */
public abstract class Menu<T> {
    protected String title;
    protected ArrayList<T> options;

    public Menu() {
    }

    public Menu(String title, String[] option) {
        this.title = title;
        this.options = new ArrayList<>();
        for (String s : option) {
            options.add((T) s);
        }
    }
    
    public void displayMenu() {
        System.out.println(title);
        System.out.println("-------------------------------------");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i+1) + ". " + options.get(i));
        }
        System.out.println("-------------------------------------");
    }
    
    public int getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter choice: ");
        return sc.nextInt();
    }
    
    public abstract void execute(int n);
    
    public void run(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            displayMenu();
            int choice = getChoice();
            execute(choice);
            if (choice <= 0 || choice > options.size()) {
                System.out.println("Invalid choice!!!");
            }
        } 
    }
}
