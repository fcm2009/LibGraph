package libGraph.util;

/**
 * Created by fcm2009 on 5/3/14.
 */
public class DuplicateElementException extends Exception {

    public DuplicateElementException(String message) {
        super(message);
    }

    public DuplicateElementException() {
        this("Element Already Exists");
    }

}
