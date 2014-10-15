package libGraph;

import libGraph.util.ElementNotFoundException;
import libGraph.util.EmptyLinkedListException;
import libGraph.util.LinkedListNode;

/**
 * Created by Mohammed Alshehry, 201138010 on 5/6/14.
 */
public class DirectedGraph<T extends Comparable> extends Graph<T> {

    public DirectedGraph() {
        super();
    }

    public void topologicalSort() throws ElementNotFoundException, EmptyLinkedListException {
        Graph<T> g = new Graph<T>(this);
        while(!g.isEmpty()) {
            for(LinkedListNode<Vertex<T>> p = g.vertices.getHead(); p != null; p = p.getNext()) {
                if(g.inDig(p.getData().data) == 0) {
                    System.out.println(p);
                    g.deleteVertex(p.getData().getData());
                }
            }
        }
    }

}
