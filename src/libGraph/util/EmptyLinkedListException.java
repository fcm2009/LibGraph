package libGraph.util;

/**
 * Created by Mohammed Alshehry, 201138010 on 5/5/14.
 */
public class EmptyLinkedListException extends Exception {

    public EmptyLinkedListException(String message) {
    	super(message);
    }

    public EmptyLinkedListException() {
    	this("Linked List is Empty");
    }
}