/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import database.FileManager;
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
    private final FileManager db;
    private final Validation validator;
    private final FruitManager fruitManager;
    
    public OrderManager() {
        db = new FileManager();
        orderList = new ArrayList<>();
        validator = new Validation();
        fruitManager = new FruitManager();
    }
    
    public void displayAllOrders() {
        getOrderFromFile();
        
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
    
    public void getOrderFromFile() {
        orderList = db.readOrdersFromFile();
    }
    
    public void writeOrderIntoFile() {
        db.writeOrdersIntoFile(orderList);
    }
    
    public static void displayOrder(HashMap<Fruit, Integer> order) {
        String leftAlignFormat = "| %-12s | %-8s | %-5s | %-6s |%n";
        System.out.format("+--------------+----------+-------+--------+%n");
        System.out.format("| Fruit Name   | Quantity | Price | Amount |%n");
        System.out.format("+--------------+----------+-------+--------+%n");
        
        int total = 0;
        for (Fruit key : order.keySet()) {
            int price = key.getPrice();
            int quantity = order.get(key);
            int amount = price * quantity;
            total += amount;
            System.out.format(leftAlignFormat, key.getName(), quantity, price + "$", amount + "$");
        }
        System.out.format("+--------------+----------+-------+--------+%n");
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

            if (result.getName() == null) {
                System.out.println("Fruit not found");
                continue;
            } else {
                System.out.println("You selected: " + result.getName());
            }
            int buyQuantity = validator.getAndValidBuyQuantity("Enter quantity: ", result);
            
            handleNewOrder(order, result, buyQuantity);
            
            System.out.print("Do you want to order now (Y/N):");
            char choice = sc.nextLine().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                isContinue = false;
            }
        } while (isContinue == true);
        
        fruitManager.updateFruitsQuantity(order);
        return order;
    }
    
    private static void handleNewOrder(HashMap<Fruit, Integer> order, Fruit fruit, int buyQuantity) {
        if (order.containsKey(fruit)) {
            order.put(fruit, order.get(fruit) + buyQuantity);
            return;
        }
        
        order.put(fruit, buyQuantity);
    }
}

