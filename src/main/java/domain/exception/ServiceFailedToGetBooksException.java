package domain.exception;

public class ServiceFailedToGetBooksException extends LibraryException {
    public ServiceFailedToGetBooksException(String message) {
        super(message);
    }

    public ServiceFailedToGetBooksException(String message, Throwable cause) {
        super(message, cause);
    }
}
