package Level2_05_02_2026;

import java.io.IOException;

class CustomRuntimeException extends RuntimeException {
    public CustomRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class ExceptionWrapper {
    public void throwWrappedException() {
        try {
            // Simulate an operation that throws an IOException
            throw new IOException("Original IOException");
        } catch (IOException e) {
            throw new CustomRuntimeException("Wrapped exception", e);
        }
    }

    public void handleException() {
        try {
            throwWrappedException();
        } catch (CustomRuntimeException e) {
            System.err.println("Caught CustomRuntimeException: " + e.getMessage());
            System.err.println("Original cause: " + e.getCause().getMessage());
        }
    }

    public static void main(String[] args) {
        ExceptionWrapper wrapper = new ExceptionWrapper();
        wrapper.handleException();
    }
}
