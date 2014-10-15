package libGraph;

import libGraph.util.*;

/**
 * Created by Mohammed Alshehry, 201138010 on 5/9/14.
 */
public class WeightedUndirectedGraph<T extends Comparable> extends UndirectedGraph<T> {

    public WeightedUndirectedGraph() {
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

    public void PrimMinimumSpanningTree(T start) throws ElementNotFoundException, DuplicateElementException, EmptyLinkedListException {
        Graph<T> g = new Graph<T>(this);
        WeightedUndirectedGraph<T> wug = new WeightedUndirectedGraph<T>();
        T tmp = g.vertices.getHead().getData().getData();
        wug.addVertex(tmp);
        g.deleteVertex(tmp);

        while(!g.isEmpty()) {
            System.out.print(4);
        }

    }

    public WeightedEdge<T> min() {
        WeightedEdge<T> min = (WeightedEdge<T>) this.vertices.getHead().getData().edges.getHead().getData();
        for(LinkedListNode<Vertex<T>> p = this.vertices.getHead(); p != null; p = p.getNext()) {
            for(LinkedListNode<Edge<T>> q = p.getData().edges.getHead(); q != null; q = q.getNext()) {
                if (q.getData().compareTo(min) < 0)
                    min = (WeightedEdge) q.getData();
            }
        }
        return min;
    }
}
