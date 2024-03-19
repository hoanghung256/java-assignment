package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

import models.Meeting;
import models.Register;
import models.Study;
import models.Vacation;
import models.Work;

public class RegisterRepository {
    private static RegisterRepository instance;
    private final String srcPath = new File("src").getAbsolutePath();
    private final String registerPath = "\\data\\registers.txt";
    /**
     * A mapping of specify Register object IDs to its Register objects.
     * <p>
     * The key is a String representing the type ID,
     * and the value is a Register object containing details of the register.
     */
    HashMap<String, Register> registers;

    private RegisterRepository() {
    }

    public static RegisterRepository getInstance() {
        if (instance == null) {
            instance = new RegisterRepository();
        }
        return instance;
    }

    public HashMap<String, Register> getRegisters() {
        if (registers == null) {
            registers = this.readRegisters();
        }
        return registers;
    }

    private HashMap<String, Register> readRegisters() {
        String line;
        registers = new HashMap<>();

        try (BufferedReader input = new BufferedReader(new FileReader(srcPath + registerPath))) {
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(";");
                Register register = this.clarifyRegisterType(attributes);
                registers.put(attributes[0], register);
            }
            return registers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Register clarifyRegisterType(String[] attributes) {
        Register register = null;
        String type = attributes[0].split("-")[0];
        if (type.equals("VA")) {
            register = new Vacation(attributes[0],
                    attributes[1],
                    attributes[2],
                    LocalDate.parse(attributes[3]),
                    attributes[4],
                    LocalDate.parse(attributes[5]),
                    LocalDate.parse(attributes[6]),
                    LocalTime.parse(attributes[7]),
                    LocalTime.parse(attributes[8]),
                    attributes[9],
                    Integer.parseInt(attributes[10]));
        } else if (type.equals("MT")) {
            register = new Meeting(attributes[0],
                    attributes[1],
                    attributes[2],
                    LocalDate.parse(attributes[3]),
                    attributes[4],
                    LocalDate.parse(attributes[5]),
                    LocalDate.parse(attributes[6]),
                    LocalTime.parse(attributes[7]),
                    LocalTime.parse(attributes[8]),
                    attributes[9]);
        } else if (type.equals("ST")) {
            register = new Study(attributes[0],
                    attributes[1],
                    attributes[2],
                    LocalDate.parse(attributes[3]),
                    attributes[4],
                    LocalDate.parse(attributes[5]),
                    LocalDate.parse(attributes[6]),
                    LocalTime.parse(attributes[7]),
                    LocalTime.parse(attributes[8]),
                    attributes[9]);
        } else if (type.equals("W")) {
            register = new Work(attributes[0],
                    attributes[1],
                    attributes[2],
                    LocalDate.parse(attributes[3]),
                    attributes[4],
                    LocalDate.parse(attributes[5]),
                    LocalDate.parse(attributes[6]),
                    LocalTime.parse(attributes[7]),
                    LocalTime.parse(attributes[8]),
                    attributes[9],
                    attributes[10]);
        }

        return register;
    }
}
