/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import database.FileManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;

/**
 *
 * @author hoang
 */
public class FruitManager {
    private final FileManager db;
    private ArrayList<Fruit> fruits;
    
    public FruitManager() {
        db = new FileManager();
    }
    
    public void addNewFruit(String name, int price, int quantity, String origin) {
        Fruit previousFruit = fruits.get(fruits.size() - 1);
        fruits.add(new Fruit(previousFruit.getId() + 1, name, price, quantity, origin));
        db.writeFruitsIntoFile(fruits);
    }
    
    public void displayAllFruit() {
        fruits = db.readFruitsFromFile();
        String leftAlignFormat = "| %-3s | %-12s | %-8s | %-6s |%n";

        System.out.format("+-----+--------------+----------+--------+%n");
        System.out.format("| ID  | Fruit Name   | Origin   | Price  |%n");
        System.out.format("+-----+--------------+----------+--------+%n");

        fruits.forEach(fruit -> System.out.format(leftAlignFormat, fruit.getId(), fruit.getName(), fruit.getOrigin(), fruit.getPrice()));

        System.out.format("+-----+--------------+----------+--------+%n");
    }
       
    public Fruit searchByCriteria(Predicate<Fruit> criteria) {
        Fruit fruit = new Fruit();
        for (Fruit f : fruits) {
            if (criteria.test(f)) {
                fruit = f;
                break;
            }
        }
        return fruit;
    }
    
    public void updateFruitsQuantity(HashMap<Fruit, Integer> order) {
//        for (int i = 0; i < fruits.size(); i++) {
//            if (fruits.get(i).equals(updateFruit)) {
//                if (fruits.get(i).getQuantity() - buyQuantity == 0) {
//                    fruits.remove(i);
//                    break;
//                } else {
//                    fruits.get(i).setQuantity(fruits.get(i).getQuantity() - buyQuantity);
//                    break;
//                }
//            }
//        }
//
        for (Fruit f : order.keySet()) {
            for (int i = 0; i < fruits.size(); i++) {
                Fruit fruit = fruits.get(i);
                if (fruit.equals(f)) {
                    if (fruit.getQuantity() == order.get(f)) {
                        fruits.remove(i);
                    } else {
                        fruit.setQuantity(fruit.getQuantity() - order.get(f));
                    }
                    break;
                }
            }
        }
        
        db.writeFruitsIntoFile(fruits);
    }
    
    public void writeFruitsIntoFile() {
        if (fruits != null) {
            db.writeFruitsIntoFile(fruits);
        }
    }
}
