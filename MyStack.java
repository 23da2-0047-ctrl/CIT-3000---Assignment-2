/** Generic LIFO stack implemented with a resizable array. All operations are O(1) (amortised). */
public class MyStack<T> {
    private Object[] items = new Object[8];
    private int top = -1;

    public boolean isEmpty() { return top == -1; }

    public int size() { return top + 1; }

    public void push(T value) {
        if (top == items.length - 1) {
            items = java.util.Arrays.copyOf(items, items.length * 2);
        }
        items[++top] = value;
    }

    /** @throws IllegalStateException on stack underflow */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow: cannot pop from an empty stack.");
        }
        T value = (T) items[top];
        items[top--] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty: nothing to peek.");
        }
        return (T) items[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("TOP -> ");
        for (int i = top; i >= 0; i--) {
            sb.append(items[i]);
            if (i > 0) sb.append(" | ");
        }
        System.out.println(sb.append(" <- BOTTOM"));
    }
}
