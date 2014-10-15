package libGraph.util;

/**
 * Created by Mohammed Alshehry, 201138010 on 5/5/14.
 */
public class FatalErrorException extends RuntimeException {

    public FatalErrorException(String mesagge) {
        super(mesagge);
    }

    public FatalErrorException() {
        this("Fatal Error Happened, Try Again Later");
    }
}
