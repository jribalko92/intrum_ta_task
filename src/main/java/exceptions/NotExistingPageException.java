package exceptions;

public class NotExistingPageException extends RuntimeException {
    public NotExistingPageException(String page) {
        super("This page does not exist: " + page);
    }
}
