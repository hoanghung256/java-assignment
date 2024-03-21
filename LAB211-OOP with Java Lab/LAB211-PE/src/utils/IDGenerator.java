package utils;

/**
 * @author hoang hung
 */
public class IDGenerator {
    public static String generate(String type, int previousId) {
        return type + "-" + String.format("%03d", previousId + 1);
    }
}
