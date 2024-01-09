/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import database.FileManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author hoang
 */
public class OrderManager {
    private ArrayList<Order> orderList;
    private FileManager db;
    private Validation validator;
    private FruitManager fruitManager;
    
    public OrderManager() {
        db = new FileManager();
        orderList = new ArrayList<>();
        validator = new Validation();
        fruitManager = new FruitManager();
    }
    
    public void displayAllOrders() {
        orderList = getOrderFromFile();
        for (Order order : orderList) {
            System.out.println("Customer: " + order.getCustomerName());
            displayOrder(order.getCustomerorder());
            System.out.println("");
        }
        System.out.println("Total order: " + orderList.size());
    }
    
    public void addNewOrder(Order order) {
        orderList.add(order);
    }
    
    public ArrayList<Order> getOrderFromFile() {
        return db.readOrdersFromFile();
    }
    
    public void writeOrderIntoFile() {
        db.writeOrdersIntoFile(orderList);
    }
    
    public static void displayOrder(HashMap<Fruit, Integer> order) {
        int total = 0;
        for (Fruit key : order.keySet()) {
            int price = key.getPrice();
            int quantity = order.get(key);
            int amount = price * quantity;
            total += amount;
            System.out.println("Fruit name: " + key.getName() + ", Quantity: " + quantity + ", Price: " + price + "$, Amount: " + amount + "$");
        }
        System.out.println("Total: " +  total + "$");
    }
    
    public HashMap<Fruit, Integer> getCurrentOrder() {
         Scanner sc = new Scanner(System.in);
        HashMap<Fruit, Integer> order = new HashMap<>();
        boolean isContinue = true;
        
        do {
            fruitManager.displayAllFruit();

            int searchId = validator.getAndValidInt("Enter fruit ID: ");
            Predicate<Fruit> searchById = f -> (f.getId() == searchId);
            Fruit result = fruitManager.searchByCriteria(searchById);

            System.out.println("You selected: " + result.getName());
            int buyQuantity = validator.getAndValidBuyQuantity("Enter quantity: ", result);
            
            fruitManager.updateFruitsQuantity(result, buyQuantity);
            
            System.out.print("Do you want to order now (Y/N):");
            String choice = sc.nextLine();
            if (choice.charAt(0) == 'Y') {
                isContinue = false;
            }

            order.put(result, buyQuantity);
        } while (isContinue == true);
        
        return order;
    }
}

