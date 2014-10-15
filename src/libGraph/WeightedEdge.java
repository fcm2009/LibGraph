package libGraph;

/**
 * Created by Mohammed Alshehry, 201138010 on 5/7/14.
 */
public class WeightedEdge<T extends Comparable> extends Edge<T> {

    protected double weight;

    public WeightedEdge(Vertex<T> from, Vertex<T> to, double weight) {
        super(from, to);
        this.weight = weight;
    }

    public WeightedEdge() {
        this(null, null, 0);
    }

    public String toString() {
        return super.toString() + " weight = " + weight;
    }

}
