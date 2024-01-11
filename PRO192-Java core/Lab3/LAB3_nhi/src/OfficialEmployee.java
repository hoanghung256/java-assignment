/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

/**
 *
 * @author ASUS
 */
public class OfficialEmployee extends Employee{
    private int OTtime;
    
    public OfficialEmployee(int ID, String fullName, int age, String birthday, int workDay, double salary, int OTtime) {
        super(ID, fullName, age, birthday, workDay, salary);
        this.OTtime = OTtime;

    }

    public double getOTtime() {
        return OTtime;
    }

    public void setOTtime(int OTtime) {
        this.OTtime = OTtime;
    }
    
    
    @Override
    public double calculateSalary(){
      return (int) (getWorkDay()*1000000*OTtime*100000);
    }
    
    @Override
    public String toString() {
        return "OfficialEmployee:\n" +super.toString()+ "OT Time=" + OTtime;
    }
}
