package libGraph.util;

/**
 * Created by Mohammed Alshehry, 201138010 on 5/5/14.
 */
public class Queue<T extends Comparable> {

    protected LinkedList<T> list;

    public Queue() {
        list = new LinkedList<T>();
    }

    public void enqueue(T data) throws DuplicateElementException {
        list.add(data);
    }

    public T dequeue() throws ElementNotFoundException, EmptyLinkedListException {
        return list.deleteHead();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public String toString() {
        return list.toString();
    }

    public int length() {
        return list.length();
    }

}
