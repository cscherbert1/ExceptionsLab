package lab3;

/**
 *
 * @author cscherbert1
 */
public class IllegalFormatException extends IllegalArgumentException{
    
    private static final String msg = "Input is formatted incorrectly.";

    public IllegalFormatException() {
        super(msg);
    }

    public IllegalFormatException(String s) {
        super(msg);
    }

    public IllegalFormatException(String message, Throwable cause) {
        super(msg, cause);
    }

    public IllegalFormatException(Throwable cause) {
        super(cause);
    }
    
}
