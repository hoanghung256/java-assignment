package mainpackage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author hoang
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ITStudent a = new ITStudent("Hoang Hung", "Da Nang", 19, 7, 6);
        BizStudent b = new BizStudent("Nguyen A", "Da Nang", 19, 9, 10);
        
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
    
}
