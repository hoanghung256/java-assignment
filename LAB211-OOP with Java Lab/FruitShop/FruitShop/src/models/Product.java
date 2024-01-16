package models;

import java.util.ArrayList;
import java.util.Scanner;
import views.Validation;
//import models.FileManager;

public class Product {

    ArrayList<Fruit> listOfFruit = new ArrayList<>();
    Validation val = new Validation();
    
//    FileManager file = new FileManager();

    public Product() {
    }

    public void createFruit() {
        while (true) {
            Scanner input = new Scanner(System.in);;
            int fruitID = listOfFruit.size() + 1;
            System.out.printf("Enter fruit ID: " ,fruitID);
            val.getValue("");
            String fruitName = val.getAndValidValue("Enter fruit name: ", "[\\pL]+", "Invalid fruit name".toUpperCase());
            double price = val.getAndValidMoney("Enter fruit price: ");
            int quantity = val.getAndValidQuantity("Enter fruit quantity: ");
            String origin = val.getValue("Enter fruit origin: ");
            Fruit f = new Fruit(fruitID, fruitName,origin , price, quantity);
            listOfFruit.add(f);
            System.out.println("Create Successfully!\n");
//            file.saveData();
            if (!val.askToCheck()) {
                showFruit();
                return;
            }
        }
    }

    public void showFruit() {
        System.out.print("|    ID    |    Fruit   |    Origin   |    Price    |    Quantity    |\n");
        display();
    }
    
    public void display(){
//        file.loadData();
        for (Fruit f : listOfFruit) {
            System.out.print(f);
        }
        if (listOfFruit.isEmpty()) {
            System.out.println("Not found data");
        }
    }
    
    public ArrayList<Fruit> getList(){
        return listOfFruit;
    }
}
