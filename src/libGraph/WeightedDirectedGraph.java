package libGraph;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import libGraph.util.*;

/**
 * Created by Mohammed Alshehry, 201138010 on 5/7/14.
 */
public class WeightedDirectedGraph<T extends Comparable> extends DirectedGraph<T> {

    public WeightedDirectedGraph() {
        super();
    }

    public void addVertex(T data) throws DuplicateElementException {
        vertices.add(new WeightedVertex<T>(data));
    }

    public void addEdge(T from, T to, double weight) throws ElementNotFoundException, DuplicateElementException {
        WeightedVertex<T> v1 = (WeightedVertex<T>) vertices.find(new WeightedVertex<T>(from));
        WeightedVertex<T> v2 = (WeightedVertex<T>) vertices.find(new WeightedVertex<T>(to));

        v1.addEdge(new WeightedEdge<T>(v1, v2, weight));
    }

    public void addEdge(T from, T to) throws ElementNotFoundException, DuplicateElementException {
        addEdge(from, to, 0);
    }

    public String DijkstraShortestPath(T from) throws ElementNotFoundException, DuplicateElementException, EmptyLinkedListException {
        WeightedVertex<T> start = (WeightedVertex<T>) vertices.find(new WeightedVertex<T>(from));

        LinkedList<Vertex<T>> list = new LinkedList<Vertex<T>>(vertices);
        LinkedList<WeightedVertex<T>> path = new LinkedList<WeightedVertex<T>>();

        WeightedVertex<T> actv = start;
        start.distance = 0;

        while(!list.isEmpty()) {
            actv = min(list);
            list.delete(actv);
            for(LinkedListNode<Edge<T>> p = actv.edges.getHead(); p != null; p = p.getNext()) {
                WeightedEdge<T> e = (WeightedEdge<T>) p.getData();
                WeightedVertex<T> v = (WeightedVertex<T>) e.to;
                if(v.distance > actv.distance + e.weight) {
                    v.distance = actv.distance + e.weight;
                    v.pre = actv;
                }
            }
            try{
                if((actv.pre != null))
                    path.add(actv.pre);
            } catch(DuplicateElementException e) {}
        }
        return path.toString();
    }

    private WeightedVertex<T> min(LinkedList<Vertex<T>> list) {
        WeightedVertex<T> min = (WeightedVertex<T>) list.getHead().getData();

        for(LinkedListNode<Vertex<T>> p = list.getHead(); p != null; p = p.getNext()) {
            WeightedVertex<T> tmp = (WeightedVertex<T>) p.getData();
            if(min.distance - tmp.distance > 0)
                min = tmp;
        }
        return min;
    }
}
