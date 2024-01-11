
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author hoang
 */
public class ConsoleForm {

    Scanner sc = new Scanner(System.in);
    ItemList itemList = new ItemList();
    static ArrayList<Item> myList = itemList.getItemList();

    public void display() {
        if (myList.isEmpty()) {
            System.out.println("There is no element.");
        } else {
            for (Item a : myList) {
                System.out.println(a.toString());
            }
        }
    }

    public void displayMenu() {
        System.out.println("WELCOME TO ITEM MANAGEMENT");
        System.out.println("1. Create item");
        System.out.println("2. View item");
        System.out.println("3. Search item");
        System.out.println("4. Exit");
    }

    public void createNew() {
        System.out.println("Enter code:");
        int code = sc.nextInt();
        sc.nextLine();
//        boolean f = false;
//        boolean e = false;
        int f = 0;
        int e = 0;
        for (Item a : myList) {
            if (a.getCode() == code) {
                System.out.println("This code is already in List.");
            } else {
                f = 1;
            }
        }
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter price: ");
        int price = sc.nextInt();
        sc.nextLine();
        if (price <= 0) {
            System.out.println("Price must be positive integer.");
        } else {
            e = 1;
        }
        if (f == 1 && e == 1) {
            Item item = new Item(code, name, price);
            myList.add(item);
            System.out.println("Add succesesfully.");
        } else {
            System.out.println("Error adding");
        }

    }

    public void searchItem() {
        System.out.println("Enter code to search: ");
        int code = sc.nextInt();
        for (Item b : myList) {
            if (b.getCode() == code) {
                System.out.println(b.toString());
            } else {
                System.out.println("Not found.");
            }
        }
    }
}
