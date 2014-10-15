package libGraph;

import libGraph.util.DuplicateElementException;
import libGraph.util.ElementNotFoundException;

/**
 * Created by Mohammed Alshehry, 201138010 on 5/6/14.
 */
public class UndirectedGraph<T extends Comparable> extends Graph<T> {

    public UndirectedGraph() {
        super();
    }

    public void addEdge(T from, T to) throws ElementNotFoundException, DuplicateElementException {
        super.addEdge(from, to);
        super.addEdge(to, from);
    }
}
