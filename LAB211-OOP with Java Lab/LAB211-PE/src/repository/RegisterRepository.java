package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TreeSet;

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
     * TreeSet using for keep the order by date of registers
     */
    private TreeSet<Meeting> meetings;
    private TreeSet<Work> works;
    private TreeSet<Vacation> vacations;
    private TreeSet<Study> studies;

    /**
     * The last index of register in file
     * Use for generate a new register ID
     */
    private int registerIndex;

    private RegisterRepository() {
        registerIndex = 0;
        meetings = new TreeSet<>();
        works = new TreeSet<>();
        vacations = new TreeSet<>();
        studies = new TreeSet<>();
        this.readRegisters();
    }

    public static RegisterRepository getInstance() {
        if (instance == null) {
            instance = new RegisterRepository();
        }
        return instance;
    }

    public TreeSet<Meeting> getMeetingRegisters() {
        return meetings;
    }

    public TreeSet<Work> getWorkRegisters() {
        return works;
    }

    public TreeSet<Vacation> getVacationRegisters() {
        return vacations;
    }

    public TreeSet<Study> getStudyRegisters() {
        return studies;
    }

    public int getRegisterIndex() {
        return registerIndex;
    }

    public void increaseRegisterIndex() {
        this.registerIndex += 1;
    }

    private void readRegisters() {
        String line;

        try (BufferedReader input = new BufferedReader(new FileReader(srcPath + registerPath))) {
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(";");
                Register register = this.clarifyRegisterType(attributes);
                this.putRegisterByType(register);
                registerIndex++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    private void putRegisterByType(Register register) {
        if (register instanceof Meeting) {
            Meeting meeting = (Meeting) register;
            meetings.add(meeting);
        } else if (register instanceof Work) {
            Work work = (Work) register;
            works.add(work);
        } else if (register instanceof Vacation) {
            Vacation vaca = (Vacation) register;
            vacations.add(vaca);
        } else if (register instanceof Study) {
            Study study = (Study) register;
            studies.add(study);
        }
    }
}
