/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;
import models.*;
import view.Menu;

/**
 *
 * @author hoang
 */
public class FruitShopManager extends Menu<String> {
    private static FruitManager fruitManager = new FruitManager();
    private static OrderManager orderManager = new OrderManager();
    private static final String menuTitle = "FRUIT SHOP SYSTEM";
    private static final String[] menuOptions = {"Create Fruit", "View order", "Shopping", "Display all fruits", "Exit"};

    public FruitShopManager() {
        super(menuTitle, menuOptions);
    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createNewFruit();
                break;
            case 2:
                displayAllOrders();
                break;
            case 3:
                shopping();
                break;
            case 4: 
                displayAllFruit();
                break;
            case 5:
                exit();
                break;
        }
    }
    
    private static void createNewFruit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter price: ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter origin: ");
        String origin = sc.nextLine();
        Fruit newFruit = new Fruit(name, price, quantity, origin);
        fruitManager.addNewFruit(newFruit);
    }
    
    private static void displayAllOrders() {
        orderManager.displayAllOrders();
    }
    
    private static void shopping() {
        Scanner sc = new Scanner(System.in);
        HashMap<Fruit, Integer> order = new HashMap<>();
        boolean isContinue = true;
        do {
            fruitManager.displayAllFruit();
            
            System.out.print("Enter fruit ID: ");
            int searchId = sc.nextInt();
            Predicate<Fruit> searchById = f -> (f.getId() == searchId);
            Fruit result = fruitManager.searchByCriteria(searchById);
            
            System.out.println("You selected: " + result.getName());
            int buyQuantity = 0;
            do {
                System.out.print("Enter quantity: ");
                buyQuantity = sc.nextInt();
                sc.nextLine();
                if (buyQuantity <= result.getQuantity()) {
                    break;
                } else {
                    System.out.println("Input quantity out of remain quantity!");
                }
            } while (true);
            
            fruitManager.updateFruitsQuantity(result, buyQuantity);
            
            System.out.print("Do you want to order now (Y/N):");
            String choice = sc.nextLine();
            if (choice.charAt(0) == 'Y') {
                isContinue = false;
            }
            
            order.put(result, buyQuantity);
        } while (isContinue == true);
        OrderManager.displayOrder(order);
        
        System.out.print("Input your name: ");
        String customerName = sc.nextLine();
        
        orderManager.addNewOrder(new Order(customerName, order));
        orderManager.writeOrderIntoFile();
    }
    
    private static void displayAllFruit() {
        fruitManager.displayAllFruit();
    }
    
    private static void exit() {
        fruitManager.writeFruitsIntoFile();
        System.out.println("Goodbye");
        System.exit(0);
    }
}
