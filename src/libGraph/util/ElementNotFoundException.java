package libGraph.util;

/**
 * Created by Mohammed Alshehry, 201138010 on 5/5/14.
 */
public class ElementNotFoundException extends Exception {

    public ElementNotFoundException(String message) {
        super(message);
    }

    public ElementNotFoundException() {
        this("Element Is Not Found");
    }
}
