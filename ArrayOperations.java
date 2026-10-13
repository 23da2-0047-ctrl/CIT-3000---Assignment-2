import java.util.Arrays;

/**
 * Dynamic integer array built on a plain int[].
 * Capacity doubles automatically when full.
 */
public class ArrayOperations {
    private int[] data;
    private int size;

    public ArrayOperations() {
        data = new int[8];
        size = 0;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    /** Insert at end - O(1) amortised. Returns number of steps (1). */
    public int insertAtEnd(int value) {
        ensureCapacity();
        data[size++] = value;
        return 1;
    }

    /**
     * Insert at index (0..size) - O(n) because later elements shift right.
     * @return number of element shifts performed
     */
    public int insertAt(int index, int value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index must be between 0 and " + size);
        }
        ensureCapacity();
        int shifts = 0;
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
            shifts++;
        }
        data[index] = value;
        size++;
        return shifts;
    }

    /** Delete by index - O(n). Returns the removed value. */
    public int deleteAt(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty. Nothing to delete.");
        }
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index must be between 0 and " + (size - 1));
        }
        int removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removed;
    }

    /** Linear search - returns index of first match or -1. */
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }

    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Bad index " + index);
        return data[index];
    }

    public void sort() { Arrays.sort(data, 0, size); }

    public boolean isSorted() {
        for (int i = 1; i < size; i++) {
            if (data[i - 1] > data[i]) return false;
        }
        return true;
    }

    /** Defensive copy of the used part of the array. */
    public int[] toArray() { return Arrays.copyOf(data, size); }

    public void display() {
        if (isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("Array (size " + size + "): [");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        System.out.println(sb.append("]"));
    }
}
