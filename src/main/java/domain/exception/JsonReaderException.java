package domain.exception;

public class JsonReaderException extends LibraryException {
    public JsonReaderException(String message) {
        super(message);
    }

    public JsonReaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
