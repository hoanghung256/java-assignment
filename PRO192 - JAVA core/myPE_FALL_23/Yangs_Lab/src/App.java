
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author hoang
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ConsoleForm consoleForm = new ConsoleForm();
        int choice;
        do {
            consoleForm.displayMenu();
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    try {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("1. Create item:");
                consoleForm.createNew();
                break;
                case 2:
                    try {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("2. View item");
                consoleForm.display();
                break;
                case 3:
                    try {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("3. Search item");
                consoleForm.searchItem();
                break;
                case 4:
                    try {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("Exit");
                break;
            }
        } while (choice != 4);
        sc.close();
    }
}
