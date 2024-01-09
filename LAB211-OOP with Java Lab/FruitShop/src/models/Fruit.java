/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author hoang
 */
public class Fruit {
    private int Id;
    private String name;
    private int price;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    
    public Fruit(int Id, String name, int price, int quantity, String origin) {
        this.Id = Id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public Fruit(String name, int price, int quantity, String origin) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

//    @Override
//    public String toString() {
////        return "   " + Id + "       " + name + "        " + origin + "        " + price + "$        " + quantity + "";
//          
//    }

    @Override
    public String toString() {
        return "Fruit{" + "Id=" + Id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", origin=" + origin + '}';
    }
    
    public String toFruitFileString() {
        return Id + "," + name + "," + price + "," + quantity + "," + origin;
    }
    
    public String toOrderFileString() {
        return name + "," + price;
    }
}
