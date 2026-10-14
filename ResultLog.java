import java.util.ArrayList;
import java.util.List;

/** Stores every search / traversal / performance result so menu option 8 can show them all. */
public final class ResultLog {
    private static final List<String> ENTRIES = new ArrayList<>();

    private ResultLog() { }

    public static void add(String category, String text) {
        ENTRIES.add(String.format("%-12s | %s", category, text));
    }

    public static void display() {
        System.out.println("\n=============================================");
        System.out.println("ALL RECORDED RESULTS");
        System.out.println("=============================================");
        if (ENTRIES.isEmpty()) {
            System.out.println("No results recorded yet. Run a search, graph traversal or performance test first.");
        } else {
            for (int i = 0; i < ENTRIES.size(); i++) {
                System.out.printf("%3d. %s%n", i + 1, ENTRIES.get(i));
            }
        }
        System.out.println("=============================================");
    }
}
