/** Generic FIFO queue implemented as a circular array. All operations are O(1) (amortised). */
public class MyQueue<T> {
    private Object[] items = new Object[8];
    private int front = 0;
    private int count = 0;

    public boolean isEmpty() { return count == 0; }

    public int size() { return count; }

    public void enqueue(T value) {
        if (count == items.length) grow();
        items[(front + count) % items.length] = value;
        count++;
    }

    /** @throws IllegalStateException on queue underflow */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow: cannot dequeue from an empty queue.");
        }
        T value = (T) items[front];
        items[front] = null;
        front = (front + 1) % items.length;
        count--;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty: no front element.");
        }
        return (T) items[front];
    }

    private void grow() {
        Object[] bigger = new Object[items.length * 2];
        for (int i = 0; i < count; i++) {
            bigger[i] = items[(front + i) % items.length];
        }
        items = bigger;
        front = 0;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("FRONT -> ");
        for (int i = 0; i < count; i++) {
            sb.append(items[(front + i) % items.length]);
            if (i < count - 1) sb.append(" | ");
        }
        System.out.println(sb.append(" <- REAR"));
    }
}
