/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignmentprj.ex1lab;

import java.util.ArrayList;

/**
 *
 * @author gamek
 */
public class ItemList {
    ArrayList<Item> itemList = new ArrayList<>();

    public ItemList() {
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }
    
    public void addItem(Item item){
    itemList.add(item);
    }
}
