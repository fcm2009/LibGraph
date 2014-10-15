package libGraph;

/**
 * Created by Mohammed Alshehry, 201138010 on 5/8/14.
 */
public class WeightedVertex<T extends Comparable> extends Vertex<T> {

    protected double distance;
    protected WeightedVertex<T> pre;

    public WeightedVertex(T data, double distance, WeightedVertex<T> pre) {
        super(data);
        this.distance = distance;
        this.pre = pre;
    }

    public WeightedVertex(T data) {
        this(data, Double.POSITIVE_INFINITY, null);
    }

    public WeightedVertex(WeightedVertex<T> v) {
        super(v);
        this.distance = v.distance;
        this.pre = v.pre;
    }

}
