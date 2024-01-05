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

/**
 *
 * @author hoang
 */
public class OrderManager {
    private ArrayList<Order> orderList;
    private FileManager db;
    
    public OrderManager() {
        db = new FileManager();
        orderList = new ArrayList<>();
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
}
