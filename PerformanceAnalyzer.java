import java.util.Random;

/**
 * Runs the three performance experiments required by the assignment:
 *  1. Linear vs Binary search (worst case: key not present)
 *  2. Insert-at-front: Array (O(n) shifts) vs Linked List (O(1))
 *  3. Graph traversal: BFS vs DFS on a generated connected graph
 */
public final class PerformanceAnalyzer {

    private PerformanceAnalyzer() { }

    public static void run(int arraySize, int graphVertices) {
        System.out.println("\n=============================================");
        System.out.println("PERFORMANCE COMPARISON");
        System.out.println("  Array size n = " + arraySize + ",  Graph vertices V = " + graphVertices);
        System.out.println("=============================================");
        System.out.printf("%-16s %-20s %12s %14s%n", "Operation", "Algorithm", "Steps", "Time (ns)");
        System.out.println("---------------------------------------------------------------------");

        searchExperiment(arraySize);
        insertExperiment(arraySize);
        graphExperiment(graphVertices);

        System.out.println("=============================================");
        printExplanation(arraySize, graphVertices);
    }

    private static void searchExperiment(int n) {
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) sorted[i] = i * 2;      // even numbers, sorted
        int missingKey = -1;                                  // worst case for both algorithms

        SearchOperations.SearchResult lin = SearchOperations.linearSearch(sorted, missingKey);
        SearchOperations.SearchResult bin = SearchOperations.binarySearch(sorted, missingKey);
        row("Search", "Linear Search", lin.steps(), lin.nanos());
        row("Search", "Binary Search", bin.steps(), bin.nanos());
        ResultLog.add("Performance", "n=" + n + " | Linear steps=" + lin.steps() + ", Binary steps=" + bin.steps());
    }

    private static void insertExperiment(int n) {
        ArrayOperations array = new ArrayOperations();
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < n; i++) {
            array.insertAtEnd(i);
            list.insertAtTail(i);
        }
        long t0 = System.nanoTime();
        int arrayShifts = array.insertAt(0, -1);
        long arrayTime = System.nanoTime() - t0;

        t0 = System.nanoTime();
        int listSteps = list.insertAtHead(-1);
        long listTime = System.nanoTime() - t0;

        row("Insert at front", "Array", arrayShifts, arrayTime);
        row("Insert at front", "Linked List", listSteps, listTime);
        ResultLog.add("Performance", "n=" + n + " | Array insert-front shifts=" + arrayShifts
                + ", Linked List steps=" + listSteps);
    }

    private static void graphExperiment(int v) {
        Graph g = buildRandomConnectedGraph(v, 3, 42L);
        Graph.TraversalResult bfs = g.bfs("V0");
        Graph.TraversalResult dfs = g.dfs("V0");
        row("Graph Traversal", "BFS", bfs.steps(), bfs.nanos());
        row("Graph Traversal", "DFS", dfs.steps(), dfs.nanos());
        ResultLog.add("Performance", "V=" + v + ", E=" + g.edgeCount() + " | BFS steps=" + bfs.steps()
                + ", DFS steps=" + dfs.steps());
    }

    /** Spanning tree first (guarantees connectivity) then random extra edges. Seeded = repeatable. */
    static Graph buildRandomConnectedGraph(int vertices, int edgesPerVertex, long seed) {
        Random rnd = new Random(seed);
        Graph g = new Graph();
        for (int i = 0; i < vertices; i++) g.addVertex("V" + i);
        for (int i = 1; i < vertices; i++) g.addEdge("V" + i, "V" + rnd.nextInt(i));
        int extra = vertices * (edgesPerVertex - 1);
        for (int k = 0; k < extra && vertices > 2; k++) {
            String a = "V" + rnd.nextInt(vertices);
            String b = "V" + rnd.nextInt(vertices);
            if (!a.equals(b) && !g.hasEdge(a, b)) g.addEdge(a, b);
        }
        return g;
    }

    private static void row(String op, String algo, int steps, long nanos) {
        System.out.printf("%-16s %-20s %12d %14d%n", op, algo, steps, nanos);
    }

    private static void printExplanation(int n, int v) {
        int log = (int) Math.ceil(Math.log(n + 1) / Math.log(2));
        System.out.println("WHY DO THE RESULTS DIFFER?");
        System.out.println("- Linear search is O(n): worst case checks all " + n + " items.");
        System.out.println("- Binary search is O(log n): about log2(" + n + ") = " + log + " steps, because it halves the range each time (needs sorted data).");
        System.out.println("- Array insert at front is O(n): every element shifts one place. A linked list only re-points the head, O(1).");
        System.out.println("- BFS and DFS are both O(V + E): each vertex and edge is processed once, so step counts are similar;");
        System.out.println("  they differ only in visiting ORDER (BFS = queue, level by level; DFS = stack, deep first).");
        System.out.println("- Time (ns) is machine dependent and noisy for tiny runs; step counts show the true complexity.");
    }
}
