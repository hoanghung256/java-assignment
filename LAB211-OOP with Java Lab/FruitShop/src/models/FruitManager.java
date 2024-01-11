/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import database.FileManager;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author hoang
 */
public class FruitManager {
    private static FileManager db = new FileManager();
    private static ArrayList<Fruit> fruits;
    private static OrderManager orderManager = new OrderManager();
    
    public FruitManager() {
        fruits = db.readFruitsFromFile();
    }
    
    public void addNewFruit(Fruit fruit) {
        fruit.setId(fruits.size() + 1);
        fruits.add(fruit);
        db.writeFruitsIntoFile(fruits);
    }
    
    public void displayAllFruit() {
        String leftAlignFormat = "| %-3s | %-12s | %-8s | %-6s | %-7s |%n";

        System.out.format("+-----+--------------+----------+--------+---------+%n");
        System.out.format("| ID  | Fruit Name   | Origin   | Price  | Remain  |%n");
        System.out.format("+-----+--------------+----------+--------+---------+%n");

        fruits.forEach(fruit -> System.out.format(leftAlignFormat, fruit.getId(), fruit.getName(), fruit.getOrigin(), fruit.getPrice(), fruit.getQuantity()));

        System.out.format("+-----+--------------+----------+--------+---------+%n");
    }
       
    public Fruit searchByCriteria(Predicate<Fruit> criteria) {
        for (Fruit fruit : fruits) {
            if (criteria.test(fruit)) {
                return fruit; 
            }
        }
        return null;
    }
    
    public boolean updateFruitsQuantity(Fruit updateFruit, int buyQuantity) {
        for (Fruit fruit : fruits) {
            if (fruit.equals(updateFruit)) {
                if (fruit.getQuantity() - buyQuantity == 0) {
                    fruits.remove(fruit);
                } else {
                    fruit.setQuantity(fruit.getQuantity() - buyQuantity );
                    return true;
                }
            }
        }
        return false;
    }
    
    public void writeFruitsIntoFile() {
        db.writeFruitsIntoFile(fruits);
    }
}
