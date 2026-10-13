/** Linear and binary search on int arrays, each reporting steps and execution time. */
public final class SearchOperations {

    /** Result holder: index (-1 if not found), comparisons made, elapsed nanoseconds. */
    public record SearchResult(int index, int steps, long nanos) { }

    private SearchOperations() { }

    /** O(n): checks elements one by one. */
    public static SearchResult linearSearch(int[] arr, int key) {
        long start = System.nanoTime();
        int steps = 0;
        int found = -1;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == key) { found = i; break; }
        }
        return new SearchResult(found, steps, System.nanoTime() - start);
    }

    /** O(log n): requires a SORTED array; halves the search range every step. */
    public static SearchResult binarySearch(int[] arr, int key) {
        long start = System.nanoTime();
        int steps = 0;
        int low = 0, high = arr.length - 1, found = -1;
        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;     // avoids int overflow
            if (arr[mid] == key) { found = mid; break; }
            if (arr[mid] < key) low = mid + 1; else high = mid - 1;
        }
        return new SearchResult(found, steps, System.nanoTime() - start);
    }
}
