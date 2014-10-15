package libGraph;

import libGraph.util.*;

/**
 * Created by Mohammed Alshehry, 201138010 on 5/5/14.
 */
    class Graph<T extends Comparable> {

    protected LinkedList<Vertex<T>> vertices;

    public Graph() {
        vertices = new LinkedList<Vertex<T>>();
    }

    public Graph(Graph<T> g) {
        this();
        try {
            for(LinkedListNode<Vertex<T>> p = g.vertices.getHead(); p != null; p = p.getNext())
                this.addVertex(p.getData().getData());
            for(LinkedListNode<Vertex<T>> p = g.vertices.getHead(); p != null; p = p.getNext()) {
                for (LinkedListNode<Edge<T>> q = p.getData().edges.getHead(); q != null; q = q.getNext())
                    this.addEdge(q.getData().from.getData(), q.getData().to.getData());
            }
        } catch (ElementNotFoundException e) {
            throw new FatalErrorException();
        } catch (DuplicateElementException e) {
            throw new FatalErrorException();
        }
    }

    public LinkedList<Vertex<T>> getVertices() {
        return vertices;
    }

    public void setVertices(LinkedList<Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    public void addVertex(T data) throws DuplicateElementException {
        vertices.add(new Vertex<T>(data));
    }

    public void addEdge(T from, T to) throws ElementNotFoundException, DuplicateElementException {
        Vertex<T> f = vertices.find(new Vertex<T>(from));
        Vertex<T> t = vertices.find(new Vertex<T>(to));

        f.addEdge(new Edge<T>(f, t));
    }

    public void deleteVertex(T data) throws ElementNotFoundException, EmptyLinkedListException {
        vertices.delete(new Vertex<T>(data));

        for(LinkedListNode<Vertex<T>> p = vertices.getHead(); p != null; p = p.getNext()) {
            try {
                p.getData().deleteEdge(new Edge<T>(p.getData(), new Vertex<T>(data)));
            }
            catch(ElementNotFoundException e){}
            catch(EmptyLinkedListException e){}
        }
    }

    public void deleteEdge(T from, T to) throws ElementNotFoundException, EmptyLinkedListException {
        boolean flage = true;
        for(LinkedListNode<Vertex<T>> p = vertices.getHead(); p != null; p = p.getNext())
            try{
                p.getData().deleteEdge(new Edge<T>(new Vertex<T>(from), new Vertex<T>(to)));
                flage = false;
            }
            catch(ElementNotFoundException e) {}

        if(flage)
            throw new ElementNotFoundException();
    }

    public void preOrder() {
        Graph<T> tmp = new Graph<T>(this);
        for(LinkedListNode<Vertex<T>> p = tmp.vertices.getHead(); p != null; p = p.getNext())
            if(!p.getData().isVisited())
                preOrder(p.getData());
    }

    private void preOrder(Vertex<T> v) {
        if(!v.isVisited()) {
            System.out.println(v);
            v.markVisited();
            for(LinkedListNode<Edge<T>> p = v.edges.getHead(); p != null; p = p.getNext()) {
                if(!p.getData().to.isVisited())
                    preOrder(p.getData().to);
            }
        }
    }   //CHANGE RETURN TYPE TO STRING

    public void postOrder() {
        Graph<T> tmp = new Graph<T>(this);
        for(LinkedListNode<Vertex<T>> p = tmp.vertices.getHead(); p != null; p = p.getNext())
            if(!p.getData().isVisited())
                postOrder(p.getData());
    }

    private void postOrder(Vertex<T> v) {
        if(!v.isVisited()) {
            v.markVisited();
            for(LinkedListNode<Edge<T>> p = v.edges.getHead(); p != null; p = p.getNext()) {
                if(!p.getData().to.isVisited())
                    postOrder(p.getData().to);
            }
            System.out.println(v);
        }
    }   //CHANGE RETURN TYPE TO STRING

    public void breadthFirst() throws DuplicateElementException, ElementNotFoundException, EmptyLinkedListException {
        Queue<Vertex<T>> q = new Queue<Vertex<T>>();
        Graph<T> tmp = new Graph<T>(this);
        try {
            for (LinkedListNode<Vertex<T>> p = tmp.vertices.getHead(); p != null; p = p.getNext()) {
                if (!p.getData().isVisited()) {
                    q.enqueue(p.getData());
                    p.getData().markVisited();
                    while (!q.isEmpty()) {
                        Vertex<T> v = q.dequeue();
                        System.out.println(v);
                        for (LinkedListNode<Edge<T>> n = v.edges.getHead(); n != null; n = n.getNext()) {
                            if (!n.getData().to.isVisited()) {
                                q.enqueue(n.getData().to);
                                n.getData().to.markVisited();
                            }
                        }
                    }
                }
            }
        } catch(DuplicateElementException e) {
            throw new FatalErrorException();
        }
    }

    public int inDig(T data) throws ElementNotFoundException {
        int count = 0;
        Vertex<T> v = vertices.find(new Vertex<T>(data));
        for(LinkedListNode<Vertex<T>> p = vertices.getHead(); p != null; p = p.getNext()) {
            if(p.getData().compareTo(v) != 0) {
                for(LinkedListNode<Edge<T>> q = p.getData().edges.getHead(); q != null; q = q.getNext()) {
                    if(q.getData().to.compareTo(v) == 0)
                        ++count;
                }
            }
        }
        return count;
    }

    public int outDig(T data) throws ElementNotFoundException {
        Vertex<T> v = vertices.find(new Vertex<T>(data));
        return v.outDig();
    }

    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    public int size() {
        return vertices.length();
    }

    public String toString() {
        return vertices.toString();
    }

}
