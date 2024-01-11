/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import models.Fruit;
import models.Order;

/**
 *
 * @author hoang
 */
public class FileManager {
    private final String path = new File("src").getAbsolutePath();
    private final String fruitsPath = "\\database\\fruits.txt";
    private final String ordersPath = "\\database\\orders.txt";
    
    public ArrayList<Fruit> readFruitsFromFile() {
        String line;
        ArrayList<Fruit> fruits = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path + fruitsPath))) {    //Try with resource
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                fruits.add(new Fruit(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), values[4]));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
        return fruits;
    }
    
    public void writeFruitsIntoFile(ArrayList<Fruit> fruits) {
        try (PrintWriter pr = new PrintWriter(path + fruitsPath);) {
            for (Fruit fruit: fruits) {
                pr.println(fruit.toFruitFileString());
            }
            pr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ArrayList<Order> readOrdersFromFile() {
        String line;
        ArrayList<Order> orders = new ArrayList<>();
        StringBuilder customerName = new StringBuilder();
        HashMap<Fruit, Integer> orderTable = new HashMap<>();
        
        int buyQuantity = 0;
        Fruit fruit = new Fruit();
        int lineNumber = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(path + ordersPath))) {    //Try with resource
            while ((line = br.readLine()) != null) {
                try {
                    if (Character.isLetter(line.charAt(0)) && lineNumber == 0) {
                        customerName.append(line);
                        continue;
                    } else if (Character.isLetter(line.charAt(0)) && lineNumber > 0) {
                        orders.add(new Order(customerName.toString(), orderTable));

                        customerName.delete(0, customerName.length());
                        orderTable = new HashMap<>();

                        customerName.append(line);
                        continue;
                    } else if (Character.isDigit(line.charAt(0))) {
                        int quantityLength = getBuyQuantityLength(line);
                        buyQuantity =  Integer.parseInt(line.substring(0, quantityLength));
                        String[] values = line.substring(quantityLength + 1, line.length()).split(",");
                        fruit = new Fruit(values[0], Integer.parseInt(values[1]));
                        orderTable.put(fruit, buyQuantity);
                    }
                    lineNumber++;
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println(Arrays.toString(ex.getStackTrace()));  
                }
            }
            
            if (customerName.length() > 0 && !orderTable.isEmpty()) {
                orderTable.put(fruit, buyQuantity);
                orders.add(new Order(customerName.toString(), orderTable));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
        return orders;
    }
    
    public void writeOrdersIntoFile(ArrayList<Order> orders) {
        try (PrintWriter pr = new PrintWriter(path + ordersPath);) {
            for (Order order: orders) {
                String customerName = order.getCustomerName();
                HashMap<Fruit, Integer> fruitOrder = order.getCustomerorder();
                pr.println(customerName);
                for (Fruit fruit : fruitOrder.keySet()) {
                    pr.println(fruitOrder.get(fruit) + "-" + fruit.toOrderFileString());
                }
            }
            pr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private static int getBuyQuantityLength(String line) {
        int count = 0;
        
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                count++;
                continue;
            }
            break;
        }
        
        return count;
    }
}
