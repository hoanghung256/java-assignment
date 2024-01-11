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
    private final FileManager db;
    private ArrayList<Fruit> fruits;
    
    public FruitManager() {
        db = new FileManager();
    }
    
    public void addNewFruit(Fruit fruit) {
        fruit.setId(fruits.size() + 1);
        fruits.add(fruit);
        db.writeFruitsIntoFile(fruits);
    }
    
    public void displayAllFruit() {
        fruits = db.readFruitsFromFile();
        String leftAlignFormat = "| %-3s | %-12s | %-8s | %-6s | %-7s |%n";

        System.out.format("+-----+--------------+----------+--------+---------+%n");
        System.out.format("| ID  | Fruit Name   | Origin   | Price  | Remain  |%n");
        System.out.format("+-----+--------------+----------+--------+---------+%n");

        fruits.forEach(fruit -> System.out.format(leftAlignFormat, fruit.getId(), fruit.getName(), fruit.getOrigin(), fruit.getPrice(), fruit.getQuantity()));

        System.out.format("+-----+--------------+----------+--------+---------+%n");
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
    
    public void updateFruitsQuantity(Fruit updateFruit, int buyQuantity) {
        int i = 0;
        
        for (; i < fruits.size(); i++) {
            if (fruits.get(i).equals(updateFruit)) {
                if (fruits.get(i).getQuantity() - buyQuantity == 0) {
                    fruits.remove(i);
                    break;
                } else {
                    System.out.println(fruits.get(i).getQuantity() - buyQuantity);
                    fruits.get(i).setQuantity(fruits.get(i).getQuantity() - buyQuantity);
                    System.out.println(fruits.get(i).getQuantity());
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
