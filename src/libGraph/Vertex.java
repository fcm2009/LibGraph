package libGraph;

import libGraph.util.DuplicateElementException;
import libGraph.util.ElementNotFoundException;
import libGraph.util.EmptyLinkedListException;
import libGraph.util.LinkedList;

/**
 * Created by Mohammed Alshehry, 201138010 on 5/5/14.
 */
public class Vertex<T extends Comparable> implements Comparable {

    protected T data;
    protected LinkedList<Edge<T>> edges;
    protected boolean visited;

    public Vertex(T data) {
        this.data = data;
        edges = new LinkedList<Edge<T>>();
        visited = false;
    }

    public Vertex(Vertex<T> v) {
        this.data = v.data;
        this.edges = edges;
        this.visited = v.visited;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public final LinkedList<Edge<T>> getEdges() {
        return edges;
    }

    public void setEdges(LinkedList<Edge<T>> edges) {
        this.edges = edges;
    }

    public void addEdge(Edge<T> e) throws DuplicateElementException {
        edges.add(e);
    }

    public void deleteEdge(Edge<T> e) throws ElementNotFoundException, EmptyLinkedListException {
        edges.delete(e);
    }

    public int outDig() {
        return edges.length();
    }

    public void markVisited() {
        visited = true;
    }

    public boolean isVisited() {
        return visited;
    }

    public String toString() {
        return data.toString();
    }

    public int compareTo(Object obj) {
        if(obj != null) {
            if(obj instanceof Vertex) {
                Vertex<T> v = (Vertex<T>) obj;
                return data.compareTo(v.data);
            }
            else
                throw new ClassCastException();
        }
        else
            throw new NullPointerException();
    }

    public boolean equals(Object obj) {
        return compareTo(obj) == 0;
    }
}
