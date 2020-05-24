package exceptions;

import java.io.IOException;

public class NegativeValueException extends IOException {
    public NegativeValueException(String message) {
        super(message);
    }
}
