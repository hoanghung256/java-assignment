/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainpackage;

/**
 *
 * @author hoang
 */
public class Lession1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        OfficialEmployee a = new OfficialEmployee("001", "Nguyen", "A", 20, "25/06", 30, 10);
        PartTimeEmployee b = new PartTimeEmployee("002", "Nguyen", "B", 20, "25/06", 30);
        System.out.println("");
        a.toString();
        b.toString();
    }
    
}
