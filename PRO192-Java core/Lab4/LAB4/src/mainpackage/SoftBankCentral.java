/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class SoftBankCentral extends SoftBank {
    private int contributors;
    private final double salary_coeficient = 1.5;

    public SoftBankCentral() {
    }

    public SoftBankCentral(String id, String name, String founding_day, String address, int juniors, int seniors, int contributors) {
        super(id, name, founding_day, address, juniors, seniors);
        this.contributors = contributors;
    }
    
    public double getContingencyCost() {
        return (this.getSeniors() * 5000  + this.getJuniors() * 2000) * salary_coeficient;
    }
    
    public double getActualCost() {
        return this.getContingencyCost() + contributors * 1000;
    }
    
    public double getJuniorSalary() {
        return 2000 * salary_coeficient * this.getJuniors();
    }
    
    public double getSeniorSalary() {
        return 5000 * salary_coeficient * this.getSeniors();
    }

    @Override
    public void scanInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Scanning Central branch...");
        super.scanInfo(); 
        System.out.print("Enter number of contributor: ");
        this.contributors = sc.nextInt();
    }

    
}
