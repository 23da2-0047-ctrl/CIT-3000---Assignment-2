import java.util.Scanner;

/**
 * Centralised, validated console input.
 * Every read loops until the user supplies valid data, so the rest of
 * the program never has to deal with NumberFormatException or empty input.
 */
public final class InputHelper {
    private static final Scanner SC = new Scanner(System.in);

    private InputHelper() { }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        if (!SC.hasNextLine()) {                 // stdin closed (Ctrl+D / piped input ended)
            System.out.println("\nInput closed. Exiting program.");
            System.exit(0);
        }
        return SC.nextLine().trim();
    }

    /** Reads any whole number. */
    public static int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readLine(prompt));
            } catch (NumberFormatException e) {
                System.out.println("  ! Invalid input. Please enter a whole number.");
            }
        }
    }

    /** Reads a whole number within [min, max]. */
    public static int readInt(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("  ! Please enter a number between " + min + " and " + max + ".");
        }
    }

    /** Reads a non-empty string. */
    public static String readNonEmpty(String prompt) {
        while (true) {
            String s = readLine(prompt);
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("  ! Input cannot be empty.");
        }
    }

    /** Reads y/n. */
    public static boolean readYesNo(String prompt) {
        while (true) {
            String s = readLine(prompt + " (y/n): ").toLowerCase();
            if (s.equals("y") || s.equals("yes")) return true;
            if (s.equals("n") || s.equals("no")) return false;
            System.out.println("  ! Please type y or n.");
        }
    }
}
