package exceptions;

public class NotValidExecutionOptionException extends RuntimeException {
    public NotValidExecutionOptionException(String option) { super("'" + option + "' is not a valid execution option"); }
}
