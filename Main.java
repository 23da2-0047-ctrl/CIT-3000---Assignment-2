import java.util.List;
import java.util.Random;

/**
 * DATA STRUCTURE & GRAPH PERFORMANCE ANALYZER
 * CIT300 Graded Practical Assignment 2 - console menu and integration.
 */
public class Main {

    // One shared instance of each structure for the whole session
    private static final ArrayOperations ARRAY = new ArrayOperations();
    private static final MyStack<Integer> STACK = new MyStack<>();
    private static final MyQueue<Integer> QUEUE = new MyQueue<>();
    private static final MyLinkedList LIST = new MyLinkedList();
    private static final Graph GRAPH = new Graph();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=============================================");
            System.out.println("DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            switch (InputHelper.readInt("Enter your choice: ", 1, 9)) {
                case 1 -> arrayMenu();
                case 2 -> stackMenu();
                case 3 -> queueMenu();
                case 4 -> listMenu();
                case 5 -> searchMenu();
                case 6 -> graphMenu();
                case 7 -> performanceMenu();
                case 8 -> ResultLog.display();
                case 9 -> { running = false; System.out.println("Goodbye!"); }
            }
        }
    }

    // ------------------------------------------------------------------ ARRAY
    private static void arrayMenu() {
        while (true) {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert at End");
            System.out.println("2. Insert at Index");
            System.out.println("3. Delete by Index");
            System.out.println("4. Delete by Value");
            System.out.println("5. Search for Value");
            System.out.println("6. Sort Array");
            System.out.println("7. Fill with Random Numbers");
            System.out.println("8. Display Array");
            System.out.println("9. Return to Main Menu");
            try {
                switch (InputHelper.readInt("Enter your choice: ", 1, 9)) {
                    case 1 -> {
                        ARRAY.insertAtEnd(InputHelper.readInt("Value: "));
                        System.out.println("Inserted.");
                    }
                    case 2 -> {
                        int idx = InputHelper.readInt("Index (0-" + ARRAY.size() + "): ");
                        int shifts = ARRAY.insertAt(idx, InputHelper.readInt("Value: "));
                        System.out.println("Inserted. Elements shifted: " + shifts);
                    }
                    case 3 -> {
                        if (ARRAY.isEmpty()) throw new IllegalStateException("Array is empty. Nothing to delete.");
                        int removed = ARRAY.deleteAt(InputHelper.readInt("Index (0-" + (ARRAY.size() - 1) + "): "));
                        System.out.println("Deleted value " + removed);
                    }
                    case 4 -> {
                        if (ARRAY.isEmpty()) throw new IllegalStateException("Array is empty. Nothing to delete.");
                        int idx = ARRAY.indexOf(InputHelper.readInt("Value to delete: "));
                        if (idx < 0) System.out.println("Value not found.");
                        else System.out.println("Deleted value " + ARRAY.deleteAt(idx));
                    }
                    case 5 -> {
                        if (ARRAY.isEmpty()) throw new IllegalStateException("Array is empty. Nothing to search.");
                        int key = InputHelper.readInt("Value to search: ");
                        int idx = ARRAY.indexOf(key);
                        System.out.println(idx < 0 ? "Value not found." : "Found at index " + idx);
                    }
                    case 6 -> { ARRAY.sort(); System.out.println("Array sorted (ascending)."); }
                    case 7 -> {
                        int count = InputHelper.readInt("How many numbers (1-1000)? ", 1, 1000);
                        Random rnd = new Random();
                        for (int i = 0; i < count; i++) ARRAY.insertAtEnd(rnd.nextInt(1000));
                        System.out.println(count + " random numbers added.");
                    }
                    case 8 -> ARRAY.display();
                    case 9 -> { return; }
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("  ! " + e.getMessage());
            }
        }
    }

    // ------------------------------------------------------------------ STACK
    private static void stackMenu() {
        while (true) {
            System.out.println("\n--------------- STACK OPERATIONS (LIFO) ---------------");
            System.out.println("1. Push\n2. Pop\n3. Peek\n4. Display\n5. Return to Main Menu");
            try {
                switch (InputHelper.readInt("Enter your choice: ", 1, 5)) {
                    case 1 -> { STACK.push(InputHelper.readInt("Value to push: ")); System.out.println("Pushed."); }
                    case 2 -> System.out.println("Popped: " + STACK.pop());
                    case 3 -> System.out.println("Top element: " + STACK.peek());
                    case 4 -> STACK.display();
                    case 5 -> { return; }
                }
            } catch (IllegalStateException e) {
                System.out.println("  ! " + e.getMessage());
            }
        }
    }

    // ------------------------------------------------------------------ QUEUE
    private static void queueMenu() {
        while (true) {
            System.out.println("\n--------------- QUEUE OPERATIONS (FIFO) ---------------");
            System.out.println("1. Enqueue\n2. Dequeue\n3. Peek / Front\n4. Display\n5. Return to Main Menu");
            try {
                switch (InputHelper.readInt("Enter your choice: ", 1, 5)) {
                    case 1 -> { QUEUE.enqueue(InputHelper.readInt("Value to enqueue: ")); System.out.println("Enqueued."); }
                    case 2 -> System.out.println("Dequeued: " + QUEUE.dequeue());
                    case 3 -> System.out.println("Front element: " + QUEUE.peek());
                    case 4 -> QUEUE.display();
                    case 5 -> { return; }
                }
            } catch (IllegalStateException e) {
                System.out.println("  ! " + e.getMessage());
            }
        }
    }

    // ------------------------------------------------------------ LINKED LIST
    private static void listMenu() {
        while (true) {
            System.out.println("\n--------------- LINKED LIST OPERATIONS ---------------");
            System.out.println("1. Insert at Head");
            System.out.println("2. Insert at Tail");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete by Value");
            System.out.println("5. Search for Value");
            System.out.println("6. Display List");
            System.out.println("7. Return to Main Menu");
            try {
                switch (InputHelper.readInt("Enter your choice: ", 1, 7)) {
                    case 1 -> { LIST.insertAtHead(InputHelper.readInt("Value: ")); System.out.println("Inserted at head."); }
                    case 2 -> { LIST.insertAtTail(InputHelper.readInt("Value: ")); System.out.println("Inserted at tail."); }
                    case 3 -> {
                        int pos = InputHelper.readInt("Position (0-" + LIST.size() + "): ");
                        LIST.insertAt(pos, InputHelper.readInt("Value: "));
                        System.out.println("Inserted.");
                    }
                    case 4 -> System.out.println(LIST.deleteValue(InputHelper.readInt("Value to delete: "))
                            ? "Deleted." : "Value not found.");
                    case 5 -> {
                        if (LIST.isEmpty()) throw new IllegalStateException("List is empty. Nothing to search.");
                        int pos = LIST.search(InputHelper.readInt("Value to search: "));
                        System.out.println(pos < 0 ? "Value not found." : "Found at position " + pos);
                    }
                    case 6 -> LIST.display();
                    case 7 -> { return; }
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("  ! " + e.getMessage());
            }
        }
    }

    // -------------------------------------------------------------- SEARCHING
    private static void searchMenu() {
        while (true) {
            System.out.println("\n--------------- SEARCHING OPERATIONS ---------------");
            System.out.println("(Searches the array from the Array menu)");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Compare Linear vs Binary");
            System.out.println("4. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 4);
            if (choice == 4) return;
            if (ARRAY.isEmpty()) {
                System.out.println("  ! Array is empty. Add data in the Array menu first (option 7 fills random numbers).");
                continue;
            }
            int key = InputHelper.readInt("Value to search: ");
            if (choice != 1 && !ARRAY.isSorted()) {
                if (InputHelper.readYesNo("Binary search needs a sorted array. Sort it now?")) {
                    ARRAY.sort();
                    System.out.println("Array sorted.");
                } else {
                    System.out.println("Binary search cancelled.");
                    if (choice == 2) continue;
                    choice = 1;       // comparison not possible - fall back to linear only
                }
            }
            int[] snapshot = ARRAY.toArray();
            if (choice == 1 || choice == 3) {
                SearchOperations.SearchResult r = SearchOperations.linearSearch(snapshot, key);
                printSearch("Linear Search", r, key);
            }
            if (choice == 2 || choice == 3) {
                SearchOperations.SearchResult r = SearchOperations.binarySearch(snapshot, key);
                printSearch("Binary Search", r, key);
            }
        }
    }

    private static void printSearch(String name, SearchOperations.SearchResult r, int key) {
        String outcome = r.index() < 0 ? "not found" : "found at index " + r.index();
        System.out.printf("%-14s: %d %s | steps=%d | time=%d ns%n", name, key, outcome, r.steps(), r.nanos());
        ResultLog.add("Search", name + " key=" + key + " " + outcome + ", steps=" + r.steps() + ", time=" + r.nanos() + "ns");
    }

    // ------------------------------------------------------------------ GRAPH
    private static void graphMenu() {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Find Shortest Path (BFS search)");
            System.out.println("7. Load Sample Graph");
            System.out.println("8. Return to Main Menu");
            try {
                switch (InputHelper.readInt("Enter your choice: ", 1, 8)) {
                    case 1 -> {
                        String v = InputHelper.readNonEmpty("Vertex name: ");
                        System.out.println(GRAPH.addVertex(v) ? "Vertex added." : "Vertex already exists.");
                    }
                    case 2 -> {
                        String a = InputHelper.readNonEmpty("From vertex: ");
                        String b = InputHelper.readNonEmpty("To vertex: ");
                        GRAPH.addEdge(a, b);
                        System.out.println("Edge added.");
                    }
                    case 3 -> GRAPH.display();
                    case 4 -> traverse(true);
                    case 5 -> traverse(false);
                    case 6 -> {
                        requireNonEmptyGraph();
                        String a = InputHelper.readNonEmpty("From vertex: ");
                        String b = InputHelper.readNonEmpty("To vertex: ");
                        List<String> path = GRAPH.shortestPath(a, b);
                        System.out.println(path.isEmpty() ? "No path exists."
                                : "Shortest path: " + String.join(" -> ", path) + "  (" + (path.size() - 1) + " edges)");
                    }
                    case 7 -> loadSampleGraph();
                    case 8 -> { return; }
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("  ! " + e.getMessage());
            }
        }
    }

    private static void requireNonEmptyGraph() {
        if (GRAPH.vertexCount() == 0) throw new IllegalStateException("Graph is empty. Add vertices first.");
    }

    private static void traverse(boolean bfs) {
        requireNonEmptyGraph();
        String start = InputHelper.readNonEmpty("Start vertex: ");
        Graph.TraversalResult r = bfs ? GRAPH.bfs(start) : GRAPH.dfs(start);
        String name = bfs ? "BFS" : "DFS";
        System.out.println(name + " order: " + String.join(" -> ", r.order()));
        System.out.println("Steps: " + r.steps() + " | Time: " + r.nanos() + " ns");
        ResultLog.add("Graph " + name, "start=" + start + " order=" + r.order() + ", steps=" + r.steps());
    }

    /** Sample graph used for demonstrations: A-B, A-C, B-D, B-E, C-F, E-F. */
    private static void loadSampleGraph() {
        String[] vs = {"A", "B", "C", "D", "E", "F"};
        for (String v : vs) GRAPH.addVertex(v);
        String[][] edges = {{"A", "B"}, {"A", "C"}, {"B", "D"}, {"B", "E"}, {"C", "F"}, {"E", "F"}};
        for (String[] e : edges) {
            if (!GRAPH.hasEdge(e[0], e[1])) GRAPH.addEdge(e[0], e[1]);
        }
        System.out.println("Sample graph loaded (vertices A-F).");
        GRAPH.display();
    }

    // ------------------------------------------------------------ PERFORMANCE
    private static void performanceMenu() {
        System.out.println("\n--------------- PERFORMANCE COMPARISON ---------------");
        int n = InputHelper.readInt("Array size n (10 - 2,000,000): ", 10, 2_000_000);
        int v = InputHelper.readInt("Graph vertices V (5 - 50,000): ", 5, 50_000);
        PerformanceAnalyzer.run(n, v);
    }
}
