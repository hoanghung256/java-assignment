package utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import services.StaffService;

/**
 * @author hoang hung
 */
public class Validation {
    public static String getValue(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        return sc.nextLine();
    }

    public static int getInt(String msg) {
        while (true) {
            String value = getValue(msg);
            try {
                int parsed = Integer.parseInt(value);
                if (parsed < 0) {
                    System.out.println("Number input must greater than 0!");
                    continue;
                }
                return parsed;
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format!");
                continue;
            }
        }
    }

    public static LocalDate parseLocalDate(String localDate) {
        try {
            LocalDate date = LocalDate.parse(localDate);
            return date;
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * @param command   0 for get start date, 1 for get end date
     * @param startDate parameter following command 1, check if endDate if after
     *                  startDate
     */
    public static LocalDate getDate(int command, LocalDate startDate, String msg) {
        LocalDate date = null;

        if (command == 0) {
            try {
                String dateStr = getValue(msg);
                date = LocalDate.parse(dateStr);
            } catch (DateTimeParseException e) {
                return null;
            }
        } else if (command == 1) {
            while (true) {
                try {
                    String dateStr = getValue(msg);
                    date = LocalDate.parse(dateStr);
                    if (date.isBefore(startDate)) {
                        System.out.println("End date must after start date!");
                        continue;
                    }
                } catch (DateTimeParseException e) {
                    return null;
                }
            }
        }

        return date;
    }

    /**
     * @param command   0 for get start time, 1 for get end time
     * @param startTime parameter following command 1, check if endTime if after
     *                  startTime
     */
    public static LocalTime getTime(int command, LocalTime startTime, String msg) {
        LocalTime time = null;
        if (command == 0) {
            try {
                String timeStr = getValue(msg);
                time = LocalTime.parse(timeStr);
                return time;
            } catch (DateTimeParseException e) {
                return null;
            }
        } else if (command == 1) {
            while (true) {
                try {
                    String timeStr = getValue(msg);
                    time = LocalTime.parse(timeStr);
                    if (time.isBefore(startTime)) {
                        System.out.println("End time must after start time!");
                        continue;
                    }
                    break;
                } catch (DateTimeParseException e) {
                    return null;
                }
            }
        }
        return time;
    }

    /**
     * @param command 1 is for get exists ID and 0 is for not exists
     * @return staff ID after validate
     */
    public static String getAndValidateStaffId(int command, String msg) {
        String id = null;
        if (command == 1) {
            while (true) {
                id = getValue(msg);
                if (StaffService.getInstance().findById(id) == null) {
                    System.out.println("Staff not exists!");
                    continue;
                }
                break;
            }
        } else if (command == 0) {
            while (true) {
                id = getValue(msg);
                if (StaffService.getInstance().findById(id) != null) {
                    System.out.println("Staff ID exists!");
                    continue;
                }
                break;
            }
        }
        return id;
    }

    public static String getAndValidateStaffName(String msg) {
        String name = null;
        while (true) {
            name = getValue(msg);
            if (StaffService.getInstance().findByName(name) == null) {
                System.out.println("Staff not exists!");
                continue;
            }
            break;
        }
        return name;
    }
}
