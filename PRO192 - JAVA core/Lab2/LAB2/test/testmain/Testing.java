/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testmain;

//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Scanner;
import lab2.*;
import static lab2.Test.*;

/**
 *
 * @author hoang
 */
public class Testing {

    

    public static void main(String[] args) {
        Person a = new Person(1, "Minh Nguyen", true);
        Person b = new Person(2, "Minh An", true);
        Person c = new Person(3, "An Binh", true);
        Person d = new Person(4, "Binh An", true);

//        Person a = new Person(1, "Nguyen Van A", true);
//        Person b = new Person(2, "ta van P", true);
//        Person c = new Person(3, "tran ba G", true);
//        Person d = new Person(4, "cai gi the J", true);
        Person[] ps_arr = new Person[4];
        ps_arr[0] = a;
        ps_arr[1] = b;
        ps_arr[2] = c;
        ps_arr[3] = d;
        
//        sortByName(ps_arr);
        
        
        
        String search_name = "Nguyen";
        System.out.println("Seach person: " + search_name);
        Person[] searched = searchByName(ps_arr, search_name);
        for (Person ps : searched) {
            printInfo(ps);
        }
    }
    
    
//    private static void sortByName(Person[] people) {
//        int n = people.length;
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - i - 1; j++) {
//                String[] split_j = people[j].getName().split(" ");
//                String[] split_j_plus_1 = people[j + 1].getName().split(" ");
//                if (split_j[split_j.length - 1].compareTo(split_j_plus_1[split_j_plus_1.length - 1]) > 0) {
//                    // Swap the values of two elements
//                    Person temp = people[j];
//                    people[j] = people[j + 1];
//                    people[j + 1] = temp;
//                }
//            }
//        }
//    }
    
    private static Person[] searchByName(Person[] people, String search_name) {
        Person[] temp = new Person[people.length];
        int count = 0;
        for (int i = 0; i < people.length; i++) {
            Person ps = people[i];
            String[] splitName = ps.getName().split(" ");
            if (splitName[splitName.length - 1].compareToIgnoreCase(search_name) == 0) {
                temp[count] = ps;
                count++;
            }
        }
        Person[] result = Arrays.copyOf(temp, count);
        return result;
    }

//    private static void sortByName(ArrayList<Person> person_list) {
//        for (int i = 0; i < person_list.size() - 1; i++) {
//            for (int j = i + 1; j < person_list.size(); j++) {
//                Person ps1 = person_list.get(i);
//                Person ps2 = person_list.get(j);
//                
//                String[] split_ps_1 = ps1.getName().split(" ");
//                String[] split_ps_2 = ps2.getName().split(" ");
//                // Compare the names 
//                int comparisonResult = ps1.getName().compareTo(ps2.getName());
//
//                // Swap
//                if (comparisonResult > 0) {
//                    person_list.set(i, ps2);
//                    person_list.set(j, ps1);
//                }
//            }
//        }
    }
   

//    private static int searchByName(ArrayList<Person> person_list, String search_name) {  // Specify type of ArrayList is Person to prevent error
//        for (int i = 0; i < person_list.size(); i++) {
//            Person per = person_list.get(i);
//
//            if (per.getName().compareTo(search_name) == 0) {
//                return i;
//            }
//        }
//        return -1;
//    }

