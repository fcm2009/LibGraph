package libGraph;


/**
 * Created by fcm2009 on 4/28/14.
 */
public class Edge<T extends Comparable> implements Comparable {

    protected Vertex<T> from;
    protected Vertex<T> to;

    public Edge(Vertex<T> from, Vertex<T> to) {
        this.from = from;
        this.to = to;
    }

    public Edge() {
        this(null, null);
    }

    public String toString() {
        return "(" + from.data.toString() + ", " + to.data.toString() + ")";
    }

    public int compareTo(Object obj) {
        if(obj != null) {
            if(obj.getClass() == getClass()) {
                Edge<T> e = (Edge<T>) obj;
                return (from.compareTo(e.from) == 0) ? to.compareTo(e.to) : from.compareTo(e.from);
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
