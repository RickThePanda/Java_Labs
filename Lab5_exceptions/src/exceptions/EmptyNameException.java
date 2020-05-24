package exceptions;

import java.io.IOException;

public class EmptyNameException extends IOException {
    public EmptyNameException(String message) {
        super(message);
    }
}
