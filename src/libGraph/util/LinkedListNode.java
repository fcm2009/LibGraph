package libGraph.util;

/**
 * Created by Mohammed Alshehry, 201138010 on 5/5/14.
 */
public class LinkedListNode<T extends Comparable> implements Comparable<T>, Cloneable {

    protected LinkedListNode<T> next;
    protected T data;

    public LinkedListNode(T data, LinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public LinkedListNode(T data) {
        this.data = data;
    }

    public LinkedListNode() {
        this(null, null);
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return data.toString();
    }

    public int compareTo(T data) {
        if(data != null) {
            return this.data.compareTo(data);
        }
        else
            throw new NullPointerException();
    }

}
