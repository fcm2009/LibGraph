package libGraph.util;

/**
 * Created by Mohammed Alshehry, 201138010 on 5/5/14.
 */
public class LinkedList<T extends Comparable> {

    protected LinkedListNode<T> head;
    protected LinkedListNode<T> tail;

    public LinkedList() {
        head = tail = null;
    }

    public LinkedList(LinkedList<T> list) {
        this.head = list.head;
        this.tail = list.tail;
    }

    public LinkedListNode<T> getHead() {
        return head;
    }

    public void setHead(LinkedListNode<T> head) {
        this.head = head;
    }

    public LinkedListNode<T> getTail() {
        return tail;
    }

    public void setTail(LinkedListNode<T> tail) {
        this.tail = tail;
    }

    public void add(T data) throws DuplicateElementException {
    	if(data == null)
    		throw new IllegalArgumentException();
    	else if(isEmpty())
    		head = tail = new LinkedListNode<T>(data);
        else if(isDup(data))
            throw new DuplicateElementException();
    	else if(head == tail)
    		head.next = tail = new LinkedListNode<T>(data);
    	else {
    		tail = tail.next = new LinkedListNode<T>(data);
    	}
    }

    public void addBefore(T before, T data) throws EmptyLinkedListException, ElementNotFoundException, DuplicateElementException {
        if(before == null || data == null)
            throw new IllegalArgumentException();
        else if(isEmpty())
            throw new EmptyLinkedListException();
        else if(isDup(data))
            throw new DuplicateElementException();
        else if(head.compareTo(data) == 0)
            head = new LinkedListNode<T>(data, head);
    	else {
            LinkedListNode<T>[] tmp = prev(before);
            LinkedListNode<T> prev = tmp[0];
            LinkedListNode<T> p = tmp[1];

            prev.next = new LinkedListNode<T>(data, p);
        }
    }

    public void addAfter(T after, T data) throws EmptyLinkedListException, ElementNotFoundException, DuplicateElementException {
        if(after == null || data == null)
            throw new IllegalArgumentException();
        else if(isEmpty())
            throw new EmptyLinkedListException();
        else if(isDup(data))
            throw new DuplicateElementException();
        else if(tail.compareTo(after) == 0)
            add(data);
        else {
            LinkedListNode<T>[] tmp = prev(after);
            LinkedListNode<T> p = tmp[1];

            p.next = new LinkedListNode<T>(data, p.next);
        }

    }

    public T delete(T data) throws ElementNotFoundException, EmptyLinkedListException {
        if(data == null)
            throw new IllegalArgumentException();
        else if(isEmpty())
            throw new EmptyLinkedListException();
        else if(head.compareTo(data) == 0)
            return deleteHead();
        else if(tail.compareTo(data) == 0)
            return deleteTail();
        else {
            LinkedListNode<T>[] tmp = prev(data);
            LinkedListNode<T> prev = tmp[0];
            LinkedListNode<T> p = tmp[1];
            prev.next = p.next;
            return p.data;
        }
    }

    public T deleteHead() throws EmptyLinkedListException {
        if(isEmpty())
            throw new EmptyLinkedListException();
        else if(head == tail) {
            T tmp = head.data;
            clear();
            return tmp;
        }
        else {
            T tmp = head.data;
            head = head.next;
            return tmp;
        }
    }

    public T deleteTail() throws EmptyLinkedListException {
        if(isEmpty())
            throw new EmptyLinkedListException();
        else if(head == tail) {
            T tmp = head.data;
            clear();
            return tmp;
        }
        else {
            try {
                LinkedListNode<T>[] tmp = prev(tail.data);
                LinkedListNode<T> prev = tmp[0];
                LinkedListNode<T> p = tmp[1];
                prev.next = null;
                tail = prev;
                return p.data;
            } catch(ElementNotFoundException e) {
                throw new FatalErrorException();
            }
        }
    }

    public T find(T data) throws ElementNotFoundException {
        return prev(data)[1].data;
    }

    public boolean isDup(T data) {
        try {
            find(data);
            return true;
        }
        catch(ElementNotFoundException e) {
            return false;
        }
    }

    private LinkedListNode<T>[] prev(T data) throws ElementNotFoundException {
        if(data == null)
            throw new IllegalArgumentException();

        LinkedListNode<T> p, prev;
        for(p = head, prev = null; p != null && p.compareTo(data) != 0; prev = p,p = p.next);
        if(p == null)
            throw new ElementNotFoundException();
        else
            return new LinkedListNode[] {prev, p};
    }

    public Queue<T> toQueue() {
        Queue<T> tmp = new Queue<T>();
        tmp.list = this;
        return tmp;
    }

    public T min() {
        T min = this.getHead().getData();
        for(LinkedListNode<T> p = this.getHead(); p != null; p = p.getNext()) {
            if(p.compareTo(min) < 0)
                min = p.getData();
        }
        return min;
    }

    public void clear() {
        head = tail = null;
    }

    public int length() {
        int i = 0;
        for(LinkedListNode<T> p = head; p != null;p = p.next)
            ++i;
        return i;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
    	String tmp = "";
    	for(LinkedListNode<T> p = head; p != null; p = p.next)
    		tmp += p.toString() + " ";
    	return tmp;
    }
}
