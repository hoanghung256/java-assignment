//package models;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import views.Validation;
//
//public class FileManager {
//    Product p = new Product();
//    ArrayList<Fruit> listOfFruit = p.getList();
//
//    private static final File FILE = new File("src");
//    private static final String PATH = FILE.getAbsolutePath();
//    private static final String FILE_NAME = "\\models\\Fruit.txt";
//
//    Validation val = new Validation();
//
//    //Load data
//    public void loadData(){
//        String std = "";
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(PATH + FILE_NAME));
//            br.close();
//        } catch (IOException io) {
//            System.out.println(io.getMessage());
//        }
//    }
//
//    //Save data
//    public void saveData() {
//        File file = new File(PATH + FILE_NAME);
//        try {
//            PrintWriter pw = new PrintWriter(file);
//            for (Fruit fruit : listOfFruit) {
//                pw.println(fruit.getFruitID() +  fruit.getFruitName() 
//                        + fruit.getOrigin() +  fruit.getPrice() +  fruit.getQuantity());
//            }
//            pw.close();
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//}
