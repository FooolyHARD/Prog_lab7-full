package exceptions;

public class DatabaseAuthorizationException extends Exception {
    public DatabaseAuthorizationException(String message){
        super(message);
    }
}
