package lab3;

/**
 *
 * @author cscherbert1
 */
public class MandatoryStringException extends IllegalArgumentException{
    /*
    IllegalArgumentException is unchecked. Is that ok?
        this problem of a bad last name wont cause harm, so unchecked should be fine. 
    */
    
    //custom message. we want this to be used every time. 
    private final static String msg = "Method argument is mandatory.";
    
    /*
        must have every constructor from the superclass exception
    */
    public MandatoryStringException() {
        //msg must be static in order for it to belong to the class, and not the instance. if not static, the following line will fail. 
        super(msg);
    }

    public MandatoryStringException(String s) {
        //dont allow programmers to set their own message. Always use ours. 
        super(msg);
    }

    public MandatoryStringException(String message, Throwable cause) {
        super(msg, cause);
    }

    public MandatoryStringException(Throwable cause) {
        super(cause);
    }
    
}
