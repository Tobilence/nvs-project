package at.spengergasse.nvsproject.exception;

/**
 * The exception that gets thrown when any database related error occurs
 */
public class PersistenceException extends RuntimeException {

    public PersistenceException(String message){
        super(message);
    }
}
