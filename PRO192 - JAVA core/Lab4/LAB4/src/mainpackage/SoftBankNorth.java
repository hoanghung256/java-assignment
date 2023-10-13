/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;

/**
 *
 * @author hoang
 */
public class SoftBankNorth extends SoftBank {
    private final double salary_coeficient = 2;

    public SoftBankNorth() {
    }

    public SoftBankNorth(String id, String name, String founding_day, String address, int juniors, int seniors) {
        super(id, name, founding_day, address, juniors, seniors);
    }
    
    public double getContingencyCost() {
        return (this.getSeniors() * 5000  + this.getJuniors() * 2000) * salary_coeficient;
    }
    
    public double getActualCost() {
        return this.getContingencyCost();
    }
    
    public double getJuniorSalary() {
        return 2000 * salary_coeficient * this.getJuniors();
    }
    
    public double getSeniorSalary() {
        return 5000 * salary_coeficient * this.getSeniors();
    }

    @Override
    public void scanInfo() {
        System.out.println("Scanning North branch...");
        super.scanInfo(); 
    }
}
