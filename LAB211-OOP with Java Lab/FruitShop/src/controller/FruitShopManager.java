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
    private static Validation validator = new Validation();
    private static final String menuTitle = "FRUIT SHOP SYSTEM";
    private static final String[] menuOptions = { "Create Fruit", "View order", "Shopping", "Display all fruits", "Exit" };

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
        String name = validator.getAndValidString("Enter name: ");
        int price = validator.getAndValidInt("Enter price: ");
        int quantity = validator.getAndValidInt("Enter quantity: ");
        String origin = validator.getAndValidString("Enter origin: ");
        
        Fruit newFruit = new Fruit(name, price, quantity, origin);
        fruitManager.addNewFruit(newFruit);
    }

    private static void displayAllOrders() {
        orderManager.displayAllOrders();
    }

    private static void shopping() {
        HashMap<Fruit, Integer> order = orderManager.getCurrentOrder();
        OrderManager.displayOrder(order);

        String customerName = validator.getAndValidString("Input your name: ");

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
