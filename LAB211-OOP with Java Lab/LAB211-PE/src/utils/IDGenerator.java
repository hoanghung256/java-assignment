package utils;

public class IDGenerator {
    public static String generate(String type, int previousId) {
        return type + "-" + (++previousId);
    }
}
