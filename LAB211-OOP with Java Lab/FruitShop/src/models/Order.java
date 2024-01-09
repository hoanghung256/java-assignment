/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.HashMap;

/**
 *
 * @author hoang
 */
public class Order {
    private String customerName;
    private HashMap<Fruit, Integer> customerorder;

    public Order(String customerName, HashMap<Fruit, Integer> customerorder) {
        this.customerName = customerName;
        this.customerorder = customerorder;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<Fruit, Integer> getCustomerorder() {
        return customerorder;
    }

    public void setCustomerorder(HashMap<Fruit, Integer> customerorder) {
        this.customerorder = customerorder;
    }

    @Override
    public String toString() {
        return "Order{" + "customerName=" + customerName + ", customerorder=" + customerorder + '}';
    }
}
