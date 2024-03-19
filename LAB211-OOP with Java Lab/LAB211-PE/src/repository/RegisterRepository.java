package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import models.MeetingDetail;
import models.Register;

public class RegisterRepository {
    private final String srcPath = new File("src").getAbsolutePath();
    private final String registerPath = "\\data\\registers.txt";
    HashMap<String, Register> registers;

    public HashMap<String, Register> getRegisters() {
        if (registers == null) {
            registers = this.
        }
        return registers;
    }

    private HashMap<String, Register> readRegisters() {
        String line;
        try (BufferedReader input = new BufferedReader(new FileReader(srcPath + registerPath))) {
            registers = new HashMap<>();
            while((line = input.readLine())!= null){
                String[] attributes = line.split(";");
                MeetingDetail detail = new MeetingDetail(attributes[0], attributes[1], attributes[2], attributes[3]);     
                registers.put(detail);
            }
            return registers;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
