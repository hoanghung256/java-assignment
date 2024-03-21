package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import models.MeetingDetail;

/**
 * @author hoang hung
 */
public class MeetingDetailRepository {
    private static MeetingDetailRepository instance;
    private final String srcPath = new File("src").getAbsolutePath();
    final String meetingDetailPath = "\\data\\meeting-detail.txt";
    private ArrayList<MeetingDetail> details;

    private MeetingDetailRepository() {
    }

    public static MeetingDetailRepository getInstance() {
        if (instance == null) {
            instance = new MeetingDetailRepository();
        }
        return instance;
    }

    public ArrayList<MeetingDetail> getMeetingDetails() {
        if (details == null) {
            details = readMeetingDetails();
        }
        return details;
    }

    private ArrayList<MeetingDetail> readMeetingDetails() {
        String line;
        details = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader(srcPath + meetingDetailPath))) {
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(";");
                
                details.add(new MeetingDetail(attributes[0], attributes[1], attributes[2], attributes[3]));
            }
            return details;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
